import static org.junit.Assert.*;

import org.junit.Test;


public class ClientTest {

	@Test
	public void testCompareTo() {
		Client<Integer> cliente1 = new Client<Integer>(10,8,28);
		Client<Integer> cliente2 = new Client<Integer>(12,8,40);
		
		assertEquals(-2, cliente1.compareTo(cliente2));
	}

}
