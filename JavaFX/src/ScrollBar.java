import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScrollBar extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {


	    HBox hbox = new HBox();
	    
	    Button b = new Button("add");
	    b.setOnAction(ev -> hbox.getChildren().add(new Label("Test")));

	    ScrollPane scrollPane = new ScrollPane(hbox);
	    scrollPane.setFitToHeight(true);

	    BorderPane root = new BorderPane(scrollPane);
	    root.setPadding(new Insets(15));
	    root.setTop(b);

	    Scene scene = new Scene(root, 400, 400);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
