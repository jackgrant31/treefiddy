package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIterations {
	@Test
	public void test() {
		MainRun run = new MainRun();
      	assertTrue(run.runs == 1000);
	}

}
