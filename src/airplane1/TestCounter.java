package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCounter {
	@Test
   	public void test() {
          	Airport air = new Airport();
          	assertTrue(air.countr == 0);
   	}

}
