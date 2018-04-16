package airplane1;

import java.util.Arrays;
import java.util.Scanner;

public class MainRun {
	//static int count =0;
	int[] best;
	int low, mov, avg, runs = 1000;
	int[] num = new int[runs];

    public static void main(String[] args) {
    		MainRun run = new MainRun();
    		run.run();
    }
    
    public void run() {
    	GUI gui = new GUI();
    	int plane=gui.getPlane();
    	int bd = gui.getbd();
    	mov = gui.getMove(); 
    	int lowcount=999, count=0;
    	Airport air1 = new Airport();
    best = new int[air1.NumSeats];
    	while(count<runs) {
    		Airport air = new Airport();
    		if (plane ==0) {
    			air.op700();
    		} else if (plane ==1) {
    			air.op800();
    		}else if (plane ==2) {
    			air.opA320();
    		} else {
    			air.opcustom();
    		}
    		if (bd==0) {
    			air.boarding();
    		} else {
    			air.deboarding();
    		}
    		num[count]=air.countr;
        if(air.countr<lowcount) {
        		best = air.pass1;
        		lowcount = air.countr;
        }
        count+=1;
    }
    	low = lowcount;
    	calcAvg();
    }
    
    public void calcAvg() {
    		int sum=0;
    		for(int i=0; i<runs; i++) {
    			sum += num[i];
    		}
    		avg = sum/runs;
    }
    
    public int getAvg() {
    		return avg;
    }
	public int[] getBest() {
		return best;
	}
	public int[] getNum() {
		return num;
	}
	public int getLow() {
		return low;
	}
	public int getMov() {
		return mov;
	}
}