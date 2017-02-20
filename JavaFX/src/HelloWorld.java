import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
	
public class HelloWorld extends Application {
	 
	    public void start(Stage primaryStage) throws Exception {
	        //Create a scene for the window with the text inside it
	        Scene scene = new Scene(new Group(new Text(25, 25, "Hello World!"))); 
	       
	        //Set title of the window
	        primaryStage.setTitle("Hello World!");
	         
	        //Add scene to the window (underneath the window bar)
	        primaryStage.setScene(scene);
	         
	        //Change size of window to fit text
	        //primaryStage.sizeToScene();
	        primaryStage.setWidth(200);
	        primaryStage.setHeight(200);
	         
	        //Show the window
	        primaryStage.show();
	    }
	 
	 
	    public static void main(String[] args) {
	        Application.launch(args);
	    }
}
