package airplane1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestPrintPassArray {
	@Test
   	public void test() {
                 	int NumSeats = 118;
                 	int[] Passenger_Numbers = new int[NumSeats];
                 	int[] Plane_Seats = new int[NumSeats];
                 	for (int j = 0; j < Plane_Seats.length; j++){
                       	Passenger_Numbers[j] = (int) (1 + Math.random()*NumSeats);
                       	if (j > 0) {
                              	for (int k = 0; k <= j-1; k++) {
                                     	if (Passenger_Numbers[k] == Passenger_Numbers[j]) {
                                            	j--;
                                     	}//end if
                              	}//end for
                       	}//end if
                 	}//end for
                 	System.out.println(Arrays.toString(Passenger_Numbers));
          	}

}
