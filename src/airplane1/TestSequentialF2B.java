package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSequentialF2B {

	@Test
	public void test() {
		Airplane air = new Airplane(118);
		air.init();
		air.populateArrayForward();
		assertTrue(air.Passenger_Numbers[1]==air.Passenger_Numbers[0]+1);
	}

}
