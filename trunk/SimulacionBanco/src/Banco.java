import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * Fecha: 01 de septiembre de 2011
 * Descripcion: Este programa permite simular el comportamiento de las colas en un banco.
 * 				Se tienen 4 ventanillas en el banco, una cola de ingreso y las acciones se
 * 				manejan a traves de una lista de eventos. 
 */

/**
 * @author Medrano
 *
 */
public class Banco {

	/**
	 * Método principal. Es el que se ejecuta al crear esta clase.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("              ---------------------------------------");
		System.out.println("              --      Bienvenido al banco UVG      --");
		System.out.println("              ---------------------------------------");
		
		CircularQueue<Client<Integer>> ventanilla1 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla2 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla3 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla4 = new CircularQueue<Client<Integer>>();
		
		LinkedList<Client<Integer>> eventos = new LinkedList<Client<Integer>>();
		
		
		int entrada[]=new int[40];
		
		int t_wait_1=0;
		int t_wait_2=0;
		int t_wait_3=0;
		int t_wait_4=0;
		
		int t_arrival=0;
		int clientes_ingresados=0;
		
		int tiempos[]=new int[4];
		
		
		
		
			do{
				t_arrival = (int)ingresar("Ingrese el tiempo de llegada del cliente "+(clientes_ingresados +1)+" o un numero negativo para terminar", "El dato ingresado no es valido");
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
						System.out.println(" El tiempo debe ser un numero entre "+entrada[clientes_ingresados-1]+" y 480");
					}
				}
			}while(t_arrival>=0 && clientes_ingresados<=40);
			
			
			
			System.out.println(" La cantidad de clientes fue: "+clientes_ingresados);
			
			createEventList(eventos,entrada);
			
			tiempos = executeEventList(eventos,entrada,ventanilla1,ventanilla2,ventanilla3,ventanilla4);
		
			
			

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
		sizes[0] =  c1.size();
		sizes[1] = c2.size();
		sizes[2] = c3.size();
		sizes[4] = c4.size();
		selection_sort(sizes,sizes.length);
		menor = sizes[0];
		if(menor == c1.size()){
			return c1;
		}if (menor == c2.size()){
			return c2;
		}if (menor == c3.size()){
			return c3;
		}else{
			return c4;
		}	
	}
	
	/**
	 * Permite crear la lista de eventos con eventos solamente de entrada de clientes
	 * @param events		Lista de eventos 
	 * @param ingreso		Arreglo con los clientes ingresados
	 */
	public static void createEventList(LinkedList<Client<Integer>> events, int[] ingreso){
		Random rand = new Random();
		for(int i=0; i<ingreso.length;i++){
			events.add(new Client<Integer>(ingreso[i],rand.nextInt(31)+1,-1));
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
	public static int[] executeEventList(LinkedList<Client<Integer>> events, int[] ingreso, CircularQueue<Client<Integer>> c1,  CircularQueue<Client<Integer>> c2,  CircularQueue<Client<Integer>> c3,  CircularQueue<Client<Integer>> c4){
		//Random rand = new Random();
		int procesados=0;
		
		int[] promedios = new int[4];
		promedios[0]=0;
		promedios[1]=0;
		promedios[2]=0;
		promedios[3]=0;
		
		int t_wait_1=0;
		int t_wait_2=0;
		int t_wait_3=0;
		int t_wait_4=0;
		
		int esperado=0;
		
		CircularQueue<Client<Integer>> cola_temp;
		
		Client<Integer> temp2 = null;
		Client<Integer>	temp3 = null;
		Client<Integer>	temp4 = null;
		Client<Integer>	temp5 = null;
		Client<Integer>	temp6 = null;
		Client<Integer>	temp7 = null;
		Client<Integer>	temp8 = null;
		Client<Integer>	temp9 = null;
		Client<Integer> new_event=null;
		
		do{
		
		Client<Integer> temp = events.removeFirst();
		
		if(temp.getRetreival()==-1){		//Verificar si es evento de entrada
			cola_temp = getSmallerQueue(c1,c2,c3,c4);	//Obtener cuál de las colas tiene menor tamaño
			if(cola_temp==c1){	//Comparar si la cola de menor tamaño es la cola 1
				if(c1.isEmpty()){
					c1.offer(new Client<Integer>(temp.getArrival(),temp.getDuration(),temp.getArrival()+temp.getDuration())); //Añadir a la cola
					temp2=c1.element();
				}else{
					temp3 = new Client<Integer>(temp.getArrival(),temp.getDuration(),temp2.getRetreival()+temp.getDuration());
					c1.offer(temp3);
					temp2= temp3;					
				}
				
				if(events.isEmpty()){		//Si la lista de eventos esta vacia ahora, añadir el evento de salida sin más
					events.add(new Client<Integer>(c1.peek().getRetreival(),1,-2));		// Añadir evento de salida (Ocurrencia, # de cola, -2 indica que es salida)
				}else{						//Si la lista no esta vacia, buscar la posicion en donde debe ir este evento de salida
					Client<Integer> eventosalida = new Client<Integer>(temp3.getRetreival(),1,-2);
					for(int j=0; j< events.size(); j++){	//Recorrer toda la lsita de eventos		
						if(events.get(j).getArrival()> eventosalida.getArrival()){		//Si el tiempo de ocurrencia del evento en la posicion j es mayor
							events.add(j-1, eventosalida);								// que el tiempo de ocurrencia del evento de salida, entonces el evento
							j=events.size()+3;											// de salida debe ir antes que este otro evento, y debe terminar la busqueda
						}	
						if(j==events.size()){				//Si no hay ningun evento que suceda despues que este evento de salida
							events.add(eventosalida);		// Añadirlo al final
						}
					}					
				}
			
			}
			if(cola_temp==c2){	//Comparar si la cola de menor tamaño es la cola 1
				if(c2.isEmpty()){
					c2.offer(new Client<Integer>(temp.getArrival(),temp.getDuration(),temp.getArrival()+temp.getDuration())); //Añadir a la cola
					temp4=c2.element();
				}else{
					temp5 = new Client<Integer>(temp.getArrival(),temp.getDuration(),temp4.getRetreival()+temp.getDuration());
					c2.offer(temp5);
					temp4= temp5;					
				}
				
				if(events.isEmpty()){		//Si la lista de eventos esta vacia ahora, añadir el evento de salida sin más
					events.add(new Client<Integer>(c2.peek().getRetreival(),1,-2));		// Añadir evento de salida (Ocurrencia, # de cola, -2 indica que es salida)
				}else{						//Si la lista no esta vacia, buscar la posicion en donde debe ir este evento de salida
					Client<Integer> eventosalida = new Client<Integer>(temp5.getRetreival(),1,-2);
					for(int j=0; j< events.size(); j++){	//Recorrer toda la lsita de eventos		
						if(events.get(j).getArrival()> eventosalida.getArrival()){		//Si el tiempo de ocurrencia del evento en la posicion j es mayor
							events.add(j-1, eventosalida);								// que el tiempo de ocurrencia del evento de salida, entonces el evento
							j=events.size()+3;											// de salida debe ir antes que este otro evento, y debe terminar la busqueda
						}	
						if(j==events.size()){				//Si no hay ningun evento que suceda despues que este evento de salida
							events.add(eventosalida);		// Añadirlo al final
						}
					}					
				}
			
			}
			if(cola_temp==c3){	//Comparar si la cola de menor tamaño es la cola 1
				if(c3.isEmpty()){
					c3.offer(new Client<Integer>(temp.getArrival(),temp.getDuration(),temp.getArrival()+temp.getDuration())); //Añadir a la cola
					temp6=c3.element();
				}else{
					temp7 = new Client<Integer>(temp.getArrival(),temp.getDuration(),temp6.getRetreival()+temp.getDuration());
					c3.offer(temp7);
					temp6= temp7;					
				}
				
				if(events.isEmpty()){		//Si la lista de eventos esta vacia ahora, añadir el evento de salida sin más
					events.add(new Client<Integer>(c3.peek().getRetreival(),1,-2));		// Añadir evento de salida (Ocurrencia, # de cola, -2 indica que es salida)
				}else{						//Si la lista no esta vacia, buscar la posicion en donde debe ir este evento de salida
					Client<Integer> eventosalida = new Client<Integer>(temp7.getRetreival(),1,-2);
					for(int j=0; j< events.size(); j++){	//Recorrer toda la lsita de eventos		
						if(events.get(j).getArrival()> eventosalida.getArrival()){		//Si el tiempo de ocurrencia del evento en la posicion j es mayor
							events.add(j-1, eventosalida);								// que el tiempo de ocurrencia del evento de salida, entonces el evento
							j=events.size()+3;											// de salida debe ir antes que este otro evento, y debe terminar la busqueda
						}	
						if(j==events.size()){				//Si no hay ningun evento que suceda despues que este evento de salida
							events.add(eventosalida);		// Añadirlo al final
						}
					}					
				}
			
			}
			if(cola_temp==c4){	//Comparar si la cola de menor tamaño es la cola 1
				if(c4.isEmpty()){
					c4.offer(new Client<Integer>(temp.getArrival(),temp.getDuration(),temp.getArrival()+temp.getDuration())); //Añadir a la cola
					temp8=c4.element();
				}else{
					temp9 = new Client<Integer>(temp.getArrival(),temp.getDuration(),temp8.getRetreival()+temp.getDuration());
					c4.offer(temp9);
					temp8= temp9;					
				}
				
				if(events.isEmpty()){		//Si la lista de eventos esta vacia ahora, añadir el evento de salida sin más
					events.add(new Client<Integer>(c4.peek().getRetreival(),1,-2));		// Añadir evento de salida (Ocurrencia, # de cola, -2 indica que es salida)
				}else{						//Si la lista no esta vacia, buscar la posicion en donde debe ir este evento de salida
					Client<Integer> eventosalida = new Client<Integer>(temp9.getRetreival(),1,-2);
					for(int j=0; j< events.size(); j++){	//Recorrer toda la lsita de eventos		
						if(events.get(j).getArrival()> eventosalida.getArrival()){		//Si el tiempo de ocurrencia del evento en la posicion j es mayor
							events.add(j-1, eventosalida);								// que el tiempo de ocurrencia del evento de salida, entonces el evento
							j=events.size()+3;											// de salida debe ir antes que este otro evento, y debe terminar la busqueda
						}	
						if(j==events.size()){				//Si no hay ningun evento que suceda despues que este evento de salida
							events.add(eventosalida);		// Añadirlo al final
						}
					}					
				}
			
			}
		}if(temp.getRetreival()==-2){
			if(temp.getDuration()==1){
				temp = c1.remove();
				esperado = temp.getRetreival()-temp.getArrival();
				promedios[1]+=esperado;
			}
			if(temp.getDuration()==2){
				temp = c2.remove();
				esperado = temp.getRetreival()-temp.getArrival();
				promedios[2]+=esperado;
			}
			if(temp.getDuration()==3){
				temp = c3.remove();
				esperado = temp.getRetreival()-temp.getArrival();
				promedios[3]+=esperado;
			}
			if(temp.getDuration()==4){
				temp = c4.remove();
				esperado = temp.getRetreival()-temp.getArrival();
				promedios[4]+=esperado;
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
