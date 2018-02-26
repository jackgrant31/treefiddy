package airplane1;
import java.util.Arrays;



public class Airplane { //airplane houses passengers and methods relating to them

	public int NumSeats;
	
	public Airplane(int specNumSeats) {
		NumSeats = specNumSeats;
	}
	
	public void populateArray() { //this creates a seating array and random passenger array//put in inherited classes for different capacities
		
			int[] Plane_Seats = new int[NumSeats];
			Plane_Seats = java.util.stream.IntStream.rangeClosed(1, NumSeats).toArray();//Generates list of seats from 1 to First_Plane's value
		
		
			int[] Passenger_Numbers = new int[NumSeats];
				for (int j = 0; j < Passenger_Numbers.length; j++){
					Passenger_Numbers[j] = (int) (1 + Math.random()*150);
					if (j > 0) {
						for (int k = 0; k <= j-1; k++) {
							if (Passenger_Numbers[k] == Passenger_Numbers[j]) {
								j--;
							}//end if
						}//end for
					}//end if
				}//end for
				
				
				System.out.println(Arrays.toString(Plane_Seats));
				System.out.println(Arrays.toString(Passenger_Numbers));
		
	}
	
	public void setNumSeats(int temp) {
		NumSeats = temp;
	}
}
