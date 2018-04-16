package airplane1;
public class Custom extends Airplane {

	public Custom(int specNumSeats) {
		super(specNumSeats);
	};
	int dum1,dum2;
	
	public static void main(String args[]) {
		
	}
	
	public void dum(int temp, int temp1) {
		dum1=temp;
		dum2=temp1;
	}
	
	public int getSeats() {
		int NumSeats = 4*getFour()+6*getSix();
		return NumSeats;
	}
	public int getFour() {
		return dum1;
	}
	public int getSix() {
		return dum2;
	}
}