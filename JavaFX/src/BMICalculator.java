import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BMICalculator extends Application {
	double bmi = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("BMI Calculator");
		
		Text explain = new Text();
		explain.setText("Enter height in centimeters and weight\n in kilograms to calculate your BMI\n");
		Text heightText = new Text();
		heightText.setText("Enter height in cm:");
		Text weightText = new Text();
		weightText.setText("Enter weight in kg:");
		
		TextField heightField = new TextField();
		heightField.setMaxWidth(60);
		TextField weightField = new TextField();
		weightField.setMaxWidth(60);
		
		Text outcome = new Text();
		outcome.setText(" ");

		
		heightField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				double userHeight = Double.parseDouble(heightField.getText());
				
				
				System.out.println(userHeight);
			}			
		});
		
		weightField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				double userWeight = Double.parseDouble(weightField.getText());
				
				System.out.println(userWeight);
			}			
		});
		
		
		//bmi =  userWeight / (userHeight * userHeight);
		
		
		
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25,25,25,25));
		pane.getChildren().add(explain);
		pane.getChildren().add(heightText);
		pane.getChildren().add(heightField);
		pane.getChildren().add(weightText);
		pane.getChildren().add(weightField);
		pane.getChildren().add(outcome);
		
		primaryStage.setScene(new Scene(pane, 400, 250));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
