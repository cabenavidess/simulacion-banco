/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class ArrayQueue<E> extends AbstractQueue<E> {

	public Object datos[];		//Arreglo de datos
	public int cabeza;			//Indice de la cabeza
	public int contador;		//Cantidad actual de datos
	
	public ArrayQueue(int size){
		datos = new Object[size];
		cabeza = 0;
		contador = 0;
	}
	
	/**
	 * Permite añadir un elemento a la cola
	 * @param E value	Valor que será añadido al final de la cola
	 * @return	Boolean	True si se pudo añadir a la cola, False si no se logró
	 */
	public boolean offer(E value){
		int cola = (cabeza + contador) % datos.length;
		datos[cola] = value;
		contador++;
		return true;
	}
	
	
	
	
	
	
	
	
}
