package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlaneA320 {
	PlaneA320 a3 = new PlaneA320(150);
	 
   	@Test
   	public void test() {
   		a3.init();
   	   	a3.populateArrayRandom();
          	assertTrue(a3.Passenger_Numbers.length==150);
   	}

}
