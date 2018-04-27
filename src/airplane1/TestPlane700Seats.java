package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlane700Seats {
	int NumSeats=118;
   	int[] Passenger_Numbers = new int[NumSeats];
   	int[] Plane_Seats = new int[NumSeats];
   	@Test
   	public void test() {
          	assertTrue(Plane_Seats.length ==NumSeats);
   	}

}
