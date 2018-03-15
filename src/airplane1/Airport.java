package airplane1;

import java.util.Arrays;

public class Airport {
	static Airplane airplane = new Airplane(118);
	static int[] plrow = new int[21];
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
				Plane700 se = new Plane700(118);
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
	
	private static boolean isRightRow(int j, int k) {
		if (j == k) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private static void ultimate() {
		System.out.println(Arrays.toString(plrow));
		int seatCount=-1;
		int tempCurrentRow=0;
		int temp=0, tempPassNum=0;
		plrow[tempCurrentRow] = 11; //equal to 11 if just moving along
		while (seatCount < airplane.NumSeats) {
			if(isRowBusy(tempCurrentRow+1)==false && plrow[tempCurrentRow]!=11 ) { //to move every row
				while(plrow[tempCurrentRow]==0) {
					tempCurrentRow-=1;
				}
				for (int i=plrow.length; i<0; i--) {
					plrow[i] = plrow[i-1];
					tempCurrentRow +=1;
					tempPassNum +=1;
					plrow[0] =1;
						for (int l=tempCurrentRow; l<0;l--) {
							if(isRightRow(l, airplane.row7[tempPassNum])==true){
								plrow[l] = airplane.time[tempPassNum];
							}
						}
				}
				
				
			} else { //if row is busy 
				
				for (int m=tempCurrentRow; m<0; m--) {
					if(plrow[m]==0) {
						for (int n = m; n<0; m--) {
							plrow[n] =plrow[n-1];
						}
						plrow[0]=1;
					}
					if(plrow[m]!=0 && plrow[m]!=11 ) {
						temp = plrow[m];
						temp -=1;
						plrow[m] = temp;
					}
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
