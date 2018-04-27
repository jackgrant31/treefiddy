package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBoardingCounter {

	@Test
	public void test() {
		Airport air = new Airport();
		air.op700();
		air.boarding();
		assertTrue(air.countr!=0);
	}

}
