import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GridPane extends Application {



	@Override
    public void start(final Stage primaryStage) {

//        Pane root = new Pane();
//
//        GridPane gridPane = new GridPane();
//        gridPane.setGridLinesVisible(true);
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//
//                Label label = new Label("Label " + i + "/" + j);
//                label.setMouseTransparent(true);
//                GridPane.setRowIndex(label, i);
//                GridPane.setColumnIndex(label, j);
//
//                gridPane.getChildren().add(label);
//            }
//        }
//
//        root.getChildren().add( gridPane);
//
//        Scene scene = new Scene(root, 400, 300, Color.WHITE);
//        primaryStage.setScene(scene);
//
//        primaryStage.show();
//
//        gridPane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
//
//                for( Node node: gridPane.getChildren()) {
//
//                    if( node instanceof Label) {
//                        if( node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
//                            System.out.println( "Node: " + node + " at " + GridPane.getRowIndex( node) + "/" + GridPane.getColumnIndex( node));
//                        }
//                    }
//                }
//            }
//        });
//
//
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
