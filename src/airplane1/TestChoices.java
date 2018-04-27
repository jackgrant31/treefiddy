package airplane1;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestChoices {
	   	int choice, time;
	   	String t1, t2;
	   	
	   	@Test
	   	public void test() {
	          	//GUI Displaying boarding type and time
	          	//Boarding type will be button1
	          	//Time will be t1, simulating user choices
	          	
	          	if (choice==0 ) { //simulate first button pressed
	                 	t1="Boarding Time";//Boarding Type
	          	}
	          	assertTrue(choice==0 && t1=="Boarding Time");
	   	}

	}

