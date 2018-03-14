package airplane1;
import java.util.Arrays;



public class Airplane { //airplane houses passengers and methods relating to them

	public int NumSeats=118;
	
	public Airplane(int specNumSeats) {
		NumSeats = specNumSeats;
	}
	int[] Passenger_Numbers = new int[NumSeats];
	int[] Plane_Seats = new int[NumSeats];
	int[] row7 = new int[NumSeats];
	int[] time = new int[NumSeats];
	
	
	public void populateArray() { //this creates a seating array and random passenger array//put in inherited classes for different capacities
		
		
			Plane_Seats = java.util.stream.IntStream.rangeClosed(1, NumSeats).toArray();//Generates list of seats from 1 to First_Plane's value
		
			
				for (int j = 0; j < Passenger_Numbers.length; j++){
					Passenger_Numbers[j] = (int) (1 + Math.random()*NumSeats);
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
		System.out.println(Arrays.toString(row7));
	}

	public void timePP7() { //time per person (for plane 7) there is a way to do this not hardcoded... working on it
		int temp4 = 0, temp7 = 0, temp10=0, temp, temp1, temp2=0; //plane 7 has 40 4, 39 7, 39 10, this is enforced in the while loop
		for(int i=0; i<NumSeats; i++) {
			temp = (int) ( (3*Math.random())+1);	//yields a 1,2 or 3 randomly
			temp1 = 3*temp+1; // with quik maffs, yeilds 4,7,10
			while ((temp4 > 39 && temp1 == 4) || (temp7>38 && temp1 ==7) || (temp10>38 && temp1==10) ){
				temp = (int) ( (3*Math.random())+1);	
				temp1 = 3*temp+1;
			}
			time[i]  =temp1;
			if(temp1==4) {
				temp4 +=1;
			}
			else if(temp1==7) {
				temp7 +=1;
			}
			else{
				temp10 +=1;
			}
			}
		for(int i=0; i<NumSeats; i++) {
			if(time[i]==4) {
				temp2 += 1;
			}
		}
		System.out.println(Arrays.toString(time));
		System.out.println(temp2);
		
	}
	
	public int rowMax() {
		int rmax =0;
		for(int i=0; i<NumSeats; i++) {
			if (row7[i] > rmax) {
				row7[i] = rmax;
			}
		}
		return rmax;
	}
	
	public void setNumSeats(int temp) {
		NumSeats = temp;
	}
	
	private void checkIsBoarded()  {
		//no
	}
	
	
}
