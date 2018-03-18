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
		int temp=0, tempPassNum=0, tempPassNum1=1;
		plrow[tempCurrentRow] = 11; //equal to 11 if just moving along
		while (seatCount < se.NumSeats) {
			if(isRowBusy(tempCurrentRow+1)==false && plrow[tempCurrentRow]==11 ) { //to move every row
				for (int i=1; i<plrow.length; i++) {
					if (plrow[plrow.length-(i+1)] != 3 && plrow[plrow.length-(i+1)] != 6 && plrow[plrow.length-(i+1)] != 9) {
						plrow[plrow.length-i] = plrow[plrow.length-(i+1)];
					}
				}
				System.out.println(Arrays.toString(plrow));
				tempCurrentRow +=1;
				tempPassNum +=1;
				plrow[0]=11;
				
				
				
			} else { //if row is busy 
				System.out.println(Arrays.toString(plrow));
				for (int m=1; m<tempCurrentRow+1; m++) {
					if(plrow[m]==0) {
						for (int n = 1; n<m; m++) {
							plrow[n] =plrow[n-1];
						}
					}
					else if (plrow[m]==1 && tempCurrentRow==m) {
						plrow[m] = 0;
						tempCurrentRow-=1;
					}
					else if(plrow[m]!=0 && plrow[m]!=11 ) {
						temp = plrow[m];
						temp -=1;
						plrow[m] = temp;
					}
				}
			}
	//		for (int l=1; l<plrow.length;l++) {
	//			if(tempCurrentRow-l == se.row7[tempPassNum1+(l+1)] && plrow[l]==11){
	//				plrow[l] = (se.time[tempPassNum1+(l+1)]-1);
	//				tempPassNum1+=1;
	//			}
	//		}
			for (int l=1; l<plrow.length;l++) {
				if(l == se.row7[tempPassNum1+1] && plrow[l]==11){
					plrow[l] = (se.time[tempPassNum1+1]-1);
					tempPassNum1+=1;
				}
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
