import java.util.ArrayList;
import java.util.Scanner;

public class World {
	private static int height = 15;
	private static int width = 50;
	
	private ArrayList<Inhabitants> allItems = new ArrayList<Inhabitants>();
	public ArrayList<Bug> bugList = new ArrayList<Bug>();
	
	Inhabitants inhabClass = new Inhabitants();
	
	
	//getters and setters
	public static int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public static int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<Bug> getBugList() {
		return bugList;
	}
	public void setBugList(ArrayList<Bug> bugList) {
		this.bugList = bugList;
	}
	
	
	
	//world constructors
	public World(int h, int w) {
		height = h;
		width = w;
	}
	
	public World() {
		this.height = height;
		this.width = width;
	}

	
	//prints info for user about bug world
	public void bugWorldInfo() {
		System.out.println("To create your bug world, start by creating some bugs. Each bug is then stored in a list.");
		System.out.println("Your bugs can go between x=0 to x= " + (width -1) + " and y=0 to y=" + (height-1));
		System.out.println("You can choose to return information about each bug you've created, or choose a bug to move.");
		System.out.println("Choose the number of plants and obstalces for your bug world, these will be generated at random positions.");
		System.out.println("Now draw your bug world - this will show all the bugs, plants and obstacles you have created.");
	}
	
	
	//generate random bugs, obstacles and plants for bugWorld (no user input)
	public void generateBugWorld() {
		Bug b = new Bug();
		b.generateBugs();
		Obstacle o = new Obstacle();
		o.generateObstacle();
		Plant p = new Plant();
		p.generatePlant();
	}
	
	
	//draw bug world with bugs in starting position
	public void drawWorld() {
		allItems = Inhabitants.getInhabs();
		inhabClass.addInhabs();
		
		//draw top
		System.out.print('+');
		for (int i = 0; i < width; i++) {
			System.out.print('-');
		}
		System.out.print('+');
		System.out.println();
		
		
		//draw middle - for each line, draw left line, then go through array list of bugs. if x and y from x and y for loops
		//correspond to that line, then draw bug, else fill in blanks. draw right line at end and enter for next line		
		for (int y = 0; y < height; y++) {  //draw each line for height
			System.out.print('|');
			for (int x = 0; x < width; x++) {
				int i;
				for (i = 0; i < allItems.size(); i++) { //go through bug array list of bugs at each x and y and draw if xs and ys match
					Inhabitants in = allItems.get(i);
					if (in.getPosX() == x && in.getPosY() == y) {
						System.out.print(in.getSymbol());
						break;
					}
				}

				if (i == allItems.size()) {
					System.out.print(' ');
				}
			}
			System.out.println('|');
		}
	
		
		//draw bottom
		System.out.print('+');
		for (int i = 0; i < width; i++) {
			System.out.print('-');
		}
		System.out.print('+');
	}
	
	
	//practice method - updateWorld for one bug only
	public void updateWorldOneBug() {
		bugList = Bug.getBugs();
		Bug b = new Bug();
		b.selectBugForWorldMove();
		
		drawWorld();
	}
	
	
	//method to move all bugs and update the world with bugs in their new positions
	public void updateWorldAllBugs() {
		bugList = Bug.getBugs();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < bugList.size(); j++) {
				Bug b = bugList.get(j);
				System.out.println("Moving bug " + b.getUniqueId());
				b.moveBugOnce(b);
			}
		}
		drawWorld();
	}

}
