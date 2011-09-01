/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class CircularList<E> extends AbstractList<E> {

	
	protected Node<E> tail;
	protected int count;
	
	/**
	 * Constructor Permite crear una nueva lista circulos con cero elementos
	 */
	public CircularList(){
		tail = null;
		count=0;
	}
	
	/**
	 * Permite añadir un elemento a la primer posicion de
	 * la lista
	 */
	@Override 	
	public void addFirst(E value) {
		// TODO Auto-generated method stub
		Node<E> temp = new Node<E>(value);
		if (tail == null) { // first value added
			tail = temp;
			tail.setNext(tail);
		} else { // element exists in list
			temp.setNext(tail.next());
			tail.setNext(temp);
		}
		count++;		
	}

	/**
	 * Permite añadir un elemento al final de la lista
	 * @param  E value	Elemento que se añade al final de la lista
	 */
	@Override
	public void addLast(E value) {
		// TODO Auto-generated method stub
		addFirst(value);
		tail = tail.next();
		
	}

	/**
	 * Permite remover el ultimo valor de la lista circular
	 * @return	E value		El ultimo valor de esta lista circular
	 */
	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		Node<E> finger = tail;
		while(finger.next()!=tail){
			finger=finger.next();
		}
		Node<E> temp = tail;
		if(finger == tail){
			tail=null;
		}else{
			finger.setNext(tail.next());
			tail = finger;
		}
		count--;
		return temp.value();
	}
	
	/**
	 * Permite remover el primer elemento de la lista
	 */
	@Override
	public E removeFirst(){
		Node<E> temp = tail.next();
		tail.setNext(temp.next());
		count--;
		return temp.value();
	}

	
	public E peek(){
		return tail.next().value();
	}
	/**
	 * Permite obtener la cantidad de elementos en esta lista
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	

}
