package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSequentialB2F {

	@Test
	public void test() {
		Airplane air = new Airplane(118);
		air.init();
		air.populateArrayBackward();
		assertTrue(air.Passenger_Numbers[1]==air.Passenger_Numbers[0]-1);
	}

}
