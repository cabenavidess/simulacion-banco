import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class PriorityQueueHeapTest {

	/**
	 * Test method for {@link PriorityQueueHeap#offer(java.lang.Object)}.
	 */
	@Test
	public void testOffer() {
		PriorityQueueHeap<Client<Integer>> cola = new PriorityQueueHeap<Client<Integer>>(1000);
		Client<Integer> mayor= new Client<Integer>(3,2,3);
		Client<Integer> medio= new Client<Integer>(2,2,3);
		Client<Integer> menor= new Client<Integer>(1,2,3);
		cola.offer(mayor);
		cola.offer(medio);
		cola.offer(menor);
		assertEquals(menor,cola.remove());
		
	}

	/**
	 * Test method for {@link PriorityQueueHeap#remove()}.
	 */
	@Test
	public void testRemove() {
		PriorityQueueHeap<Client<Integer>> cola = new PriorityQueueHeap<Client<Integer>>(1000);
		Client<Integer> mayor= new Client<Integer>(3,2,3);
		Client<Integer> medio= new Client<Integer>(2,2,3);
		Client<Integer> menor= new Client<Integer>(1,2,3);
		cola.offer(mayor);
		cola.offer(medio);
		cola.offer(menor);
		assertEquals(menor,cola.remove());
		
	}

	/**
	 * Test method for {@link PriorityQueueHeap#peek()}.
	 */
	@Test
	public void testPeek() {
		PriorityQueueHeap<Client<Integer>> cola = new PriorityQueueHeap<Client<Integer>>(1000);
		Client<Integer> mayor= new Client<Integer>(3,2,3);
		Client<Integer> medio= new Client<Integer>(2,2,3);
		Client<Integer> menor= new Client<Integer>(1,2,3);
		Client<Integer> aux;
		cola.offer(mayor);
		cola.offer(medio);
		cola.offer(menor);
		aux=cola.peek();
		assertEquals(aux,cola.remove());
		
	}

	/**
	 * Test method for {@link PriorityQueueHeap#size()}.
	 */
	@Test
	public void testSize() {
		
		PriorityQueueHeap<Client<Integer>> cola = new PriorityQueueHeap<Client<Integer>>(1000);
		Client<Integer> mayor= new Client<Integer>(3,2,3);
		Client<Integer> medio= new Client<Integer>(2,2,3);
		Client<Integer> menor= new Client<Integer>(1,2,3);
		cola.offer(mayor);
		cola.offer(medio);
		cola.offer(menor);
		assertEquals(3,cola.size());
		
	}

}
