package airplane1;

import static org.junit.Assert.*;
 
import org.junit.Test;
 
public class TestPlane700 {
   	Plane700 se = new Plane700(118);
 
   	@Test
   	public void test() {
   		se.init();
          	se.populateArrayRandom();
          	assertTrue(se.Passenger_Numbers.length==118);
   	}
 
}

