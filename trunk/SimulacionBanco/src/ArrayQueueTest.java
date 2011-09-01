import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayQueueTest {

	@Test
	public void testOffer() {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		assertEquals("Resultado",(Integer)1,queue.peek());
	}

	@Test
	public void testRemove() {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.remove();
		assertEquals("Resultado",(Integer)2,queue.remove());
	}

	@Test
	public void testSize() {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		assertEquals("Resultado",3,queue.size());
	}

	@Test
	public void testIsFull() {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(1);
		queue.offer(2);
		assertEquals("Resultado", true, queue.isFull());
	}

	@Test
	public void testIsEmpty() {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
		queue.offer(1);
		queue.offer(2);
		queue.remove();
		queue.remove();
		assertEquals("Resultado",true,queue.isEmpty());
	}

}
