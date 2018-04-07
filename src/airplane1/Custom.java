package airplane1;
public class Custom extends Airplane {

	public Custom(int specNumSeats) {
		super(specNumSeats);
	};
	
	static int R4, R6;
	
	public static void main(String args[]) {
		int rows4 = 7, rows6 = 15;
		R4 = rows4 *4;
		R6 = rows6*6;
		int NumSeats = R4 + R6;
	}
	
}