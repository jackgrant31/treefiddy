package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestExit {
	int MouseClick;
   	String t1;
   	@Test
   	public void test() {
          	//If the mouse is clicked, it equals 0 therefore boarding runs
          	MouseClick =1;
          	if (MouseClick==1) { //this is just the theory fir a GUI exit
                 	t1="Close Program";//Random boarding type
          	}
          	assertTrue(MouseClick==1);
   	}

}
