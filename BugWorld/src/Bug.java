
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bug {
	private String species;
	private String name;
	private char symbol;
	private int positionX;
	private int positionY;
	private int uniqueId;
	private int energy = 10;
	private Color color = Color.RED;
	private static ArrayList<Bug> bugs = new ArrayList<Bug>();
	
	private Circle circle = new Circle();
	
	World w = new World();
	
	//no argument constructor
	public Bug() {
		species = "Hypnoidus";
		name = "Jeremiah";
		symbol = '%';
		positionX = 1;
		positionY = 1;
		uniqueId = 1;
		energy = 10;
		color = Color.RED;
	}
	
	//constructor with arguments for user create bugs method
	public Bug(String s, String n, char c, int x, int y, int uId, int e, Color r) {
		species = s; 
		name = n;
		symbol = c;
		positionX = x;
		positionY = y;
		uniqueId = uId;
		energy = e;
		color = r;
	}
	
	//constructor for generate bugs method
	public Bug(int x, int y, int uId) {
		species = "Hypnoidus";
		name = "Jeremiah";
		symbol = '%';
		positionX = x;
		positionY = y;
		uniqueId = uId;
		energy = 10;
		color = Color.RED;
	}
	
	
	
	//getters and setters
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int startX) {
		this.positionX = startX;
		circle.setTranslateX(this.positionX*(circle.getRadius()*2));
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int startY) {
		this.positionY = startY;
		circle.setTranslateY(this.positionY*(circle.getRadius()*2));
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public static ArrayList<Bug> getBugs() {
		return bugs;
	}
	public void setBugs(ArrayList<Bug> bugs) {
		this.bugs = bugs;
	}
	public Circle getCircle(int x, int y, Color c) {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	//create bugs for number user wishes
	public void createBug() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println();
		System.out.println("How many bugs would you like to create?");
		int numBugs = scanner.nextInt();
		int uniqueId = bugs.size() + 1;
		
		for (int i = 0; i < numBugs; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter bug name:");
			name = scan.nextLine();
			System.out.println("Enter bug species:");
			species = scan.nextLine();
			System.out.println("Enter a symbol for the bug:");
			symbol = scan.next().charAt(0);
			System.out.println("Enter position X and Y for the bug (separated by a space):");
			positionX = scan.nextInt();
			positionY = scan.nextInt();
			while (positionX < 0 || positionX > World.getWidth()-1 || positionY < 0 || positionY > World.getHeight() -1) {
				System.out.println("Position must be between 0 and " + (World.getWidth()-1) + " for width and 0 and " + (World.getHeight()-1)
					+ " for height, please choose position again:");
				positionX = scan.nextInt();
				positionY = scan.nextInt();
			}
			
			Bug b = new Bug(species, name, symbol, positionX, positionY, uniqueId, energy, color);
			bugs.add(b);
			System.out.println(b.toString(b));
			uniqueId++;
			
			scan.close();
			scanner.close();
		}
	}
	
	//create random bugs to generate random bug world
	public void generateBugs() {
		int uniqueId = bugs.size() + 1;
		
		for (int i = 0; i < 10; i ++) {
			positionX = (int)(Math.random() * w.getWidth());
			positionY = (int)(Math.random() * w.getHeight());
			Bug b = new Bug(positionX, positionY, uniqueId);
			uniqueId++;
			bugs.add(b);
			System.out.println(b.toString(b));
		}
	}
	
	
	//print short summary about bug
	public String toString(Bug b) {
		return ("Bug name: " + name + ". Bug species: " + species + ". Bug symbol: " + symbol);
	}
	
	
	
	//print full summary about bug
	public String toText() {
		return ("Name: " + name + ", species: " + species + ", symbol: " + symbol + ", X position: " + positionX + ", Y position: " + positionY + ", unique ID: " + uniqueId + ", energy: " + energy);
	}
	
	
	//call toText for each bug
	public void bugsAttributes() {
		
		if (bugs.size() == 0) {
			System.out.println("You have not yet created any bugs");
		} else {
			System.out.println("Info for each bug:");
			for (int i = 0; i < bugs.size(); i++) {
				System.out.println(bugs.get(i).toText());
			}
		}
	}

	
	
	//move bug in each direction
	public void moveNorth(Bug b) {
		if(positionY <= 0) {
			System.out.println("Bug can not move north otherwise it will go outside the world borders"); 
		} else {
			positionX = b.getPositionX();
			positionY = b.getPositionY() - 1;
			System.out.println("North, X: " + positionX + " Y: " + positionY);
		}
	}

	public void moveSouth(Bug b) {
		if(positionY > World.getHeight()) {
			System.out.println("Bug can not move south otherwise it will go outside the world borders"); 
		} else {
			positionX = b.getPositionX();
			positionY = b.getPositionY() + 1;
			System.out.println("South, X: " + positionX + " Y: " + positionY);
		}
	}

	public void moveEast(Bug b) {
		if(positionX > World.getWidth()) {
			System.out.println("Bug can not move east otherwise it will go outside the world borders"); 
		} else {
			positionX = b.getPositionX() + 1;
			positionY = b.getPositionY();
			System.out.println("East, X: " + positionX + " Y: " + positionY);
		}
	}

	public void moveWest(Bug b) {
		if(positionX <= 0) {
			System.out.println("Bug can not move west otherwise it will go outside the world borders"); 
		} else {
			positionX = b.getPositionX() - 1;
			positionY = b.getPositionY();
			System.out.println("West, X: " + positionX + " Y: " + positionY);
		}
	}
	
	//move bug at random once
	public void moveBugOnce(Bug b) {
		double nextDirection = Math.random();
		if (nextDirection > 0 && nextDirection < 0.25) {
			b.moveNorth(b);
		} else if (nextDirection >= 0.25 && nextDirection < 0.5) {
			b.moveSouth(b);
		} else if (nextDirection >= 0.5 && nextDirection < 0.75) {
			b.moveEast(b);
		} else {
			b.moveWest(b);
		}
	}

	
	//move bug randomly 100 times calling the four move direction methods
	public void moveBugRandomly(Bug b) {
		int numMoves = 100;

		System.out.println();
		System.out.println("Moving " + name + " from X: " + positionX + " Y: " + positionY);

		for (int i = 0; i < numMoves; i++) {
			double nextDirection = Math.random();
			if (nextDirection > 0 && nextDirection < 0.25) {
				b.moveNorth(b);
			} else if (nextDirection >= 0.25 && nextDirection < 0.5) {
				b.moveSouth(b);
			} else if (nextDirection >= 0.5 && nextDirection < 0.75) {
				b.moveEast(b);
			} else {
				b.moveWest(b);
			}
		}
	}

	//select bug to move at random and call moveBugRandomly method to move the bug
	public void selectBugForRandomMove() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the unique ID of the bug you wish to move at random:");
		
		int selectedBug = scan.nextInt();
		int bugSelected = 0;
		
		for (int i = 0; i < bugs.size(); i ++) {
			if (selectedBug == bugs.get(i).getUniqueId()) {
				bugSelected = bugs.get(i).getUniqueId();
				Bug b = bugs.get(i);
				//bugs.get(i) on the next two lines changed to just b.blah. check still works
				System.out.println("You have selected to move bug " + b.getName());
				b.moveBugRandomly(b);
				break;
			}
		}
		
		if (bugSelected == 0) {
			System.out.println("Bug not found");
		}
	} 
	

	
	//move bug in random directions in updateWorld methods
	public void moveBugInWorld(Bug b) {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Choose how many steps to move " + name + ":");
		int numMoves = scan.nextInt();
		
		System.out.println("Moving " + name + " from X: " + positionX + " Y: " + positionY);
		
		for (int i = 0; i < numMoves; i++) {
			double nextDirection = Math.random();
			if (nextDirection > 0 && nextDirection < 0.25) {
				b.moveNorth(b);
			} else if (nextDirection >= 0.25 && nextDirection < 0.5) {
				b.moveSouth(b);
			} else if (nextDirection >= 0.5 && nextDirection < 0.75) {
				b.moveEast(b);
			} else {
				b.moveWest(b);
			}
		}
		System.out.println("FinalX: " + positionX + " FinalY: " + positionY);
	}
	
	
	
	//select bug to move in updateWorldOneBug method
	public void selectBugForWorldMove() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the unique ID of the bug you wish to move within the bug world:");
		int selectedBug = scan.nextInt();
			
		int bugSelected = 0;
			
		for (int i = 0; i < bugs.size(); i ++) {
			if (selectedBug == bugs.get(i).getUniqueId()) {
				bugSelected = bugs.get(i).getUniqueId();
				Bug b = bugs.get(i);
				System.out.println("You have selected to move bug " + bugs.get(i).getName());
				bugs.get(i).moveBugInWorld(b);
			}
		}
			
		if (bugSelected == 0) {
			System.out.println("Bug not found");
		}
	}
}
