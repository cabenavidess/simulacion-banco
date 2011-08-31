import java.util.Collection;
import java.util.Iterator;

/**
 * Fecha: 31 de agosto de 2011
 * Descripcion: Interfaz que proporciona la funcionalidad mínima para 
 * una cola
 */

/**
 * @author Medrano
 *
 */
public interface Queue<E> {
	

	/**
	 * Permite añadir un elemento en el final de la cola sin violar las restricciones de capacidad
	 * Si el elemento no cabe, lanza un QueueFullException
	 * @param e
	 * @return
	 * @throws QueueFullException
	 */
	public boolean add(E e)throws QueueFullException;

	
	/**
	 * Permite obtener pero no remover la cabeza de la cola
	 * @return
	 */
	public E element();

	/**
	 * Permite añadir un elemento a la cola. Devuelve TRUE si la operacion fue posible, y FALSE si no fue posible.
	 * @param arg0
	 * @return
	 */
	public boolean offer(E arg0);

	/**
	 * Permite obtener pero no remover la cabeza de la cola
	 * @return
	 */
	public E peek();

	/**
	 * Permite obtener la cabeza de esta cola
	 * @return
	 */
	public E poll();

	/**
	 * Permite obtener la cabeza de esta cola
	 * @return
	 */
	public E remove();

	//public boolean addAll(Collection arg0);

	public void clear();

	public boolean contains(Object arg0);

	public boolean containsAll(Collection<?> arg0);

	public boolean isEmpty();

	//public Iterator iterator();

	public boolean remove(Object arg0);

	public boolean removeAll(Collection<?> arg0);

	public boolean retainAll(Collection<?> arg0);

	public int size();

	public Object[] toArray();

	public Object[] toArray(Object[] arg0);

}
