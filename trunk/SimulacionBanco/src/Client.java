/**
 * Fecha: 01 de septiembre de 2011
 * Descripcion: Una clase genérica que permitirá contener 3 tiempos que representan a un
 * cliente.
 */


/**
 * @author Medrano
 *
 */
public class Client<E> {
	
	public E arrival;
	public E duration;
	public E retreival;
	
	/**
	 * Constructor Permite crear un nuevo objeto Client, especificando tiempo de llegada
	 * duracion de la transacción y tiempo de salida
	 * @param t_arrival		Tiempo de llegada
	 * @param t_duration	Tiempo de duracion de la transaccion
	 * @param t_retreival	Tiempo de salida
	 */
	public Client(E t_arrival, E t_duration, E t_retreival){
		arrival=t_arrival;
		duration=t_duration;
		retreival=t_retreival;
	}
	
	/**
	 * Constructor Permite inicializar un nuevo objeto  Client especificando tiempo de llegada
	 *             y duracion de la transacción. Se establece el tiempo de salida como null
	 * @param t_arrival		Tiempo de llegada
	 * @param t_duration	Tiempo de duracion
	 */
	public Client(E t_arrival, E t_duration){
		arrival = t_arrival;
		duration = t_duration;
		retreival=null;
	}
	
	/**
	 * Constructor Permite inicializar un nuevo objeto Client especificando tiempo de llegada
	 * 			El tiempo de duracion y salida se establecen como null
	 * @param t_arrival		Tiempo de llegada
	 */
	public Client(E t_arrival){
		arrival=t_arrival;
		duration =null;
		retreival = null;		
	}
	
	/**
	 * Permite establecer el tiempo de llegada
	 * @param t_arrival		Nuevo tiempo de llegada de este cliente
	 */
	public void setArrival(E t_arrival){
		arrival = t_arrival;
	}
	
	/**
	 * Permite establecer la duracion de la transaccion
	 * @param t_duration	Nuevo tiempo de duracion de transaccion
	 */
	public void setDuration(E t_duration){
		duration = t_duration;
	}
	
	/**
	 * Permite establecer el tiempo de salida
	 * @param t_retreival	Nuevo tiempo de salida
	 */
	public void setRetreival(E t_retreival){
		retreival = t_retreival;
	}
	
	/**
	 * Pemrite obtener el tiempo de llegada de este cliente
	 * @return	E arrival	Tiempo de llegada de este cliente
	 */
	public E getArrival(){
		return arrival;
	}
	
	/**
	 * Permite obtener el tiempo de duracion de la transaccion
	 * @return	E duration	Tiempo de duracion de la transaccion
	 */
	public E getDuration(){
		return duration;
	}
	
	/**
	 * Permite obtener el tiempo de salida 
	 * @return	E retreival	Tiempo de salida de este cliente
	 */
	public E getRetreival(){
		return retreival;
	}
	
	
	/**
	 * Permite obtener una representación en texto de este Client
	 * @return	String descripcion		Valor de los atributos en forma de String
	 */
	public String toString(){
		String descripcion="";
		descripcion+= "LLegada  :"+arrival+"  ";
		descripcion+= "Duracion :"+duration+"  ";
		descripcion+= "Salida   :"+retreival+"  ";
		return descripcion;
	}
	
	

}
