/**
 * Node<E>		Objeto de tipo E que permite almacenar un valor cualquiera tipo E y tambien tener
 * 				una referencia a otro objeto tipo E. 
 */

/**
 * @author Medrano
 *
 */
public class Node<E>{
	
		/**
		 * E data		Valor almacenado en este Node
		 */
		protected E data; // value stored in this element
		/**
		 * Node<E> nextElement	Referencia al siguiente valor
		 */
		protected Node<E> nextElement; // ref to next
		
		/**
		 * Constructor		Permite crear un nuevo Node con valor v y referencia al siguiente elemento.
		 * @param v
		 * @param next
		 */
		public Node(E v, Node<E> next)
		//pre: v is a value, next is a reference to remainder of list
		//post: an element is constructed as the new head of list
		{
			data = v;
			nextElement = next;
		}
		
		/**
		 * Constructor		Permite crear un nuevo Node con valor null y sin referencia a otro objeto (referencia a null)
.		 * @param v
		 */
		public Node(E v)
		//post: constructs a new tail of a list with value v
		{
			this(v,null);
		}
		
		/**
		 * Permite obtener el Node<E> al que hace referencia el este Node. 
		 * @return	Node<E>
		 */
		public Node<E> next()
		//post: returns reference to next value in list
		{
			return nextElement;
		}
		
		/**
		 * Permite establecer para este Node una nueva referencia a un siguiente elemento.
		 * @param next
		 */
		public void setNext(Node<E> next)
		//post: sets reference to new next value
		{
			nextElement = next;
		}
		
		/**
		 * Permite obtener el valor que almacena este Node.
		 * @return
		 */
		public E value()
		//post: returns value associated with this element
		{
			return data;
		}
		
		/**
		 * Permite establecer un nuevo valor para este Node.
		 * @param value
		 */
		public void setValue(E value)
		//post: sets value associated with this element
		{
			data = value;
		}
}