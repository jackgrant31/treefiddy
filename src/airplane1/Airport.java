package airplane1;

import java.util.Arrays;

public class Airport {
	//static Airplane airplane = new Airplane(118);
	static Plane700 se = new Plane700(118);
	static int[] plrow = new int[22];
	static int countr=0;
	
	public static void main(String args[]) {
		op700();
		ultimate();
	}
	
	public static void op800() { //to populate 800 plane
		//for 800
				Plane800 ei = new Plane800(154);
				ei.populateArray();
	}
	
	public static void op700() { //to populate 700 plane, setup
		//for700
				se.populateArray();
				se.row7();
				se.timePP7();
	}
	
	public static void opA320() { //to populate A320 plane
		//forA320
				PlaneA320 a3 = new PlaneA320(150);
				a3.populateArray();
	}
	
	
	
	private static boolean isRowBusy(int j)  {
		//row 0 is the walkway before the first row, so row[1] is row 1
			if (plrow[j] != 0) {
				return true;
			} else {
				return false;
			}
	}
	
	
	
	private static void ultimate() {
		int seatCount=0;
		int tempCurrentRow=0;
		int[] temp2 = new int[22]; //temp row # that moves with primary
		int[] temp3 = new int[22]; //temp row time
		int temp=0, tempPassNum=1;
		plrow[tempCurrentRow] = 11; //equal to 11 if just moving along
		temp2[0]=se.row7[0];
		temp3[0]=se.time[0];
		
		while (seatCount < 118) {
			System.out.println(Arrays.toString(plrow));
			System.out.println(Arrays.toString(temp2));
			System.out.println(Arrays.toString(temp3));
			System.out.println(seatCount);
			for (int l=1; l<plrow.length;l++) {
				if(l == temp2[l] && plrow[l]==11){
					plrow[l] = (temp3[l]);
				}
			}
			// Check that the next row is open and the current row isnt being seated
			for (int i=1; i<plrow.length; i++) { // the whole length
				if(plrow[plrow.length-(i+1)] ==11 && plrow[plrow.length-i]==0) { //to move every row
					// For the entire plane rows, check that the current cell is not sitting and next cell is a zero. 
					
						// Move the passenger up one cell
						plrow[plrow.length-i] = plrow[plrow.length-(i+1)];
						temp2[plrow.length-i] = temp2[plrow.length-(i+1)];
						temp3[plrow.length-i] = temp3[plrow.length-(i+1)];
						
						// Set the previous cell to 0 after the passenger moves for the next loop
						plrow[plrow.length-(i+1)]=0;
						temp2[plrow.length-(i+1)]=0;
						temp3[plrow.length-(i+1)]=0;
				
			} else if(plrow[plrow.length-i] ==1){ //if row is busy 
				plrow[plrow.length-i] = 0;
				temp2[plrow.length-i] =0;
				temp3[plrow.length-i]=0;
				seatCount +=1;
			}else if(plrow[plrow.length-i] !=11 && plrow[plrow.length-i] !=0 && plrow[plrow.length-i] !=1){
				temp = plrow[plrow.length-i];
				temp -=1;
				plrow[plrow.length-i] = temp;
				}
			}
			
			if (plrow[0]==0 && tempPassNum!=118) { // Board a single passenger to row 0 if it is open
				plrow[0]=11;
				temp2[0] = se.row7[tempPassNum];
				temp3[0] = se.time[tempPassNum];
				tempPassNum+=1;
			}
			
			countr +=1;
		}
		System.out.println(countr);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void initAirport()  {

		//initAirplane();	

	}
	
	private void initAirplane()  {

		//initPlane()
	}
	
	private void initPassengers()  {

		
	}
	
	private void updatePassengers()  {

		//movePassenger()
	}
	
	private void updateAirplane	()  {

		
	}
}
