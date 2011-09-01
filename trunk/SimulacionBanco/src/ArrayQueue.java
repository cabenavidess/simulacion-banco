import java.util.Collection;

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
	public boolean add(E value)throws QueueFullException{
		if(!isFull()){
			int cola = (cabeza + contador) % datos.length;
			datos[cola] = value;
			contador++;
			return true;
		}else{
			throw new QueueFullException("La cola esta llena!");
		}
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
	
	/**
	 * Permite retirar el primer elemento de la lista
	 * @return	E value	 Valor retirado de la lista
	 */
	public E remove(){
		E value = (E)datos[cabeza];
		cabeza=(cabeza+1)%datos.length;
		contador--;
		return value;
	}
	
	/**
	 * Permite retirar el primer elemento de la lista
	 * @return	E value	 Valor retirado de la lista
	 */
	public E poll(){
		E value = (E)datos[cabeza];
		cabeza=(cabeza+1)%datos.length;
		contador--;
		return value;
	}
	
	/**
	 * Permite obtener el primer elemento de la lista, sin retirarlo
	 * @return	E value		Referencia al primer elemento de la lista
	 */
	public E peek(){
		return (E)datos[cabeza];
	}
	
	/**
	 * Permite obtener el primer elemento de la lista, sin retirarlo
	 * @return	E value		Referencia al primer elemento de la lista
	 */
	public E element(){
		return (E)datos[cabeza];
	}
	
	/**
	 * Permite obtener la cantidad de elementos en la lista
	 */
	public int size(){
		return contador;
	}
	
	/**
	 * Permite saber si la cola ya esta llena
	 * @return Boolean	True = Cola Llena, False = cola aún no esta llena
	 */
	public boolean isFull(){
		return contador==datos.length;
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}	
}
