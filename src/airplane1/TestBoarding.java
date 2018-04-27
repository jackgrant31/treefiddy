package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBoarding {
	@Test
   	public void test() {//if the waiting row is free
          	
               MainRun run = new MainRun();
               run.run(0, 0, 0);
               assertTrue(run.bd1==0); //bd1 is the variabvle that runs the boarding method
   	}

}
