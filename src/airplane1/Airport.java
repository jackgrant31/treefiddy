package airplane1;

public class Airport {
	Airplane airplane = new Airplane(118);
	int[] plrow = new int[airplane.rowMax()];
	
	public static void main(String args[]) {
		op700();
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
	
	
	
	private void isRowBusy()  {
		//row 0 is the walkway before the first row, so row[1] is row 1
		
		
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
