package airplane1;

public class Airport {

	
	public static void main(String args[]) {
		op800();
	}
	
	public static void op800() { //to populate 800 plane
		//for 800
				Plane800 ei = new Plane800(154);
				ei.populateArray();
	}
	
	public void op700() { //to populate 700 plane
		//for700
				Plane700 se = new Plane700(118);
				se.populateArray();
	}
	
	public void opA320() { //to populate A320 plane
		//forA320
				PlaneA320 a3 = new PlaneA320(150);
				a3.populateArray();
	}
}
