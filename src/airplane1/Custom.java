package airplane1;
public class Custom extends Airplane {

	public Custom(int specNumSeats) {
		super(specNumSeats);
	};
	int dum1,dum2;
	
	public static void main(String args[]) {
		
	}
	
	public void dum(String temp, String temp1) {
		dum1=Integer.parseInt(temp);
		dum2=Integer.parseInt(temp1);
	}
	
	public int getSeats() {
		int NumSeats = 4*getFour()+6*getSix();
		System.out.println(NumSeats +"ok");
		return NumSeats;
	}
	public int getFour() {
		return dum2;
	}
	public int getSix() {
		return dum1;
	}
}