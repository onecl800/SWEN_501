import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloButton extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello");
		
		final Text text = new Text();
		text.setText("No-one has been greeted");
		
		Button button = new Button();
		button.setText("You have been greeted");
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			int n = 0;
			@Override
			public void handle(ActionEvent arg0) {
				n++;
				
				text.setText("Hello said " + n + " times(s)");
			}
			
		});
		
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(25,25,25,25));
		pane.getChildren().add(text);
		pane.getChildren().add(button);
		
		primaryStage.setScene(new Scene(pane,300,250));
		primaryStage.show();
	}

	
	
	public static void main(String[] args) {
		launch(args);

	}


}