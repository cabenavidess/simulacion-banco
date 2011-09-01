import static org.junit.Assert.*;

import org.junit.Test;


public class CircularQueueTest {

	@Test
	public void testRemove() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.remove();
		assertEquals("Resultado",(Integer)2,queue.remove());
	}

	@Test
	public void testOffer() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		assertEquals("Resultado",(Integer)1,queue.peek());
	}

	@Test
	public void testSize() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		assertEquals("Resultado",3,queue.size());
	}

	@Test
	public void testIsEmpty() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.remove();
		queue.remove();
		queue.remove();
		assertEquals(true,queue.isEmpty());
	}

}
