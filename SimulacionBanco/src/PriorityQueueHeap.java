import java.util.Collection;

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class PriorityQueueHeap<E> extends AbstractQueue<E>{
	
	public Object datos[];
	public int tamaño;
	
	
	public PriorityQueueHeap(int size){
		datos = (E[]) new Object[size];
		tamaño=0;		
	}
	
	
	public boolean add(E value)throws QueueFullException{
		
	}
	
	public boolean offer(E value){
		
	}
	
	public E remove(){
		
	}
	
	public E poll(){
		
	}
	
	public E peek(){
		return (E)datos[0];
		 
	}
	
	public E element(){
		
	}
	
	public int size(){
	
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
	public boolean isEmpty() {
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
