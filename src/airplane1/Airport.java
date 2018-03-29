package airplane1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Airport {
	static Plane700 se = new Plane700(118);
	static int[] plrow = new int[22];
	static int countr=0, leftPlane=0;
	static int tempCurrentRow=0, seatCount=0;
	static int[] temp2 = new int[22]; //temp row # that moves with primary
	static int[] temp3 = new int[22]; //temp row time
	static int temp=0, temp1=0,temp5=0, tempPassNum=1, temp7=0;
	static int[] inAisle = new int[118];
	
	public static void main(String args[]) {
		op700();
		boarding();
	}
	
	public static void op800() { //to populate 800 plane
		//for 800
				Plane800 ei = new Plane800(154);
				ei.populateArrayRandom();
	}
	
	public static void op700() { //to populate 700 plane, setup
		//for700
				se.populateArrayZone();
				se.row7();
				se.timePP7();
	}
	
	public static void opA320() { //to populate A320 plane
		//forA320
				PlaneA320 a3 = new PlaneA320(150);
				a3.populateArrayRandom();
	}
	
	private static boolean isRowBusy(int j)  {
		//row 0 is the walkway before the first row, so row[1] is row 1
			if (plrow[j] != 0) {
				return true;
			} else {
				return false;
			}
	}
	
	public static void initBoard() {
		plrow[tempCurrentRow] = 11; //equal to 11 if just moving along
		temp2[0]=se.row7[0];
		temp3[0]=se.time[0];
	}
	
	
	public static void checkSeat() {
		for (int l=1; l<plrow.length;l++) {
			if(l == temp2[l] && plrow[l]==11){
				plrow[l] = (temp3[l]);
			}
		}
	}
	
	public static void move(int i) {
		// For the entire plane rows, check that the current cell is not sitting and next cell is a zero. 
		// Move the passenger up one cell
		plrow[plrow.length-i] = plrow[plrow.length-(i+1)];
		temp2[plrow.length-i] = temp2[plrow.length-(i+1)];
		temp3[plrow.length-i] = temp3[plrow.length-(i+1)];
		
		// Set the previous cell to 0 after the passenger moves for the next loop
		plrow[plrow.length-(i+1)]=0;
		temp2[plrow.length-(i+1)]=0;
		temp3[plrow.length-(i+1)]=0;
	}
	
	public static void resetRow(int i) {
		plrow[plrow.length-i] = 0;
		temp2[plrow.length-i] =0;
		temp3[plrow.length-i]=0;
		seatCount +=1;
	}
	
	public static void printB() {
		System.out.println(Arrays.toString(plrow));
		System.out.println(Arrays.toString(temp2));
		System.out.println(Arrays.toString(temp3));
		System.out.println(seatCount);
	}
	
	public static void decreaseTime(int i) {
		temp = plrow[plrow.length-i];
		temp -=1;
		plrow[plrow.length-i] = temp;
	}
	
	public static void boardPassenger() { //if the waiting row is free
		plrow[0]=11;
		temp2[0] = se.row7[tempPassNum];
		temp3[0] = se.time[tempPassNum];
		tempPassNum+=1;
	}
	
	private static void boarding() {
		initBoard();
		while (seatCount < 118) {
			checkSeat();
			printB();
			for (int i=1; i<plrow.length; i++) { // the whole length
				if(plrow[plrow.length-(i+1)] ==11 && plrow[plrow.length-i]==0) { // Check that the next row is open and the current row isnt being seated
					move(i);
				} else if(plrow[plrow.length-i] ==1){ //if row is busy 
					resetRow(i);
				}else if(plrow[plrow.length-i] !=11 && plrow[plrow.length-i] !=0 && plrow[plrow.length-i] !=1){
					decreaseTime(i);
				}
			}
			if (plrow[0]==0 && tempPassNum!=118) { // Board a single passenger to row 0 if it is open
				boardPassenger();
			}	
			countr +=1;
		}
		System.out.println(countr);
	}
	
	public static void deboarding() {
		while ( leftPlane < 118) {
			for (int k = 1; k < 119;k++) {
				temp1=k;
				if (IntStream.of(inAisle).anyMatch(x -> x==temp1)==false) { //create inAisle array and search here
					getInAisle(k);
				}
			}
			printD();
			for (int i=1; i<plrow.length; i++) {
				if (plrow[i] == 11) {
					moveInAisle(i);
				} else if (plrow[i]!=0 && plrow[i]!=11) {
					timeDown(i);
				} 
			} 
			countr+=1;
			System.out.println(countr);
		} 
	}
	
	public static void timeDown(int i) {
		int temp = 0;
		temp=plrow[i];
		temp -=1;
		plrow[i]=temp;
		if (plrow[i]==0) {
			plrow[i]=11;
	}}
	
	public static void moveInAisle(int i) {
		if (plrow[i] == 11) {
			if (plrow[i-1] == 0) {
				plrow[i-1] = plrow[i];
				plrow[i] = 0;
				if (i-1 == 0) {
					leftPlane+=1;
					plrow[0] = 0;
				} 
			}
	}
	}
	
	public static void getInAisle(int k) {
		temp7 = se.row7[k-1];
		if (plrow[temp7]==0) {
			plrow[temp7]= se.time[k-1]; 
			inAisle[temp5]=k;
			temp5+=1;
		}
	}
	
	public static void printD() {
		System.out.println(Arrays.toString(inAisle));
		System.out.println(Arrays.toString(plrow));
	}
	
	
}
	
	
	
	

