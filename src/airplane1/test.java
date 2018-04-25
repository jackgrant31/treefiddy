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

	public class test extends Application {

		Stage window1;
		Scene scene1, scene2, scene3, scene4, scene5,scene8, hscene;
		GridPane gridPane1;
		int plane, bd, R4, R6,move,temp,first;
		int[] best, num,histo1;
		String sixs, fours, num1, num2, t1, t2, t3;
		Label label2b, label3b, step1;
		XYChart.Series series1;
		
		 final static String austria = "Austria";
		    final static String brazil = "Brazil";
		    final static String france = "France";
		    final static String italy = "Italy";
		    final static String usa = "USA";
		    int[] histo;
		    final CategoryAxis xAxis = new CategoryAxis();
			final NumberAxis yAxis = new NumberAxis();
		    final BarChart<String,Number> bc =new BarChart<String,Number>(xAxis,yAxis);

		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) {
			Stage stage2 = new Stage();
			window1 = stage2;
			stage2.setResizable(false);
			
			//hist attempt

			//primaryStage.setTitle("Bar Chart Sample");
			
			bc.setTitle("Frequency Graph");
			xAxis.setLabel("Time (seconds)");       
			yAxis.setLabel("Frequency");
			
			series1 = new XYChart.Series();   
	        
			Scene scene  = new Scene(bc,800,600);
	       // bc.getData().addAll(series1);
	        stage2.setScene(scene);
			stage2.show();
}
		
		public void addData(int[] temp, Stage primaryStage, int temp2) {
			first = temp2;
			histo1 = temp;
				int count1=histo1[0];
				for(int i=0;i<histo1.length;i++) {
					series1.getData().add(new XYChart.Data(Integer.toString(first+count1), histo1[i]));
					count1+=1;
				}
				
				bc.getData().addAll(series1);	
			
		}
}