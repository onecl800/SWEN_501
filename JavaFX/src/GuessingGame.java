import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GuessingGame extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Guessing Game");
		
		Button button = new Button();
		button.setText("Click to start a new guessing game");
		
		Text text = new Text();
		text.setText(" ");
		
		TextField userInput = new TextField();
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				text.setText("New game! Enter a number between 1 and 100:");
				userInput.clear();
			}
			
		});

		
		userInput.setOnAction(new EventHandler<ActionEvent>() {
			int randomNum = (int) (Math.random()* 100) + 1;
			int guessCount = 0;
			
			@Override
			public void handle(ActionEvent arg0) {
				int userGuess = Integer.parseInt(userInput.getText());
				guessCount++;
				
				if (userGuess == randomNum) {
					text.setText("Your guess of " + randomNum + " is correct! You used " + guessCount + " guesses.");
					userInput.clear();
					//reset guess counter and random number for next game
					guessCount = 0;
					randomNum = (int) (Math.random()* 100) + 1;
				
				} else if (userGuess < randomNum) {
					text.setText("Your guess of " + userGuess + " is too low! Guess again:");
					userInput.clear();
				
				} else if (userGuess > randomNum) {
					text.setText("Your guess of " + userGuess + " is too high! Guess again:");
					userInput.clear();
				}
				
			}
			
		});
		
		
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25,25,25,25));
		pane.getChildren().add(button);
		pane.getChildren().add(text);
		pane.getChildren().add(userInput);
		
		primaryStage.setScene(new Scene(pane, 400, 250));
		primaryStage.show();

		
	}
	
	
	public static void main (String[] args) {
		launch(args);
	}

}
