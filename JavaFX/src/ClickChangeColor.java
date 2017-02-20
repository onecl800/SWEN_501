import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ClickChangeColor extends Application {

	 Rectangle rect = new Rectangle(100,100);
	 Rectangle rect2 = new Rectangle(50,50);
	 
	 final ArrayList<Rectangle> cells = new ArrayList<Rectangle>();

	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		rect.setFill(Color.BLUE);
		rect2.setFill(Color.RED);
		cells.add(rect);
		cells.add(rect2);

        rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
        	
            @Override
            public void handle(MouseEvent t) {
                rect.setFill(Color.RED);
            }
        });
        
        rect2.setOnMouseClicked(new EventHandler<MouseEvent>() {
        	
            @Override
            public void handle(MouseEvent t) {
                rect2.setFill(Color.BLUE);
            }
        });


        BorderPane root = new BorderPane();
        root.getChildren().add(rect);
        root.getChildren().add(rect2);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


	public static void main(String[] args) {
		launch(args);

	}
}
