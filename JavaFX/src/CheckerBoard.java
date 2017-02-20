import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckerBoard extends Application {

	int rowNum = 10;
	int colNum = 10;
	int gridHeight = 10;
	int gridWidth = 10;

	public void start(Stage primaryStage) {
	    GridPane grid = new GridPane();

	    //grid.getColumnConstraints().add(new ColumnConstraints(gridWidth));
	    //grid.getRowConstraints().add(new RowConstraints(gridHeight));

	    Random rand = new Random();
	    Color[] colors = {Color.BLACK, /*Color.BLUE, Color.GREEN,*/ Color.RED};

	    for (int row = 0; row < rowNum; row++) {
	        for (int col = 0; col < colNum; col++) {
	            int n = rand.nextInt(2);
	            Rectangle rec = new Rectangle();
	            rec.setWidth(20);
	            rec.setHeight(20);
	            rec.setFill(colors[n]);
	            GridPane.setRowIndex(rec, row);
	            GridPane.setColumnIndex(rec, col);
	            grid.getChildren().addAll(rec);
	        }
	    }

	    Scene scene = new Scene(grid, 350, 250);

	    primaryStage.setTitle("Grid");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
