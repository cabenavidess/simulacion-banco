/**
 * Fecha: 30 de agosto de 2011
 * Descripcion: Esta clase representa a un cliente en una simulación de banco. Contiene
 * casillas o espacios para almacenar el tiempo de llega de un cliente y espacios para 
 * almacenar el tiempo que durara la transaccion que realiza. Como el cliente esta en una cola,
 * tiene una casilla que se utiliza como referencia al siguiente cliente.
 * 
 */

/**
 * @author Medrano
 *
 */
public class Cliente<E> {

	/**
	 * E arrival:  indica el tiempo de llegada del cliente. Normalmente debería ser un Integer
	 */
	public E arrival;
	
	/**
	 * E duration: indica la duracion de la transaccion de este cliente en el banco. Normalmente debería ser un enter
	 */
	public E duration;
	
	/**
	 * Cliente<E> nextCliente: es una referencia al siguiente cliente
	 */
	public Cliente<E> nextCliente;
	
	/**
	 * Constructor: permite crear un nuevo Clinete indicando el tiempo de llegada, duracion de transacción y el 
	 * siguiente cliente en la cola (que llego despues de este cliente).
	 * @param t_arrival		indica el tiempo de llegada
	 * @param t_duration	indica la duracion de la transaccion
	 * @param nextClient	indica quien es el siguiente cliente (que llego despues de este cliente)
	 */
	public Cliente(E t_arrival, E t_duration, Cliente<E> nextClient){
		arrival = t_arrival;			// asigna el valor de llegada indicado a este cliente
		duration = t_duration;			// asigna la duracion de la transaccion indicada a este cliente
		nextCliente=nextClient;			// asigna la referencia al siguiente clinete
	}
	
	/**
	 * Constructor: permite crear un nuevo Cliente indicando el tiempo de llegada, duracion de transaccion y
	 * una referencia vacia al siguiente cliente
	 * @param t_arrival
	 * @param t_duration
	 */
	public Cliente(E t_arrival, E t_duration){
		arrival = t_arrival;
		duration = t_duration;
		nextCliente = null;
	}
	
	
	/**
	 * Permite establecer el tiempo de llegada de este cliente
	 * @param t_arrival
	 */
	public void setArrival(E t_arrival){
		arrival = t_arrival;
	}
	
	/**
	 * Permite obtener el tiempo de llegada de este cliente
	 * @return  E arrival
	 */
	public E getArrival(){
		return arrival;
	}
	
	/**
	 * Permite establecer la duracion de la transaccion de este cliente
	 * @param t_duration
	 */
	public void setDuration(E t_duration){
		duration = t_duration;
	}
	
	/**
	 * Permite obtener la duracion de la transaccion de este cliente
	 * @return E duration   indica la duracion de la transaccion de este cliente
	 */
	public E getDuration(){
		return duration;
	}
	
	
	/**
	 * Permite indicar el nuevo cliente que ira despues de este cliente
	 * @param nextClient
	 */
	public void setNextCliente(Cliente<E> nextClient){
		nextCliente = nextClient;
	}
	
	/**
	 * Permite obtener una referencia al cliente que va despues de este cliente
	 * @return	Cliente<E> nextCliente   referencia al siguiente cliente
	 */
	public Cliente<E> getNextCliente(){
		return nextCliente;
	}	
	
}
