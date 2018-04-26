package airplane1;

import java.util.Arrays;

import javafx.application.*;
	import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;

	public class GUI extends Application {

		Stage window;
		Scene scene1, scene2, scene3, scene4, scene5,scene8, hscene;
		GridPane gridPane1;
		int plane, bd, R4, R6,move,temp, first;
		int[] best, num,histo;
		String sixs, fours, num1, num2, t1, t2, t3;
		Label label2b, label3b, step1;
		XYChart.Series series1;
		
		 final static String austria = "Austria";
		    final static String brazil = "Brazil";
		    final static String france = "France";
		    final static String italy = "Italy";
		    final static String usa = "USA";

		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) {
			window = primaryStage;
			primaryStage.setResizable(false);
			
			//hist attempt

			//primaryStage.setTitle("Bar Chart Sample");
			final CategoryAxis xAxis = new CategoryAxis();
			final NumberAxis yAxis = new NumberAxis();
			final BarChart<String,Number> bc = 
					new BarChart<String,Number>(xAxis,yAxis);
			bc.setTitle("Frequency Graph");
			xAxis.setLabel("Time (seconds)");       
			yAxis.setLabel("Frequency");
			
			series1 = new XYChart.Series();   
	        
	        Scene scene  = new Scene(bc,800,600);
	        bc.getData().addAll(series1);
	     
			
			//sets button shadow
			DropShadow dropShadow = new DropShadow ();
			dropShadow.setRadius (2.0);
			dropShadow.setOffsetX (3.0);
			dropShadow.setOffsetY (3.0);
			dropShadow.setColor ( Color.color (0.4 , 0.5 , 0.5));
			
			//Button 1-3
			Label label1 = new Label("Please select an aircraft:");
			label1.setFont(Font.font("Times New Roman", 16));
			label1.setLayoutX(10);
			Button button1 = new Button("737-700");
			button1.setEffect(dropShadow);
			Button button2 = new Button("737-800");
			button2.setEffect(dropShadow);
			Button button3 = new Button("A320");
			button3.setEffect(dropShadow);
			Button button5 = new Button("Custom");	
			button5.setEffect(dropShadow);
			
			button1.setOnAction(e -> { 
				window.setScene(scene5);
				plane=0;
				
			});
			button2.setOnAction(e -> { 
				window.setScene(scene5);
				plane=1;
			});
			button3.setOnAction(e -> { 
				plane=2;
				window.setScene(scene5);
			});
			Button button4 = new Button("Return to main page");
			button4.setEffect(dropShadow);
			button5.setOnAction(e -> { 
				plane=3;
				window.setScene(scene4);
			});

			//Layout 1 - children laid out in vertical column
			Pane layout1 = new Pane(label1, button1, button2, button3, button5);
			layout1.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
			scene1 = new Scene(layout1, 400, 400);

			//Boarding pattern buttons
			Label label2 = new Label("Please select a boarding pattern: ");
			label2.setFont(Font.font("Times New Roman", 16));
			label2.setLayoutX(10);
			Button seq = new Button("Sequential (Front to Back)");
			seq.setEffect(dropShadow);
			Button seqB2F = new Button("Sequential (Back to Front)");
			seqB2F.setEffect(dropShadow);
			Button zone = new Button("Zonal");
			zone.setEffect(dropShadow);
			Button rand = new Button("Random");
			rand.setEffect(dropShadow);
						
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
			Pane layout2 = new Pane(button4,label2,seq,seqB2F,zone,rand);
			layout2.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
			scene2 = new Scene(layout2, 400, 400);

			//Display scene 1 at first
			window.setScene(scene1);
			window.setTitle("Fleet Flight's Boarding");
			window.show();

			//scene3 stuff
			Label label2a = new Label("Lowest time:");
			label2a.setFont(Font.font("Times New Roman", 16));
			label2a.setLayoutX(10);

			
			Label label3a = new Label("Average time:");
			label3a.setFont(Font.font("Times New Roman", 16));
			label3a.setLayoutX(10);
			label3a.setLayoutY(80);
			label2b = new Label(num1);
			label3b = new Label(num1);
			label2b.setLayoutX(20);
			label2b.setLayoutY(30);
			label2b.setFont(Font.font("Times New Roman", 16));
			label3b.setLayoutX(20);
			label3b.setLayoutY(110);
			label3b.setFont(Font.font("Times New Roman", 16));
			
			Button buttond = new Button("Close Program");
			buttond.setEffect(dropShadow);
			
			buttond.setOnAction(e -> System.exit(0));
			
			// labels for the side window with steps user has chosen
			step1 = new Label("User choices: "+ "\n>" + t1 + "\n\n>" + t2 + "\n\n>" + t3);
			step1.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			step1.setFont(Font.font("Times New Roman", 16));
			step1.setLayoutX(200);
			
			//Layout 3
			
			//button for histogram
			Button hist = new Button("Show Histogram");
			hist.setLayoutX(10);    //set value to 320 if you want it centered
			hist.setLayoutY(300);
			hist.setEffect(dropShadow);
			
			//histogram pane 
			Pane Hist = new Pane(button4, buttond);
			Hist.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
			//hscene = new Scene(Hist, 800, 800);
			hist.setOnAction(e ->{
				outputHistogram(num);
				Histogram test = new Histogram();
				test.start(primaryStage);
				test.addData(histo, primaryStage,first);
				
			});
			
			//Layout 3
			Pane layout3 = new Pane(label2a, label2b,label3a,label3b,button4,buttond,step1,hist);
			layout3.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
			scene3 = new Scene(layout3, 400, 400);

			//Layout4 stuff
			Label row4 = new Label("Please insert the number of rows of four:");
			row4.setFont(Font.font("Times New Roman", 16));
			row4.setLayoutX(10);
			row4.setLayoutY(10);
			
			TextField fieldFour = new TextField();
			fieldFour.setPromptText("Insert a number here");
			fieldFour.setLayoutX(10);
			fieldFour.setLayoutY(50);
			
			TextField fieldSix = new TextField();
			fieldSix.setPromptText("Insert a number here");
			fieldSix.setLayoutX(10);
			fieldSix.setLayoutY(130);
			
			Label row6 = new Label("Please insert the number of rows of six:");
			row6.setFont(Font.font("Times New Roman", 16));
			row6.setLayoutX(10);
			row6.setLayoutY(100);
			Button ok = new Button("Enter");
			ok.setLayoutX(10);
			ok.setLayoutY(180);
			
			ok.setOnAction(e -> {
				getCustom(fieldSix, fieldFour);
				Custom cu = new Custom(1);
				cu.dum(sixs, fours);
				temp =cu.getSeats();
				window.setScene(scene5);
			});


			//Layout 4
			Pane layout4 =new Pane(row4, fieldFour, row6, fieldSix, ok);
			layout4.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
			scene4 = new Scene(layout4, 400, 400);

			//Layout 5 (board- Deboard)
			Button board = new Button("Boarding");
			board.setEffect(dropShadow);
			Button deboard = new Button("Deboarding");
			deboard.setEffect(dropShadow);
			board.setOnAction(e -> {
				window.setScene(scene2);
				bd=0;
				});
			deboard.setOnAction(e -> {
				window.setScene(scene2);
				bd=1;
			});
			Label BDlabel = new Label("Please choose to board or deboard for this simulation:");
			BDlabel.setFont(Font.font("Times New Roman", 16));
			BDlabel.setLayoutX(10);
			
			Pane layout5 = new Pane(BDlabel, board, deboard);
			layout5.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
			scene5 = new Scene(layout5, 400, 400);
			
			//800 button
				button1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			button1.setLayoutX(10);
			button1.setLayoutY(40);
			//900 button
				button2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			button2.setLayoutX(10);
			button2.setLayoutY(80);
			//320 button
				button3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			button3.setLayoutX(10);
			button3.setLayoutY(120);
			//custom button
				button5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			button5.setLayoutX(10);
			button5.setLayoutY(160);
			//return button
				button4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			button4.setLayoutX(10);
			button4.setLayoutY(350);
			//board button
				board.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			board.setLayoutX(10);
			board.setLayoutY(40);
			//deboard button
				deboard.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			deboard.setLayoutX(10);
			deboard.setLayoutY(80);
			//sequential boarding button
				seq.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			seq.setLayoutX(10);
			seq.setLayoutY(40);
			//back to front sequential boarding button
				seqB2F.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			seqB2F.setLayoutX(10);
			seqB2F.setLayoutY(80);
			//zonal boarding button
				zone.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			zone.setLayoutX(10);
			zone.setLayoutY(120);
			//random boarding button
				rand.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			rand.setLayoutX(10);
			rand.setLayoutY(160);
			//close the program button
				buttond.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			buttond.setLayoutX(250);
			buttond.setLayoutY(350);
		}
		
		public void outputHistogram(int [] list)	{
			Arrays.sort(list);
			first =list[0];
			int  last = list[list.length-1], tcount=0, temp =first;
			histo = new int[(last+1)-first];
			for (int j=0;j<(last+1)-first;j++) {
			for(int i=0;i<list.length;i++) {
				if(list[i] == temp) {
					tcount +=1;
				}
			}
			temp+=1;
			histo[j]=tcount;
			tcount=0;
			}
		}
		
		public void setAll() {
			setc1();
			setc2();
			setc3();
		}
		
		public void setc1() {
			if (plane ==0) {
    			t1="Boeing 737-700";
    		} else if (plane ==1) {
    			t1="Boeing 737-800";
    		}else if (plane ==2) {
    			t1="Airbus A320";
    		} else {
    			t1="Custom Plane";
    		}
		}

		public void setc2() {
			if (bd==0) {
    			t2="Boarding";
    		} else {
    			t2="Deboarding";
    		}
		}

		public void setc3() {
			if(move == 0) {
				t3="Sequential Front to Back";
			}else if(move==1) {
				t3="Sequential Back to Front";
			} else if (move==2) {
				t3="Zonal";
			}else if(move==3){
				t3="Random";
			}
		}

public void getCustom(TextField fieldSix, TextField fieldFour) {
			sixs = fieldSix.getText();
			fours = fieldFour.getText();
		}

public void runThis() {
	MainRun run = new MainRun();
	if (plane==3) {
	run.specC(temp, Integer.parseInt(fours), Integer.parseInt(sixs));
	}
	run.run(plane, bd, move);
	num1= Integer.toString(run.getLow());
	num2= Integer.toString(run.getAvg());
	setAll();
	label2b.setText(String.format(num1 + " seconds"));
	label3b.setText(String.format(num2 + " seconds"));
	step1.setText(String.format((" User choices: "+ "\n  > " + t1 + " \n\n  > " + t2 + " \n\n  > " + t3 +" ")));
	num = run.getNum();
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