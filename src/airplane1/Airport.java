package airplane1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Airport {
	int countr=0, leftPlane=0, NumSeats;
	int tempCurrentRow=0, seatCount=0, rowNum, R4,R6,move;
	int temp=0, temp1=0,temp5=0, tempPassNum=1, temp7=0;
	int[] temp2, temp3, time1, row1, inAisle, plrow,pass1;
	
	public static void main(String args[]) {
		Airport airport = new Airport();
		airport.op800();
		airport.boarding();
	}
	
	public void op800() { //to populate 800 plane
				Plane800 ei = new Plane800(154);
				ei.init();
				R4=ei.getFour();
				R6=ei.getSix();
				ei.getNums(R4, R6);
				move=2;
				if(move == 0) {
					ei.populateArrayForward();
				}else if(move==1) {
					ei.populateArrayBackward();
				} else if (move==2) {
					ei.populateArrayZone();
				}else if(move==3){
					ei.populateArrayRandom();
				}
				ei.divideSeats();
				ei.row();
				ei.timePP();
				rowNum = ei.getRowNum()+1;
				NumSeats = ei.getNum();
				pass1 = ei.getPassenger();
				inAisle = new int[NumSeats];
				temp2 = new int[rowNum]; //temp row num
				temp3 = new int[rowNum]; //temp row time
				time1 = new int[NumSeats];
				row1 = new int[NumSeats];
				plrow = new int[rowNum];
				time1 = ei.getTime();
				row1 = ei.getRow();
	}
	
	public void op700() { //to populate 700 plane, setup
				Plane700 se = new Plane700(118);
				se.init();
				if(move == 0) {
					se.populateArrayForward();
				}else if(move==1) {
					se.populateArrayBackward();
				} else if (move==2) {
					se.populateArrayZone();
				}else {
					se.populateArrayRandom();
				}
				se.populateArrayRandom();
				se.divideSeats();
				se.row7();
				se.timePP();
				rowNum = se.getRow7Num()+1;
				NumSeats = se.getNum();
				pass1 = se.getPassenger();
				inAisle = new int[NumSeats];
				temp2 = new int[rowNum]; //temp row num
				temp3 = new int[rowNum]; //temp row time
				time1 = new int[NumSeats];
				row1 = new int[NumSeats];
				plrow = new int[rowNum];
				time1 = se.getTime();
				row1 = se.getRow7();
	}
	
	public void opA320() { //to populate A320 plane
				PlaneA320 a3 = new PlaneA320(150);
				a3.init();
				R4=a3.getFour();
				R6=a3.getSix();
				a3.getNums(R4, R6);
				if(move == 0) {
					a3.populateArrayForward();
				}else if(move==1) {
					a3.populateArrayBackward();
				} else if (move==2) {
					a3.populateArrayZone();
				}else {
					a3.populateArrayRandom();
				}
				a3.divideSeats();
				a3.row();
				a3.timePP();
				rowNum = a3.getRowNum()+1;
				NumSeats = a3.getNum();
				pass1 = a3.getPassenger();
				inAisle = new int[NumSeats];
				temp2 = new int[rowNum]; //temp row num
				temp3 = new int[rowNum]; //temp row time
				time1 = new int[NumSeats];
				row1 = new int[NumSeats];
				plrow = new int[rowNum];
				time1 = a3.getTime();
				row1 = a3.getRow();
	}
	
	public void opcustom() {
		Custom cu = new Custom(NumSeats);
		cu.getNums(R4, R6);
		cu.init();
		if(move == 0) {
			cu.populateArrayForward();
		}else if(move==1) {
			cu.populateArrayBackward();
		} else if (move==2) {
			cu.populateArrayZone();
		}else {
			cu.populateArrayRandom();
		}
		cu.divideSeats();
		cu.row();
		cu.timePP();
		rowNum = cu.getRowNum()+1;
		pass1 = cu.getPassenger();
		inAisle = new int[NumSeats];
		temp2 = new int[rowNum]; //temp row num
		temp3 = new int[rowNum]; //temp row time
		time1 = new int[NumSeats];
		row1 = new int[NumSeats];
		plrow = new int[rowNum];
		time1 = cu.getTime();
		row1 = cu.getRow();
	}
	
	public void init(int mov) {
		move = mov;
	}
	
	public void getget(int ok, int ok1, int ok2) {
		NumSeats = ok;
		R4 = ok1;
		R6 = ok2;
	}
	
	public void initBoard() {
		plrow[tempCurrentRow] = 11; //equal to 11 if just moving along
		temp2[0]=row1[0];
		temp3[0]=time1[0];
	}
	
	
	public void checkSeat() {
		for (int l=1; l<plrow.length;l++) {
			if(l == temp2[l] && plrow[l]==11){
				plrow[l] = (temp3[l]);
			}
		}
	}
	
	public void move(int i) {
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
	
	public void resetRow(int i) {
		plrow[plrow.length-i] = 0;
		temp2[plrow.length-i] =0;
		temp3[plrow.length-i]=0;
		seatCount +=1;
	}
	
	public void printB() {
		System.out.println(Arrays.toString(plrow));
		System.out.println(Arrays.toString(temp2));
		System.out.println(Arrays.toString(temp3));
		System.out.println(seatCount);
	}
	
	public void decreaseTime(int i) {
		temp = plrow[plrow.length-i];
		temp -=1;
		plrow[plrow.length-i] = temp;
	}
	
	public void boardPassenger() { //if the waiting row is free
		plrow[0]=11;
		temp2[0] = row1[tempPassNum];
		temp3[0] = time1[tempPassNum];
		tempPassNum+=1;
	}
	
	public void boarding() {
		initBoard();
		while (seatCount < NumSeats) {
			checkSeat();
			//printB();
			for (int i=1; i<plrow.length; i++) { // the whole length
				if(plrow[plrow.length-(i+1)] ==11 && plrow[plrow.length-i]==0) { // Check that the next row is open and the current row isnt being seated
					move(i);
				} else if(plrow[plrow.length-i] ==1){ //if row is busy 
					resetRow(i);
				}else if(plrow[plrow.length-i] !=11 && plrow[plrow.length-i] !=0 && plrow[plrow.length-i] !=1){
					decreaseTime(i);
				}
			}
			if (plrow[0]==0 && tempPassNum!=NumSeats) { // Board a single passenger to row 0 if it is open
				boardPassenger();
			}	
			countr +=1;
		}
		//System.out.println(countr);
	}
	
	public void deboarding() {
		while ( leftPlane < NumSeats) {
			for (int k = 1; k < NumSeats +1;k++) {
				temp1=k;
				if (IntStream.of(inAisle).anyMatch(x -> x==temp1)==false) { //create inAisle array and search here
					getInAisle(k);
				}
			}
			//printD();
			for (int i=1; i<plrow.length; i++) {
				if (plrow[i] == 11) {
					moveInAisle(i);
				} else if (plrow[i]!=0 && plrow[i]!=11) {
					timeDown(i);
				} 
			} 
			countr+=1;
			//System.out.println(countr);
		} 
	}
	
	public void timeDown(int i) {
		int temp = 0;
		temp=plrow[i];
		temp -=1;
		plrow[i]=temp;
		if (plrow[i]==0) {
			plrow[i]=11;
	}}
	
	public void moveInAisle(int i) {
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
	
	public void getInAisle(int k) {
		temp7 = row1[k-1];
		if (plrow[temp7]==0) {
			plrow[temp7]= time1[k-1]; 
			inAisle[temp5]=k;
			temp5+=1;
		}
	}
	
	public void printD() {
		System.out.println(Arrays.toString(inAisle));
		System.out.println(Arrays.toString(plrow));
	}
	
}