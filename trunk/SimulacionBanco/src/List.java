

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public interface List<E> {

	
	/**
	 * Devuelve el tamaño de esta Lista.
	 * Post: devuelve el numero de elementos
	 * @return
	 */
	public int size();
	// post: returns number of elements in list
	
	
	/**
	 * post: devuelve true si la lista esta vacia
	 */
	public boolean isEmpty();
	// post: returns true iff list has no elements
	
	
	
	//public void clear();
	// post: empties list
	
	public void addFirst(E value);
	// post: value is added to beginning of list
	
	/**
	 * post: Se añade un valor en la ultima posicion de la lista
	 * 
	 */
	public void addLast(E value);
	
	
	
	//public E getFirst();
	// pre: list is not empty
	// post: returns first value in list
	//public E getLast();
	// pre: list is not empty
	// post: returns last value in list
	public E removeFirst();
	//pre: list is not empty
	// post: removes first value from list
	
	/**
	 * pre:  la lista no esta vacia
	 * post: Retira el ultimo elemento de la lista
	 */
	public E removeLast();
	 
	
	
	//public E remove(E value);
	// post: removes and returns element equal to value
	// otherwise returns null
	//public void add(E value);
	// post: value is added to tail of list
	//public E remove();
	// pre: list has at least one element
	// post: removes last value found in list
	//public E get();
	// pre: list has at least one element
	// post: returns last value found in list
	//public boolean contains(E value);
	//pre: value is not null
	//post: returns true iff list contains an object equal to value
	//public int indexOf(E value);
	//pre: value is not null
	//post: returns (0-origin) index of value,
	//or -1 if value is not found
	//public int lastIndexOf(E value);
	//pre: value is not null
	//post: returns (0-origin) index of value,
	//or -1 if value is not found
	//public E get(int i);
	//pre: 0 <= i < size()
	//post: returns object found at that location
	//public E set(int i, E o);
	//pre: 0 <= i < size()
	//post: sets ith entry of list to value o;
	//returns old value
	//public void add(int i, E o);
	//pre: 0 <= i <= size()
	//post: adds ith entry of list to value o
	//public E remove(int i);
	//pre: 0 <= i < size()
	//post: removes and returns object found at that location
	//public Iterator<E> iterator();
	//post: returns an iterator allowing
	//ordered traversal of elements in list
	
}
