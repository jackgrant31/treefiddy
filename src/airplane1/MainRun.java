package airplane1;

import java.util.Arrays;

public class MainRun {
	//static int count =0;
	int[] best;
	int[] num = new int[1000];
	int low = 900;

    public static void main(String[] args)  {
    	int lowcount=0, count=0;
    	MainRun run = new MainRun();
    	Airport air1 = new Airport();
    run.	best = new int[air1.NumSeats];
    	while(count<1000) {
    		Airport air = new Airport();
        air.op700();
        air.boarding();
        run.num[count]=air.countr;
        if(air.countr<lowcount) {
        		run.best = air.pass1;
        		lowcount = air.countr;
        }
        count+=1;
    }
    	System.out.println(Arrays.toString(run.best));
    	System.out.println(lowcount);
    }
    
    

}
