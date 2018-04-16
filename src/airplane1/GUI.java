package airplane1;

	import javafx.application.*;
	import javafx.stage.*;
	import javafx.scene.*;
	import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.*;

	public class GUI extends Application {

		Stage window;
		Scene scene1, scene2, scene3, scene4, scene5;
		int plane, bd, R4, R6,move;
		String sixs, fours, num1, num2;

		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) {
			window = primaryStage;

			//Button 1-3
			Label label1 = new Label("Please select an aircraft.");
			Button button1 = new Button("737-700");
			Button button2 = new Button("737-800");
			Button button3 = new Button("A320");
			Button button5 = new Button("Custom");
			button1.setOnAction(e -> { 
				window.setScene(scene5);
				plane=0;
			});
			button2.setOnAction(e -> { 
				window.setScene(scene5);
				plane=1;
			});
			button3.setOnAction(e -> { 
				window.setScene(scene5);
				plane=2;
			});
			Button button4 = new Button("Return to main page");
			button5.setOnAction(e -> { 
				window.setScene(scene4);
				plane=3;
			});

			//Layout 1 - children laid out in vertical column
			VBox layout1 = new VBox(7,label1, button1, button2, button3, button5);
			scene1 = new Scene(layout1, 200, 200);

			//Boarding pattern buttons
			Label label2 = new Label("Please select a boarding pattern.");
			Button seq = new Button("Sequential");
			Button seqB2F = new Button("Sequential (Back to Front)");
			Button zone = new Button("Zonal");
			Button rand = new Button("Random");
			
			
			button4.setOnAction(e -> window.setScene(scene1)); 
			seq.setOnAction(e -> {
				move=0;
				runThis();
				window.setScene(scene3);
			});
			seqB2F.setOnAction(e -> {
				move=1;
				runThis();
				window.setScene(scene3);
			});
			zone.setOnAction(e -> {
				move=2;
				runThis();
				window.setScene(scene3);
			});
			rand.setOnAction(e -> {
				move=3;
				runThis();
				window.setScene(scene3);
			});

			//Layout 2
			VBox layout2 = new VBox(7,seq,seqB2F,zone,rand);
			scene2 = new Scene(layout2, 200, 200);

			//Display scene 1 at first
			window.setScene(scene1);
			window.setTitle("Fleet Flight's Boarding");
			window.show();

			//scene3 stuff
			Label label2a = new Label("Lowest time:");
			Text label2b = new Text(num1);
			Label label3a = new Label("Average time:");
			Text label3b = new Text(num2); 
			Button buttond = new Button("quit this shit");
			buttond.setOnAction(e -> System.exit(0));

			//Layout 3
			VBox layout3 = new VBox(14,label2a, label2b,label3a,label3b,button4,buttond);
			scene3 = new Scene(layout3, 400, 400);

			//Layout4 stuff
			Label row4 = new Label("Please insert the number of rows of four:");
			
			TextField fieldFour = new TextField();
			fieldFour.setPromptText("Insert a number here");
			
			TextField fieldSix = new TextField();
			fieldSix.setPromptText("Insert a number here");

			Label row6 = new Label("Please insert the number of rows of six:");

			Button ok = new Button("Enter");

			ok.setOnAction(e -> {
				getCustom(fieldSix, fieldFour);
				window.setScene(scene5);
			});

			//Layout 4
			VBox layout4 =new VBox(7, row4, fieldFour, row6, fieldSix, ok);
			scene4 = new Scene(layout4, 275, 175);

			//Layout 5 (board- Deboard)
			Button board = new Button("Boarding");
			Button deboard = new Button("Deboarding");
			board.setOnAction(e -> {
				window.setScene(scene2);
				bd=0;
			});
			deboard.setOnAction(e -> {
				window.setScene(scene2);
				bd=1;
			});
			VBox layout5 = new VBox(7, board, deboard);
			scene5 = new Scene(layout5, 200, 200);
			
		}

public void getCustom(TextField fieldSix, TextField fieldFour) {
			sixs = fieldSix.getText();
			fours = fieldFour.getText();
		}

public void runThis() {
	MainRun run = new MainRun();
	run.run();
	num1= Integer.toString(run.getLow());
	num2= Integer.toString(run.getAvg());
	System.out.println(num1+num2);
}

public int getbd() {
	return bd;
}
public int getMove() {
	return move;
}
public int getPlane() {
	return plane;
}
public int getR4() {
	return Integer.parseInt(fours);
}
public int getR6() {
	return  Integer.parseInt(sixs);
}
}