package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTimeMinus1 {

	@Test
   	public void test() {
                 	int NumSeats = 1;
                 	int rowNum = 1;
                 	int time1[] = new int [NumSeats];
                 	time1[0] = -1;
          	    assertFalse(time1[0] == 1);
          	}

}
