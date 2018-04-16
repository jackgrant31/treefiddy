package airplane1;
public class Custom extends Airplane {

	public Custom(int specNumSeats) {
		super(specNumSeats);
	};
	
	
	public static void main(String args[]) {
		
	}
	
	public int getSeats() {
		int NumSeats = 4*getFour()+6*getSix();
		return NumSeats;
	}
	public int getFour() {
		GUI gui = new GUI();
		return gui.getR4();
	}
	public int getSix() {
		//GUI gui = new GUI();
		return 30;//gui.getR6();
	}
}