package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestOptimal {

	@Test
   	public void test() {
                 	/*After while loop runs, average time is calculated
                 	 */
                 	MainRun run = new MainRun();
                 	run.run(0, 0, 0);
                 	assertTrue(run.low<run.num[0]);
                 	}


}
