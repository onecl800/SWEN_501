import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatedCircles extends Application {
	ArrayList<Circle> circles = new ArrayList<Circle>();
	int width = 800, height = 600;
	float x = 100, y = 100, dx = -1.5f, dy = -1.5f;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Circle circle1 = new Circle(x, y, 30);
		circle1.setFill(Color.BLUE);
		circles.add(circle1);
		Circle circle2 = new Circle(x+50, y+200, 30);
		circle2.setFill(Color.RED);
		circles.add(circle2);
		Circle circle3 = new Circle(x+100, y+50, 30);
		circle3.setFill(Color.GREEN);
		circles.add(circle3);
		
		Group root = new Group(circle1, circle2, circle3);
		Scene scene = new Scene(root, width, height);
			
		KeyFrame frame = new KeyFrame(Duration.millis(15), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {
				for (int i = 0; i < circles.size(); i++) {
					Circle circ = circles.get(i);
					if (circ.getCenterX() + circ.getTranslateX() < circ.getRadius() 
							|| circ.getCenterX() + circ.getTranslateX() + circ.getRadius() > scene.getWidth()){
							dx = -dx;
							System.out.println("CenX " + circ.getCenterX() + " TransX " + circ.getTranslateX() + " " + circ.getRadius());
					}	
					if (circ.getCenterY() + circ.getTranslateY() - circ.getRadius() < 0 
							|| circ.getCenterY() + circ.getTranslateY() +   circ.getRadius() > scene.getHeight()) {
							dy = -dy;
							System.out.println("CenY " + circ.getCenterY() + " TransY " + circ.getTranslateY() + " " + circ.getRadius());
					}
					
					circ.setTranslateX(circ.getTranslateX() + dx);
					circ.setTranslateY(circ.getTranslateY() + dy);
				}
			}
		});
		
		TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE).keyFrames(frame).build().play();
		
		primaryStage.setTitle("Hello animation");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
