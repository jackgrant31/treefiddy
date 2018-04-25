package airplane1;

import java.util.Arrays;

public class Airplane { //airplane houses passengers and methods relating to them

	public int NumSeats;
	int[] Passenger_Numbers, Plane_Seats, temp5, time, row, row7;
	int rmax =0, R6 , R4,R41,R61 , temp = 0;
	int row2=0, row3=0;
	int seats4 = 0, seats7 = 0, seats10 = 0;
	
	public Airplane( int specNumSeats) {
		NumSeats = specNumSeats;
	}
	
	public void init() {
		Passenger_Numbers = new int[NumSeats];
		Plane_Seats = new int[NumSeats];
		row7 = new int[NumSeats];
		row = new int[NumSeats];
		time = new int[NumSeats];
		temp5 = new int[NumSeats];
	}
	
	
	public void populateArrayRandom() { //random
			Plane_Seats = java.util.stream.IntStream.rangeClosed(1, NumSeats).toArray();//Generates list of seats from 1 to First_Plane's value
				for (int j = 0; j < Plane_Seats.length; j++){
					Passenger_Numbers[j] = (int) (1 + Math.random()*NumSeats);
					if (j > 0) {
						for (int k = 0; k <= j-1; k++) {
							if (Passenger_Numbers[k] == Passenger_Numbers[j]) {
								j--;
							}
						}
					}
				}
	}
	
	public void selectData(int temp1, int temp2) {
		for (int i = 0; i < Passenger_Numbers.length; i++){ //economy 1
			if (Passenger_Numbers[i] < temp2 && Passenger_Numbers[i] > temp1) {
				temp5[temp] = Passenger_Numbers[i];
				temp += 1;
			}
		}
	}
	
	public void populateArrayZone() {
		populateArrayRandom();
		R4=4*R41;
		R6=6*R61;
		selectData(0,R4+1);
		selectData(R4,(R4 + 1)+(R6/3));
		selectData((R4)+(R6/3),(R4+1)+2*(R6/3));
		selectData((R4)+2*(R6/3),(R4 + 1)+3*(R6/3));
		for(int i=0;i<Passenger_Numbers.length;i++) {
			Passenger_Numbers[i]=temp5[i];
		}
		}//End Main
	
	public void populateArrayForward() {
		Passenger_Numbers = java.util.stream.IntStream.rangeClosed(1, NumSeats).toArray();
	}
	
	public void getNums(int four, int six) {
		R41=four;
		R61=six;
	}
	
	public void populateArrayBackward() {
		Plane_Seats = java.util.stream.IntStream.rangeClosed(1, NumSeats).toArray();
		for (int i=1; i<Plane_Seats.length+1;i++) {
			Passenger_Numbers[i-1]=Plane_Seats[Plane_Seats.length-i];
		}
	}
	
	public void row() {//this method assigns a row to each plane seat based on the plane and places it in a new array
		//this method needs to be specific for each plane, for custom planes only specify number or rows of 2 and 3 to keep it easy
		row2 = R41;
		System.out.println(NumSeats);
		for(int i=0; i<NumSeats; i++) {
			if (Passenger_Numbers[i] < (row2*4)+1 ) {//row2 is the number of rows of 4
				row[i] = (int) (3+Passenger_Numbers[i])/4; //extra 3 comes from the way java rounds
			} else { 
				row[i] = (int) ((5+2*row2)+Passenger_Numbers[i])/6;  //extra 11 compensates for the fact that the first few rows only have 4 seats, not 6 (add 6(2 per row)), and then an additional 5 for the rounding
			}
		}
	}

	public void timePP() { //time per person (for plane 7) there is a way to do this not hardcoded... working on it
		int temp4 = 0, temp7 = 0, temp10=0, temp, temp1, temp2=0; //plane 7 has 40 4, 39 7, 39 10, this is enforced in the while loop
		for(int i=0; i<NumSeats; i++) {
			temp = (int) ( (3*Math.random())+1);	//yields a 1,2 or 3 randomly
			temp1 = 3*temp+1; // with quik maffs, yeilds 4,7,10
			while ((temp4 > seats4 && temp1 == 4) || (temp7> seats7 && temp1 ==7) || (temp10> seats10 && temp1==10) ){
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
	}
	

	
	public void divideSeats() {
		if (Math.round( (double) NumSeats/3 ) >NumSeats/3){
			seats4 = (int) Math.round(NumSeats/3) +1;
			seats7 = (int) Math.round(NumSeats/3) +1;
			seats10 = NumSeats- seats4- seats7;
		}
		else if (Math.round(NumSeats/3 ) <NumSeats/3) {
			seats4 = (int) Math.round(NumSeats/3) +1;
			seats7 = (int) Math.round(NumSeats/3);
			seats10 = NumSeats- seats4- seats7;
		} else {
			seats4 = (int) Math.round(NumSeats/3) ;
			seats7 = (int) Math.round(NumSeats/3);
			seats10 = NumSeats- seats4- seats7;
		}
	}
	
	public int rowMax() {
		for(int i=0; i<NumSeats; i++) {
			if (row[i] > rmax) {
				rmax = row[i];
			}
		}
		return rmax;
	}
	
	public void setSeats(int[] temp) {
		Passenger_Numbers = temp;
	}
	
	public void setNumSeats(int temp) {
		NumSeats = temp;
	}
	
	public int[] getPassenger() {
		return Passenger_Numbers;
	}
	public int[] getTime() {
		return time;
	}
	public int[] getRow() {
		return row;
	}
	public int getNum() {
		return NumSeats;
	}
	public int getRowNum() {
		return rowMax();
	}
}
