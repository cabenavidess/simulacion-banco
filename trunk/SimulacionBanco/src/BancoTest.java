import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class BancoTest {

	/**
	 * Test method for {@link Banco#getSmallerQueue(CircularQueue, CircularQueue, CircularQueue, CircularQueue)}.
	 */
	@Test
	public void testGetSmallerQueue() {
		CircularQueue<Client<Integer>> ventanilla1 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla2 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla3 = new CircularQueue<Client<Integer>>();
		CircularQueue<Client<Integer>> ventanilla4 = new CircularQueue<Client<Integer>>();
		Client<Integer> temp = new Client<Integer>(2,3);
		
		for(int i=0; i<5; i++){
			if(i<1){
				ventanilla1.offer(temp);
			}
			if(i<2){
				ventanilla2.offer(temp);
			}
			if(i<3){
				ventanilla3.offer(temp);
			}
			if(i<4){
				ventanilla4.offer(temp);
			}
		}		
		assertEquals(ventanilla1,CircularBanco.getSmallerQueue(ventanilla1, ventanilla2, ventanilla3, ventanilla4));
	}




}
