package animate;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

//terminology used in comments: 'grid world' refers to the cells position on the visible grid pane (all positive integers)
// whereas 'infinite world' refers to cell's location (can be positive or negative integers)

@SuppressWarnings("deprecation")
public class JavaFX extends Application {
	int width = 500;
	int length = 400;

	int topBorder = 0, bottomBorder = 14, leftBorder = 0, rightBorder = 14; // these
																			// variables
	// keep track of the
	// current border
	// for the infinite
	// world

	Map<Pair, Cell> map = new HashMap<Pair, Cell>(); // mapping from
														// co-ordinates in
														// infinite world to
														// Cell
	GridPane grid;
	BorderPane border;
	KeyFrame frame;
	Timeline t;

	@Override
	public void start(Stage primaryStage) throws Exception {
		grid = addGridPane();
		border = new BorderPane();

		Button clr = new Button("Clear");
		Button play = new Button("Play");

		// these next two buttons seem to get moved down out of the initial size
		// of the scene when the grid grows and clear doesnt put them in their
		// right spot
		Button halfAlive = new Button("New Random Cells (Many)");
		Button fewAlive = new Button("New Random Cells (Few)");

		// clears the grid then makes roughly half the cells randomly alive
		halfAlive.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// may need to call the clearButton() method here
				addHalfAliveCells();

				play.setText("Play");
			}

		});

		// clears the grid then makes roughly 15% of the cells randomly alive
		fewAlive.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// may need to call the clearButton() method here
				addFewAliveCells();

				play.setText("Play");
			}

		});

		// the clear button
		clr.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				clearButton();
				play.setText("Play");
			}
		});

		// the play & pause button, has an if else statement for if the game has
		// not started yet, if it is running or if it is paused
		play.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (t.getStatus() == Status.RUNNING) {
					play.setText("Play");
					t.pause();
				}

				else if (t.getStatus() == Status.PAUSED) {
					play.setText("Pause");
					t.play();
				}

				else {
					play.setText("Pause");
					t.play();
				}
			}
		});

		HBox buttons = new HBox(clr, play);
		HBox newCells = new HBox(halfAlive, fewAlive);

		/**
		 * In order for ScrollPane to work everything that we want in the scene
		 * has to be added to a group then a scrollpane has to be made which
		 * contains everything in that group. Then in Scene the scrollpane
		 * (which contains everything) is added.
		 * 
		 */

		Group root = new Group();
		root.getChildren().add(border);
		root.getChildren().add(grid); // this group contains everything we want
										// in the scene

		ScrollPane scrollPane = new ScrollPane(root); // this scrollpane is what
														// is actually added to
														// the scene,
		// and contains everything that is added to the Group root

		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

		buttons.setAlignment(Pos.CENTER);
		border.setTop(buttons);
		border.setBottom(newCells);

		border.setCenter(grid);
		grid.setAlignment(Pos.CENTER);

		Scene scene = new Scene(scrollPane, width, length);

		frame = new KeyFrame(Duration.millis(600), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				checkBorder();
				decide();
				lifeCycle();
			}
		});
		t = TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE).keyFrames(frame).build();

		primaryStage.setScene(scene);

		// zoom in on press of + key and zoom out on press of - key
		primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.EQUALS)) {

					Scale scaleTransform = new Scale(2, 2);
					grid.getTransforms().add(scaleTransform);
				} else if (event.getCode().equals(KeyCode.MINUS)) {

					Scale scaleTransform = new Scale(0.5, 0.5);
					grid.getTransforms().add(scaleTransform);
				}

			}
		});
		// end of zoom in method

		primaryStage.show();
	}

	public void clearButton() {
		topBorder = 0;
		leftBorder = 0;
		rightBorder = 14;
		bottomBorder = 14;
		t.stop();
		grid = addGridPane();
		border.setCenter(grid);
		grid.setAlignment(Pos.CENTER);

	}

	public void decide() {
		for (int x = leftBorder; x <= rightBorder; x++) { // decide
															// whether a
															// cell
															// should be
															// alive or
															// dead
			for (int y = topBorder; y <= bottomBorder; y++) { // in next
																// round
				Cell c = map.get(new Pair(x, y));
				if (c.checkNhd(c, c.getNeighbourhood()) == true) {
					c.setFutureState((byte) 1);
				} else {
					c.setFutureState((byte) 0);
				}

			}
		}
	}

	public void lifeCycle() {
		for (int x = leftBorder; x <= rightBorder; x++) {
			for (int y = topBorder; y <= bottomBorder; y++) {
				Pair p = new Pair(x, y);
				Cell c = map.get(p);
				if (c.getFutureState() == (byte) 1) {
					c.setState((byte) 1);
					c.setFill(Color.BLACK);
				} else {
					c.setState((byte) 0);
					c.setFill(Color.WHITE);
				}
			}
		}
	}

	public GridPane addGridPane() {
		grid = new GridPane();
		// grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(10, 10, 10, 10)); // note x represents column
														// // and y represents
														// row

		int i = 0;
		int j;
		for (int x = leftBorder; x <= rightBorder; x++) {
			j = 0;
			for (int y = topBorder; y <= bottomBorder; y++) {
				Neighbourhood nb = new Neighbourhood(null, null, null, null, null, null, null, null);
				Pair p = new Pair(x, y);
				Cell c = new Cell(20, 20, (byte) 0, (byte) 0, nb, x, y);
				c.setFill(Color.WHITE);
				c.setStroke(Color.BLACK);
				map.put(p, c);
				c.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if (c.getState() == (byte) 0) {
							c.setFill(Color.BLACK);
							c.setState((byte) 1);
							return;
						}
						if (c.getState() == (byte) 1) {
							c.setFill(Color.WHITE);
							c.setState((byte) 0);
							return;
						}
					}
				});
				grid.add(c, i, j);
				j++;
			}
			i++;
		}
		initialNhd();
		return grid;
	}// end of addGridPane method

	// the following two methods are for making roughly half the cells in the
	// grid alive

	public void addHalfAliveCells() {

		grid = addHalfAliveCellsGrid();
		border.setCenter(grid);
		grid.setAlignment(Pos.CENTER);
		t.stop();
	}

	public GridPane addHalfAliveCellsGrid() {

		grid = new GridPane();
		// grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(10, 10, 10, 10));
		for (int x = leftBorder; x <= rightBorder; x++) {
			for (int y = topBorder; y <= bottomBorder; y++) {
				double n = Math.random();
				Neighbourhood nb = new Neighbourhood(null, null, null, null, null, null, null, null);
				Pair p = new Pair(x, y);
				Cell c = new Cell(20, 20, (byte) 0, (byte) 0, nb, x, y);

				if (n < 0.5) {
					c.setState((byte) 1);
					c.setFill(Color.BLACK);
				}

				else {
					c.setFill(Color.WHITE);
					c.setState((byte) 0);
				}

				c.setStroke(Color.BLACK);
				map.put(p, c);

				c.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						System.out.println(c.getState());
						if (c.getState() == 0) {
							c.setFill(Color.BLACK);
							c.setState((byte) 1);
							return;
						}
						if (c.getState() == (byte) 1) {
							c.setFill(Color.WHITE);
							c.setState((byte) 0);
							return;
						}

					}

				});

				grid.add(c, x, y);
			}
		}
		return grid;
	} // end of halfalivecells methods

	// the following two methods are for adding a few alive cells to the grid

	public void addFewAliveCells() {

		grid = addFewAliveCellsGrid();
		border.setCenter(grid);
		grid.setAlignment(Pos.CENTER);
		t.stop();
	}

	public GridPane addFewAliveCellsGrid() {

		grid = new GridPane();
		// grid.setGridLinesVisible(true);
		grid.setPadding(new Insets(10, 10, 10, 10));
		for (int x = leftBorder; x <= rightBorder; x++) {
			for (int y = topBorder; y <= bottomBorder; y++) {
				double n = Math.random();
				Neighbourhood nb = new Neighbourhood(null, null, null, null, null, null, null, null);
				Pair p = new Pair(x, y);
				Cell c = new Cell(20, 20, (byte) 0, (byte) 0, nb, x, y);

				if (n < 0.15) {
					c.setState((byte) 1);
					c.setFill(Color.BLACK);
				}

				else {
					c.setFill(Color.WHITE);
					c.setState((byte) 0);
				}

				c.setStroke(Color.BLACK);
				map.put(p, c);

				c.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						System.out.println(c.getState());
						if (c.getState() == 0) {
							c.setFill(Color.BLACK);
							c.setState((byte) 1);
							return;
						}
						if (c.getState() == (byte) 1) {
							c.setFill(Color.WHITE);
							c.setState((byte) 0);
							return;
						}

					}

				});

				grid.add(c, x, y);
			}
		}
		return grid;
	}
	// end of addFewAliveCells method

	// this method sets up the initial neighbourhood of each cell
	public void initialNhd() {
		Neighbourhood nb = new Neighbourhood(null, null, null, null, null, null, null, null);
		Cell phantom = new Cell(20, 20, (byte) 0, (byte) 0, nb, 0, 0);
		for (int i = topBorder; i <= bottomBorder; i++) {
			for (int j = leftBorder; j <= rightBorder; j++) {
				Cell c = map.get(new Pair(j, i));// pick the cell who's
													// neighbours we are
				// about to set

				int a = j; // i is used for row, j for column
				int b = i;

				Pair temp;

				// cell is top left corner
				if (i == topBorder && j == leftBorder) {
					c.getNeighbourhood().setUpperLeft(phantom);
					c.getNeighbourhood().setUpperMiddle(phantom);
					c.getNeighbourhood().setUpperRight(phantom);
					c.getNeighbourhood().setMiddleLeft(phantom);
					c.getNeighbourhood().setMiddleRight(map.get(new Pair(a + 1, b)));
					c.getNeighbourhood().setBottomLeft(phantom);
					c.getNeighbourhood().setBottomMiddle(map.get(new Pair(a, b + 1)));
					c.getNeighbourhood().setBottomRight(map.get(new Pair(a + 1, b + 1)));
				}

				// cell is top right corner
				if (i == topBorder && j == rightBorder) {
					c.getNeighbourhood().setUpperLeft(phantom);
					c.getNeighbourhood().setUpperMiddle(phantom);
					c.getNeighbourhood().setUpperRight(phantom);
					c.getNeighbourhood().setMiddleLeft(map.get(new Pair(a - 1, b)));
					c.getNeighbourhood().setMiddleRight(phantom);
					c.getNeighbourhood().setBottomLeft(map.get(new Pair(a - 1, b + 1)));
					c.getNeighbourhood().setBottomMiddle(map.get(new Pair(a, b + 1)));
					c.getNeighbourhood().setBottomRight(phantom);
				}

				// cell is bottom left corner
				if (i == bottomBorder && j == leftBorder) {
					c.getNeighbourhood().setUpperLeft(phantom);
					c.getNeighbourhood().setUpperMiddle(map.get(new Pair(a, b - 1)));
					c.getNeighbourhood().setUpperRight(map.get(new Pair(a + 1, b - 1)));
					c.getNeighbourhood().setMiddleLeft(phantom);
					c.getNeighbourhood().setMiddleRight(map.get(new Pair(a + 1, b)));
					c.getNeighbourhood().setBottomLeft(phantom);
					c.getNeighbourhood().setBottomMiddle(phantom);
					c.getNeighbourhood().setBottomRight(phantom);
				}

				// cell is bottom right corner
				if (i == topBorder && j == leftBorder) {
					c.getNeighbourhood().setUpperLeft(map.get(new Pair(a - 1, b + 1)));
					c.getNeighbourhood().setUpperMiddle(map.get(new Pair(a, b - 1)));
					c.getNeighbourhood().setUpperRight(phantom);
					c.getNeighbourhood().setMiddleLeft(map.get(new Pair(a - 1, b)));
					c.getNeighbourhood().setMiddleRight(phantom);
					c.getNeighbourhood().setBottomLeft(phantom);
					c.getNeighbourhood().setBottomMiddle(phantom);
					c.getNeighbourhood().setBottomRight(phantom);
				}

				// cell is a non-corner edge
				if (i == topBorder && j != leftBorder && j != rightBorder) {
					temp = new Pair(a - 1, b - 1);
					c.getNeighbourhood().setUpperLeft(phantom);
					c.getNeighbourhood().setUpperMiddle(phantom);
					temp = new Pair(a + 1, b - 1);
					c.getNeighbourhood().setUpperRight(phantom);
					temp = new Pair(a - 1, b);
					c.getNeighbourhood().setMiddleLeft(map.get(temp));
					temp = new Pair(a + 1, b);
					c.getNeighbourhood().setMiddleRight(map.get(temp));
					temp = new Pair(a - 1, b + 1);
					c.getNeighbourhood().setBottomLeft(map.get(temp));
					temp = new Pair(a, b + 1);
					c.getNeighbourhood().setBottomMiddle(map.get(temp));
					temp = new Pair(a + 1, b + 1);
					c.getNeighbourhood().setBottomRight(map.get(temp));
				}
				if (i == bottomBorder && j != leftBorder && j != rightBorder) {
					temp = new Pair(a - 1, b - 1);
					c.getNeighbourhood().setUpperLeft(map.get(temp));
					temp = new Pair(a, b - 1);
					c.getNeighbourhood().setUpperMiddle(map.get(temp));
					temp = new Pair(a + 1, b - 1);
					c.getNeighbourhood().setUpperRight(map.get(temp));
					temp = new Pair(a - 1, b);
					c.getNeighbourhood().setMiddleLeft(map.get(temp));
					temp = new Pair(a + 1, b);
					c.getNeighbourhood().setMiddleRight(map.get(temp));
					temp = new Pair(a - 1, b + 1);
					c.getNeighbourhood().setBottomLeft(phantom);
					c.getNeighbourhood().setBottomMiddle(phantom);
					temp = new Pair(a + 1, b + 1);
					c.getNeighbourhood().setBottomRight(phantom);
				}
				if (j == leftBorder && i != topBorder && i != bottomBorder) {
					temp = new Pair(a - 1, b - 1);
					c.getNeighbourhood().setUpperLeft(phantom);
					temp = new Pair(a, b - 1);
					c.getNeighbourhood().setUpperMiddle(map.get(temp));
					temp = new Pair(a + 1, b - 1);
					c.getNeighbourhood().setUpperRight(map.get(temp));
					c.getNeighbourhood().setMiddleLeft(phantom);
					temp = new Pair(a + 1, b);
					c.getNeighbourhood().setMiddleRight(map.get(temp));
					temp = new Pair(a - 1, b + 1);
					c.getNeighbourhood().setBottomLeft(phantom);
					temp = new Pair(a, b + 1);
					c.getNeighbourhood().setBottomMiddle(map.get(temp));
					temp = new Pair(a + 1, b + 1);
					c.getNeighbourhood().setBottomRight(map.get(temp));
				}
				if (j == rightBorder && i != topBorder && i != bottomBorder) {
					temp = new Pair(a - 1, b - 1);
					c.getNeighbourhood().setUpperLeft(map.get(temp));
					temp = new Pair(a, b - 1);
					c.getNeighbourhood().setUpperMiddle(map.get(temp));
					temp = new Pair(a + 1, b - 1);
					c.getNeighbourhood().setUpperRight(phantom);
					temp = new Pair(a - 1, b);
					c.getNeighbourhood().setMiddleLeft(map.get(temp));
					c.getNeighbourhood().setMiddleRight(phantom);
					temp = new Pair(a - 1, b + 1);
					c.getNeighbourhood().setBottomLeft(map.get(temp));
					temp = new Pair(a, b + 1);
					c.getNeighbourhood().setBottomMiddle(map.get(temp));
					temp = new Pair(a + 1, b + 1);
					c.getNeighbourhood().setBottomRight(phantom);
				}

				// cell is non-edge
				if (i != topBorder && j != leftBorder && i != bottomBorder && j != bottomBorder) {
					temp = new Pair(a - 1, b - 1);
					c.getNeighbourhood().setUpperLeft(map.get(temp));
					temp = new Pair(a, b - 1);
					c.getNeighbourhood().setUpperMiddle(map.get(temp));
					temp = new Pair(a + 1, b - 1);
					c.getNeighbourhood().setUpperRight(map.get(temp));
					temp = new Pair(a - 1, b);
					c.getNeighbourhood().setMiddleLeft(map.get(temp));
					temp = new Pair(a + 1, b);
					c.getNeighbourhood().setMiddleRight(map.get(temp));
					temp = new Pair(a - 1, b + 1);
					c.getNeighbourhood().setBottomLeft(map.get(temp));
					temp = new Pair(a, b + 1);
					c.getNeighbourhood().setBottomMiddle(map.get(temp));
					temp = new Pair(a + 1, b + 1);
					c.getNeighbourhood().setBottomRight(map.get(temp));
				}
			}
		}
	}// end of initialNhd method

	// this method decides if a new layer of dead cells need to be added or not
	public void checkBorder() {
		// check top border
		for (int k = leftBorder + 1; k < rightBorder; k++) {
			if ((int) map.get(new Pair(k, topBorder)).getState() > 0) {
				System.out.println("add a layer top");
				addLayerTop();
				addLayerLeft();
				addLayerRight();
				addLayerBottom();
				k = rightBorder;
			}
		}
		// check right border
		for (int k = topBorder + 1; k < bottomBorder; k++) {
			if ((int) map.get(new Pair(rightBorder, k)).getState() > 0) {
				System.out.println("add a layer right");
				addLayerTop();
				addLayerLeft();
				addLayerRight();
				addLayerBottom();
				k = bottomBorder;
			}
		}
		// check bottom border
		for (int k = leftBorder + 1; k < rightBorder; k++) {
			if ((int) map.get(new Pair(k, bottomBorder)).getState() > 0) {
				System.out.println("add a layer bottom");
				addLayerTop();
				addLayerLeft();
				addLayerRight();
				addLayerBottom();
				k = rightBorder;
			}
		}
		// check left border
		for (int k = topBorder + 1; k < bottomBorder; k++) {
			if ((int) map.get(new Pair(leftBorder, k)).getState() > 0) {
				System.out.println("add a layer left");
				addLayerTop();
				addLayerLeft();
				addLayerRight();
				addLayerBottom();
				k = bottomBorder;
			}
		}
	}// end of checkBorder method

	// add a layer of dead Cells to the top
	public void addLayerTop() {
		System.out.println("add a layer2");
		Neighbourhood nb = new Neighbourhood(null, null, null, null, null, null, null, null);
		for (int k = leftBorder; k <= rightBorder; k++) {
			Pair p = new Pair(k, topBorder - 1);
			Cell c = new Cell(20, 20, (byte) 0, (byte) 0, nb, k, topBorder - 1);
			c.setFill(Color.WHITE);
			c.setStroke(Color.BLACK);
			map.put(p, c);
		}
		topBorder--;
		refreshGrid();
	}

	// add a layer of dead Cells to the left
	public void addLayerLeft() {
		Neighbourhood nb = new Neighbourhood(null, null, null, null, null, null, null, null);
		for (int k = topBorder; k <= bottomBorder; k++) {
			Pair p = new Pair(leftBorder - 1, k);
			Cell c = new Cell(20, 20, (byte) 0, (byte) 0, nb, leftBorder - 1, k);
			c.setFill(Color.WHITE);
			c.setStroke(Color.BLACK);
			map.put(p, c);
		}
		leftBorder--;
		refreshGrid();
	}

	// add a layer of dead Cells to the right
	public void addLayerRight() {
		Neighbourhood nb = new Neighbourhood(null, null, null, null, null, null, null, null);
		for (int k = topBorder; k <= bottomBorder; k++) {
			Pair p = new Pair(rightBorder + 1, k);
			Cell c = new Cell(20, 20, (byte) 0, (byte) 0, nb, rightBorder + 1, k);
			c.setFill(Color.WHITE);
			c.setStroke(Color.BLACK);
			map.put(p, c);
		}
		rightBorder++;
		refreshGrid();
	}

	// add a layer of dead Cells to the top
	public void addLayerBottom() {
		Neighbourhood nb = new Neighbourhood(null, null, null, null, null, null, null, null);
		for (int k = leftBorder; k <= rightBorder; k++) {
			Pair p = new Pair(k, bottomBorder + 1);
			Cell c = new Cell(20, 20, (byte) 0, (byte) 0, nb, k, bottomBorder + 1);
			c.setFill(Color.WHITE);
			c.setStroke(Color.BLACK);
			map.put(p, c);
		}
		bottomBorder++;
		refreshGrid();
	}

	public void refreshGrid() {
		System.out.println(map.size());
		initialNhd();
		GridPane newGrid = new GridPane();
		int i;
		int j = 0;
		for (int x = leftBorder; x <= rightBorder; x++) {
			i = 0;
			for (int y = topBorder; y <= bottomBorder; y++) {
				Cell c = map.get(new Pair(x, y));
				newGrid.add(c, j, i);
				i++;
			}
			j++;
		}
		grid = newGrid;
		border.setCenter(grid);
		grid.setAlignment(Pos.CENTER);
	}

	public static void main(String[] args) {
		launch();
	}
}
