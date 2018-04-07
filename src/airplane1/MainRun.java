package airplane1;

public class MainRun {
	static int count =0;
	static int[] best = new int[118];
	static int[] num = new int[1000];
	static int low = 900;

	public static void run()  {
        Airport air = new Airport();
        air.op700();
        air.boarding();
        num[count]=air.countr;
    }

    public static void main(String[] args)  {
    	while(count<1000) {
    	run();
    	count+=1;
    	System.out.println(count);
    }
    }

}
