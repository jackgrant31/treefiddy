package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlane800 {
	Plane800 ei = new Plane800(150);
	 
   	@Test
   	public void test() {
   		ei.init();
          	ei.populateArrayRandom();
          	assertTrue(ei.Passenger_Numbers.length==150);
   	}
 

}
