package airplane1;

public class MainRun {
	int[] best;
	int low, avg, runs = 1000,temp1,temp2,temp3,bd1, NumSeats, sum=0;
	int[] num = new int[runs];
	
	public static void main(String args[]) {
	}
    
    public void run(int plane,int bd, int mov) {
    	int lowcount=100000000, count=0;
    	Airport air1 = new Airport();
    best = new int[air1.NumSeats];
    	while(count<runs) {
    		Airport air = new Airport();
    		air.init(mov);	
    		if (plane ==0) {
    			air.op700();
    		} else if (plane ==1) {
    			air.op800();
    		}else if (plane ==2) {
    			air.opA320();
    		} else {
    			air.getget(temp1, temp2, temp3);
    			air.opcustom();
    		}
    		if (bd==0) {
    			air.boarding();
    		} else {
    			air.deboarding();
    		}
    		bd1 = bd;
    		NumSeats = air.getNumSeats();
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
	public void specC(int temp, int tmep1, int tmep2) {
		temp1 = temp;
		temp2 = tmep1;
		temp3 =tmep2;
	}
}