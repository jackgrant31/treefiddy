package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRowArrayReset {

	@Test
	public void test() {
		Airplane air = new Airplane(118);
		air.init();
		assertTrue(air.Passenger_Numbers[0]==0);
	}

}
