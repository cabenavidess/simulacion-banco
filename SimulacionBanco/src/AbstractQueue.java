/**
 * 
 */

/**
 * @author Medrano
 *
 */
public abstract class AbstractQueue<E> implements Queue<E> {

		/**
		 * Permite saber si esta cola esta vacia
		 */
		public boolean isEmpty(){
			return size()==0;
		}
	
		
}
