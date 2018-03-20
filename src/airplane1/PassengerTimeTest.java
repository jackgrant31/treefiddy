package airplane1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PassengerTimeTest {
	Plane700 airplane = new Plane700(118);

	@Test
	public void test() {
		airplane.populateArray();
		airplane.row7();
		airplane.timePP7();
		int pass = (int) ((int) 118*Math.random());
		int temp1 = airplane.time[pass-1];
		
		assertTrue( temp1 == 4 || temp1 == 7 | temp1 == 10) ;

		//fail("This passenger time test failed.");
	}

}
