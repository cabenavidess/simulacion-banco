import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class HeapBanco {

	/**
	 * @param args
	 */
	/**
	 * Método principal. Es el que se ejecuta al crear esta clase.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("              ---------------------------------------");
		System.out.println("              --      Bienvenido al banco UVG      --");
		System.out.println("              ---------------------------------------");
		System.out.println("A continuacion ingrese el tiempo de llegada de cada cliente: ");
		
		CircularQueue<Client<Integer>> ventanilla1 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla2 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla3 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla4 = new CircularQueue<Client<Integer>>();
		
		PriorityQueueHeap<Client<Integer>> eventos = new PriorityQueueHeap<Client<Integer>>(1000);
		
		
		int entrada[]=new int[40];				//Arreglo que almacena los datos de ingreso especificados por el usuario
		
		int t_arrival=0;
		int clientes_ingresados=0;				//Contiene el numero de tiempos ingresados por el usuario
		
		int tiempos[]=new int[4];
		int total=0;	
		
			do{
				t_arrival = (int)ingresar("Cliente "+(clientes_ingresados +1)+"(o -1 para terminar): ", "El dato ingresado no es valido");
				if(clientes_ingresados==0){
					if(t_arrival>0 && t_arrival<481){
						entrada[clientes_ingresados]=t_arrival;
						clientes_ingresados++;
					}else{
						System.out.println(" El tiempo debe ser un numero entre 0 y 480");
					}
				}else{
					if(t_arrival>=entrada[clientes_ingresados-1] && t_arrival<481){
						entrada[clientes_ingresados]=t_arrival;
						clientes_ingresados++;
					}else{
						if(t_arrival>0){
							System.out.println(" El tiempo debe ser un numero entre "+entrada[clientes_ingresados-1]+" y 480");
						}
					}
				}
			}while(t_arrival>=0 && clientes_ingresados<40);
			
			
			
			//System.out.println(" La cantidad de clientes fue: "+clientes_ingresados);
			
			createEventList(eventos,entrada,clientes_ingresados);
			
			tiempos = executeEventList(eventos,entrada,ventanilla1,ventanilla2,ventanilla3,ventanilla4);
		
			total=tiempos[0]+tiempos[1]+tiempos[2]+tiempos[3];
			total=total/clientes_ingresados;
			
			System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(" |  La cantidad de clientes fue: "+clientes_ingresados+"                 |");
			System.out.println(" |  El tiempo promedio de espera es : " + total +"            |" );
			System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++++");
			

	}
	




	/**
	 * Permite Obtener una referencia a la lista cjya dimension sea la más pequeña. Esto es util para 
	 * poder añadir un cliente a esta lista.
	 * @param c1	Representa la ventanilla 1
	 * @param c2	Representa la ventanilla 2
	 * @param c3	Representa la ventanilla 3
	 * @param c4	Representa la ventanilla 4
	 * @return		CircularQueue<Cliente<Integer>> ventanilla 		Referencia a la ventanilla mas corta
	 */
	public static CircularQueue<Client<Integer>> getSmallerQueue(CircularQueue<Client<Integer>> c1,  CircularQueue<Client<Integer>> c2,  CircularQueue<Client<Integer>> c3,  CircularQueue<Client<Integer>> c4){
		
		int sizes[] = new int[4];
		int menor = 0;
		int menor1=0;
		int menor2=0;
		sizes[0] =  c1.size();
		sizes[1] = c2.size();
		sizes[2] = c3.size();
		sizes[3] = c4.size();

		menor1 = Math.min(sizes[0], sizes[1]);
		menor2= Math.min(sizes[2],sizes[3]);
		menor = Math.min(menor1,menor2);
		if(menor == c1.size()){
			return c1;
		}else{
			if(menor == c2.size()){
				return c2;
			}else{
				if(menor == c3.size()){
					return c3;
				}else{
					if(menor == c4.size()){
						return c4;
					}else{
						return c1;
					}
				}
			}
		}
	}
	
	/**
	 * Permite crear la lista de eventos con eventos solamente de entrada de clientes
	 * @param events		Lista de eventos 
	 * @param ingreso		Arreglo con los clientes ingresados
	 */
	public static void createEventList(PriorityQueueHeap<Client<Integer>> events, int[] ingreso,int ingresados){
		Random rand = new Random();
		for(int i=0; i<ingresados;i++){
			events.offer(new Client<Integer>(ingreso[i],rand.nextInt(30)+1,-1));
		}		
	}
	
	/**
	 * Permite ejecutar la lista de eventos. Se encargada de crear eventos de salida, añadir los clientes a las colas y 
	 * retirar a estos clientes. Su ejecución termina cuando la lista de eventos esta vacia
	 * @param events		Lista de eventos a ejecutar
	 * @param ingreso		Lista de clientes a ingresar
	 * @param c1			Ventanilla 1
	 * @param c2			Ventanilla 2
	 * @param c3			Ventanilla 3
	 * @param c4			Ventanilla 4	
	 * @return				Arreglo de tiempos promedio por cada cola
	 */
	public static int[] executeEventList(PriorityQueueHeap<Client<Integer>> events, int[] ingreso, CircularQueue<Client<Integer>> c1,  CircularQueue<Client<Integer>> c2,  CircularQueue<Client<Integer>> c3,  CircularQueue<Client<Integer>> c4){
		//Random rand = new Random();
		
		int[] promedios = new int[4];			//Arreglo que almacena el tiempo promedio para cada 
		promedios[0]=0;							//Tiempo promedio de cola 1
		promedios[1]=0;							//Tiempo promedio de cola 2
		promedios[2]=0;							//Teimpo promedio de cola 3
		promedios[3]=0;							//Tiempo promedio de cola 4
		

		int esperado=0;
		
		CircularQueue<Client<Integer>> cola_temp;		//Este es el evento que se esta ejecutnado actualmente
		
		Client<Integer> temp2 = null;					//Permite guardar una referencia al ultimo elemento de cada ventanilla
		Client<Integer>	temp3 = null;
		Client<Integer>	temp4 = null;
		Client<Integer>	temp5 = null;
		Client<Integer>	temp6 = null;
		Client<Integer>	temp7 = null;
		Client<Integer>	temp8 = null;
		Client<Integer>	temp9 = null;
		Client<Integer>	tempo = null;
		
		//printEventList(events);
		
		do{
		if(!events.isEmpty()){
		
		Client<Integer> temp = events.remove();	//Procesar el primer elemento de la lista de eventos
		
		if(temp.getRetreival()==-1){		//Verificar si es evento de entrada
			cola_temp = getSmallerQueue(c1,c2,c3,c4);	//Obtener cuál de las colas tiene menor tamaño
			if(cola_temp==c1){	//Comparar si la cola de menor tamaño es la cola 1
				if(c1.isEmpty()){
					c1.offer(new Client<Integer>(temp.getArrival(),temp.getDuration(),temp.getArrival()+temp.getDuration())); //Añadir a la cola
					//System.out.println("****************************************************");
					//printEventList(events);
					//System.out.println("****************************************************");
					temp2=c1.element();
					temp3=temp2;
				}else{
					temp3 = new Client<Integer>(temp.getArrival(),temp.getDuration(),temp2.getRetreival()+temp.getDuration());
					c1.offer(temp3);
					temp2= temp3;	
					//System.out.ln("****************************************************");
					//printEventList(events);
					//System.out.println("****************************************************");
					
				}
				
				if(events.isEmpty()){		//Si la lista de eventos esta vacia ahora, añadir el evento de salida sin más
					events.offer(new Client<Integer>(temp3.getRetreival(),1,-2));		// Añadir evento de salida (Ocurrencia, # de cola, -2 indica que es salida)
				}else{						//Si la lista no esta vacia, buscar la posicion en donde debe ir este evento de salida
					Client<Integer> eventosalida = new Client<Integer>(temp3.getRetreival(),1,-2);
					
					events.offer(eventosalida);
					/*
					for(int j=0; j<=events.size(); j++){	//Recorrer toda la lsita de eventos		
						if(j==events.size()){				//Si no hay ningun evento que suceda despues que este evento de salida
							events.add(eventosalida);		// Añadirlo al final
							j=events.size()+3;		
						}
						else if(events.get(j).getArrival()> eventosalida.getArrival()){		//Si el tiempo de ocurrencia del evento en la posicion j es mayor
							if(j==0){
								events.addFirst(eventosalida);
								j=events.size()+3;
							}else{
								events.add(j, eventosalida);								// que el tiempo de ocurrencia del evento de salida, entonces el evento
								j=events.size()+3;											// de salida debe ir antes que este otro evento, y debe terminar la busqueda
							}
						}	
						
					}
					*/
				}
			
			}
			if(cola_temp==c2){	//Comparar si la cola de menor tamaño es la cola 1
				if(c2.isEmpty()){
					c2.offer(new Client<Integer>(temp.getArrival(),temp.getDuration(),temp.getArrival()+temp.getDuration())); //Añadir a la cola
					temp4=c2.element();
					temp5=temp4;
				}else{
					temp5 = new Client<Integer>(temp.getArrival(),temp.getDuration(),temp4.getRetreival()+temp.getDuration());
					c2.offer(temp5);
					temp4= temp5;					
				}
				
				if(events.isEmpty()){		//Si la lista de eventos esta vacia ahora, añadir el evento de salida sin más
					events.offer(new Client<Integer>(temp5.getRetreival(),2,-2));		// Añadir evento de salida (Ocurrencia, # de cola, -2 indica que es salida)
				}else{						//Si la lista no esta vacia, buscar la posicion en donde debe ir este evento de salida
					Client<Integer> eventosalida = new Client<Integer>(temp5.getRetreival(),2,-2);
					events.offer(eventosalida);
					/*
					for(int j=0; j<=events.size(); j++){	//Recorrer toda la lsita de eventos		
						if(j==events.size()){				//Si no hay ningun evento que suceda despues que este evento de salida
							events.add(eventosalida);		// Añadirlo al final
							j=events.size()+3;		
						}
						else if(events.get(j).getArrival()> eventosalida.getArrival()){		//Si el tiempo de ocurrencia del evento en la posicion j es mayor
							if(j==0){
								events.addFirst(eventosalida);
								j=events.size()+3;
							}else{
								events.add(j, eventosalida);								// que el tiempo de ocurrencia del evento de salida, entonces el evento
								j=events.size()+3;											// de salida debe ir antes que este otro evento, y debe terminar la busqueda
							}
						}	
						
					}	
					*/
				}
			
			}
			if(cola_temp==c3){	//Comparar si la cola de menor tamaño es la cola 1
				if(c3.isEmpty()){
					c3.offer(new Client<Integer>(temp.getArrival(),temp.getDuration(),temp.getArrival()+temp.getDuration())); //Añadir a la cola
					temp6=c3.element();
					temp7=temp6;
				}else{
					temp7 = new Client<Integer>(temp.getArrival(),temp.getDuration(),temp6.getRetreival()+temp.getDuration());
					c3.offer(temp7);
					temp6= temp7;					
				}
				
				if(events.isEmpty()){		//Si la lista de eventos esta vacia ahora, añadir el evento de salida sin más
					events.offer(new Client<Integer>(temp7.getRetreival(),3,-2));		// Añadir evento de salida (Ocurrencia, # de cola, -2 indica que es salida)
				}else{						//Si la lista no esta vacia, buscar la posicion en donde debe ir este evento de salida
					Client<Integer> eventosalida = new Client<Integer>(temp7.getRetreival(),3,-2);
					events.offer(eventosalida);
					/*
					for(int j=0; j<=events.size(); j++){	//Recorrer toda la lsita de eventos		
						if(j==events.size()){				//Si no hay ningun evento que suceda despues que este evento de salida
							events.add(eventosalida);		// Añadirlo al final
							j=events.size()+3;		
						}
						else if(events.get(j).getArrival()> eventosalida.getArrival()){		//Si el tiempo de ocurrencia del evento en la posicion j es mayor
							if(j==0){
								events.addFirst(eventosalida);
								j=events.size()+3;
								
							}else{
								events.add(j, eventosalida);								// que el tiempo de ocurrencia del evento de salida, entonces el evento
								j=events.size()+3;											// de salida debe ir antes que este otro evento, y debe terminar la busqueda
							}
						}	
						
					}*/					
				}
			
			}
			if(cola_temp==c4){	//Comparar si la cola de menor tamaño es la cola 1
				if(c4.isEmpty()){
					c4.offer(new Client<Integer>(temp.getArrival(),temp.getDuration(),temp.getArrival()+temp.getDuration())); //Añadir a la cola
					temp8=c4.element();
					temp9=temp8;
				}else{
					temp9 = new Client<Integer>(temp.getArrival(),temp.getDuration(),temp8.getRetreival()+temp.getDuration());
					c4.offer(temp9);
					temp8= temp9;					
				}
				
				if(events.isEmpty()){		//Si la lista de eventos esta vacia ahora, añadir el evento de salida sin más
					events.offer(new Client<Integer>(temp9.getRetreival(),4,-2));		// Añadir evento de salida (Ocurrencia, # de cola, -2 indica que es salida)
				}else{						//Si la lista no esta vacia, buscar la posicion en donde debe ir este evento de salida
					Client<Integer> eventosalida = new Client<Integer>(temp9.getRetreival(),4,-2);
					events.offer(eventosalida);
					/*
					for(int j=0; j<=events.size(); j++){	//Recorrer toda la lsita de eventos		
						if(j==events.size()){				//Si no hay ningun evento que suceda despues que este evento de salida
							events.add(eventosalida);		// Añadirlo al final
							j=events.size()+3;		
						}
						else if(events.get(j).getArrival()> eventosalida.getArrival()){		//Si el tiempo de ocurrencia del evento en la posicion j es mayor
							if(j==0){
								events.addFirst(eventosalida);
								j=events.size()+3;
							}else{
								events.add(j, eventosalida);								// que el tiempo de ocurrencia del evento de salida, entonces el evento
								j=events.size()+3;											// de salida debe ir antes que este otro evento, y debe terminar la busqueda
							}
						}	
						
					}
					*/
				}
			
			}
		}if(temp.getRetreival()==-2){
			if(temp.getDuration()==1){
				if(!c1.isEmpty()){
					tempo = c1.remove();
					esperado = tempo.getRetreival()-tempo.getArrival();
					promedios[0]+=esperado;
				}
			}
			if(temp.getDuration()==2){
				if(!c2.isEmpty()){
					tempo = c2.remove();
					esperado = tempo.getRetreival()-tempo.getArrival();
					promedios[1]+=esperado;				
				}
			}
			if(temp.getDuration()==3){
				if(!c3.isEmpty()){
					tempo = c3.remove();
					esperado = tempo.getRetreival()-tempo.getArrival();
					promedios[2]+=esperado;
				}
			}
			if(temp.getDuration()==4){
				if(!c4.isEmpty()){
					tempo = c4.remove();
					esperado = tempo.getRetreival()-tempo.getArrival();
					promedios[3]+=esperado;
				}
			}		
		}
		}
		
		}while(!events.isEmpty());
		
		return promedios;
		
		
	}
	
	/**
	 * Método que permite ordenar un arreglo de datos dados el arreglo y el numero de datos a ordenar a partir del primero (en el índice 0).
	 * *** Fuente de este método: http://www.roseindia.net/java/beginners/arrayexamples/SelectionSort.shtml ***
	 * @param array		Arreglo a ordenar
	 * @param n			Numero de datos a ordenar a partir del primero (en el índice 0)
	 */
   public static void selection_sort(int array[], int n){
        for(int x = 0; x < n; x++){
            int indice_del_menor = x;
            
            for(int y = x; y < n; y++){
                if(array[indice_del_menor] < array[y]){
                    indice_del_menor = y;
                }
            }
            
            int temp = array[x];
            array[x] = array[indice_del_menor];
            array[indice_del_menor] = temp;
        }
    }
   
  
   /**
    * Permite imprimir una lista de Eventos enviada
    * @param eventoss	La lista a imprimir
    */
   	public static void printEventList(LinkedList<Client<Integer>> eventoss){
   		System.out.println("-----------------------------------------------------");
   		for(int k=0; k<eventoss.size(); k++){
   			System.out.println(eventoss.get(k));
   		}
   		System.out.println("-----------------------------------------------------");
   		
   	}


	
	/**
	 * Permite indicar al usuario a traves del parametro "texto" que se espera una entrada y mostrar el mensaje de error "error" si
	 * su entrada es clasificada como no valida.
	 * @param texto
	 * @param error
	 * @return double
	 */
	public static double ingresar(String texto, String error)
	{	
		Scanner input=new Scanner(System.in);
		double seleccion=-0.1;
		do{	
			System.out.println(texto);
			try
			{
				seleccion=input.nextDouble();
			}catch(InputMismatchException malo)
			{ 
				System.out.println(error);
			}
			input.nextLine(); // Ese Enter que siempre se queda ahi!!!
		}while(seleccion==-0.1); 
	return seleccion;
	}
}