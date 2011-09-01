import java.util.Collection;

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class CircularQueue<E> extends AbstractQueue<E>{
	

	public CircularList<E> datos;
	
	/**
	 * Constructor	Permite crear una nueva cola utilizando un lista circular.
	 */
	public CircularQueue(){
		datos  = new CircularList<E>();
	}
	
	/**
	 * Permite obtener y retirar el primer elemento en la cola
	 */
	public E remove(){
		if(!datos.isEmpty()){
			return datos.removeFirst();
		}else{
			return null;
		}
	}
	
	/**
	 * Permite obtener y retirar el primer elemento en la cola
	 */
	public E poll(){
		if(!datos.isEmpty()){
			return datos.removeFirst();
		}else{
			return null;
		}
	}
	
	/**
	 * Permite obtener pero no eliminar el primer elemento en la Cola
	 * @return	Devuelve el primer elemento si la lista no esta vacia, si esta vacia devuelve null.
	 */
	public E peek(){
		if(!datos.isEmpty()){
			return datos.peek();
		}else{
			return null;
		}		
	}
	
	/**
	 * Permite añadir un elemento a la cola
	 * @return	boolean  Indica si se pudo o no añadir el elemento
	 */
	public boolean offer(E value){
		datos.addLast(value);
		return true;
	}
	
	/**
	 * Permite obtener pero no eliminar el primer elemento en la Cola
	 * @return	Devuelve el primer elemento si la lista no esta vacia, si esta vacia devuelve null.
	 */
	public E element(){
		if(!datos.isEmpty()){
			return datos.peek();
		}else{
			return null;
		}	
	}
	
	/**
	 * Permite añadir un elemento a la cola
	 * @return	boolean  Indica si se pudo o no añadir el elemento
	 * @throws	QueueFullException	Si la cola ya esta llena
	 */
	public boolean add(E value)throws QueueFullException{
		try{
			datos.addLast(value);
		}catch(Exception a){
			throw new QueueFullException("La cola esta llena");
		}
		return true;
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
	public int size() {
		// TODO Auto-generated method stub
		return datos.size();
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
