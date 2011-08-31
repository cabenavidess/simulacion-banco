import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Medrano
 *
 */
public class ClienteTest {

	/**
	 * Test method for {@link Cliente#setArrival(java.lang.Object)}.
	 */
	@Test
	public void testSetArrival() {
		Cliente<Integer> x = new Cliente<Integer>(5,6) ; 
		x.setArrival(10);
		assertEquals("Resultado",(Integer)10,x.arrival);
		
	}

	/**
	 * Test method for {@link Cliente#getArrival()}.
	 */
	@Test
	public void testGetArrival() {
		Cliente<Integer> x = new Cliente<Integer>(5,6) ;
		assertEquals("Resultado",(Integer)5,x.getArrival());
		
	}

	/**
	 * Test method for {@link Cliente#setDuration(java.lang.Object)}.
	 */
	@Test
	public void testSetDuration() {
		Cliente<Integer> x = new Cliente<Integer>(5,6) ;
		x.setDuration(10);
		assertEquals("Resultado",(Integer)10, x.duration);
	}

	/**
	 * Test method for {@link Cliente#setNextCliente(Cliente)}.
	 */
	@Test
	public void testSetNextCliente() {
		Cliente<Integer> x = new Cliente<Integer>(5,6, new Cliente<Integer>(5,6)) ;
		Cliente<Integer> y = new Cliente<Integer>(5,6) ;
		x.setNextCliente(y);
		assertEquals(y,x.getNextCliente());
	}

}
