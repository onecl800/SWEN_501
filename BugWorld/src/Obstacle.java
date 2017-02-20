import java.util.ArrayList;
import java.util.Scanner;

import com.sun.prism.paint.Color;

public class Obstacle {
	private char symbol;
	private int obstX;
	private int obstY;
	private Color color = Color.BLACK;
	private static ArrayList<Obstacle> obst = new ArrayList<Obstacle>();

	World w = new World();


	//getters and setters
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public int getObstX() {
		return obstX;
	}
	public void setObstX(int obstX) {
		this.obstX = obstX;
	}
	public int getObstY() {
		return obstY;
	}
	public void setObstY(int obstY) {
		this.obstY = obstY;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public static ArrayList<Obstacle> getObst() {
		return obst;
	}
	public void setObst(ArrayList<Obstacle> obst) {
		this.obst = obst;
	}
	
	
	//no arg constructor
	public Obstacle () {
		symbol = 'O';
		obstX = 5;
		obstY = 5;
		color = Color.BLACK;
	}
	
	//constructor with arguments
	public Obstacle(char s, int x, int y, Color c) {
		symbol = s;
		obstX = x;
		obstY = y;
		color = c;
	}
	
	
	//create obstacle
	public void createObstacle() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many obstacles do you want to create?");
		int numObstacles = scan.nextInt();

		
		for (int i = 0; i < numObstacles; i++) {
			obstX = (int) (Math.random() * w.getWidth());
			obstY = (int) (Math.random() * w.getHeight());
			Obstacle o = new Obstacle(symbol, obstX, obstY, color);
			obst.add(o);
			System.out.println("Obstcle symbol: " + symbol + ", obstacleX: " + obstX + ", obstacleY: " + obstY); 
		}
	}
	
	//generate obstacles
	public void generateObstacle() {
		for (int i = 0; i < 5; i++) {
			obstX = (int) (Math.random() * w.getWidth());
			obstY = (int) (Math.random() * w.getHeight());
			Obstacle o = new Obstacle(symbol, obstX, obstY, color);
			obst.add(o);
			System.out.println("Obstcle symbol: " + symbol + ", obstacleX: " + obstX + ", obstacleY: " + obstY); 
		}
	}
	
	
	//print plant info
		public String obstInfo() {
			return ("Obstacle: " + symbol + " ObstacleX: " + obstX + " ObstacleY: " + obstY);
		}
}
	

