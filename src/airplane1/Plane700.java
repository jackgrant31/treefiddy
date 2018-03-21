package airplane1;

public class Plane700 extends Airplane {
	int[] Passenger_Numbers = new int[118];
	int[] row7 = new int[118];

	public Plane700(int specNumSeats) {
		super(specNumSeats);
	};
	
	public static void main(String args[]) {
		
	}
	
	public void row7() {//this method assigns a row to each plane seat based on the plane and places it in a new array
		//this method needs to be specific for each plane, for custom planes only specify number or rows of 2 and 3 to keep it easy
		for(int i=0; i<NumSeats; i++) {
			if (Passenger_Numbers[i] < 13 ) {
				row7[i] = (int) (3+Passenger_Numbers[i])/4; //extra 3 comes from the way java rounds
			}
			else if(Passenger_Numbers[i] < 43 && Passenger_Numbers[i] > 12 ) { 
				row7[i] = (int) (11+Passenger_Numbers[i])/6;  //extra 11 compensates for the fact that the first few rows only have 4 seats, not 6 (add 6(2 per row)), and then an additional 5 for the rounding
				//ex. row 4 contains seats 13-18, but 24-29 will yeild a 4 so add 11
			}
			else if(Passenger_Numbers[i]>42 && Passenger_Numbers[i]<47) { //that stupid emergency row
				row7[i] = 9;
			}
			else {
			row7[i] = (13+Passenger_Numbers[i])/6;
			}
		}
	}
	
}
