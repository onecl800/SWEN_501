import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BugWorldFX extends Application {
	int width = World.getWidth()*25, height = World.getHeight()*50;
	float x = 0, y = 0, dx = -1.5f, dy = -1.5f;
	ArrayList<Inhabitants> inhabList = new ArrayList<Inhabitants>();
	ArrayList<Circle> circles = new ArrayList<Circle>();

	World w = new World();
	Bug b = new Bug();

	@Override
	public void start(Stage primaryStage) throws Exception {
		//inhabList = Inhabitants.getInhabs();
		
		Group root = new Group();
		Scene scene = new Scene(root, width, height);	
		
		b.generateBugs();
		Bug.getBugs();
		
		for (int i = 0; i < Bug.getBugs().size(); i ++) {
			Bug b = Bug.getBugs().get(i);
			x = b.getPositionX()* 25;
			y = b.getPositionY()* 50;
			
			Circle c = b.getCircle(b.getPositionX()* 25, b.getPositionY()* 25, Color.RED);
			c.setFill(Color.RED);
			circles.add(c);
			root.getChildren().add(c);
		}

		KeyFrame frame = new KeyFrame(Duration.millis(15), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {
				for (int i = 0; i < circles.size(); i++) {
					w.updateWorldAllBugs();
					Circle c = circles.get(i);
		
									
					if (c.getCenterX() + c.getTranslateX() < c.getRadius() 
							|| c.getCenterX() + c.getTranslateX() + c.getRadius() > scene.getWidth()){
							dx = -dx;
					}	
					
					if (c.getCenterY() + c.getTranslateY() - c.getRadius() < 0 
							|| c.getCenterY() + c.getTranslateY() +   c.getRadius() > scene.getHeight()) {
							dy = -dy;
					}
					
					c.setTranslateX(c.getTranslateX() + dx);
					c.setTranslateY(c.getTranslateY() + dy);
				}
			}
		});
		
		TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE).keyFrames(frame).build().play();
		
		
		primaryStage.setTitle("Bug World FX");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
