import java.util.ArrayList;

public class Inhabitants {
	private char symbol;
	private int posX;
	private int posY;
	private static ArrayList<Inhabitants> inhabs = new ArrayList<Inhabitants>();
	
	ArrayList<Bug> bugList =  new ArrayList<Bug>();
	ArrayList<Plant> plantList =  new ArrayList<Plant>();
	ArrayList<Obstacle> obstList =  new ArrayList<Obstacle>();
	
	
	//constructors
	public Inhabitants (char s, int x, int y) {
		symbol = s;
		posX = x;
		posY = y;
	}
	
	public Inhabitants() {
		symbol = 0;
		posX = 0;
		posY = 0;
	}

	//getters and setters
	public char getSymbol() {
		return symbol; 
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol; 
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX; 
	}
	public int getPosY() {
		return posY; 
	}
	public void setPosY(int posY) {
		this.posY = posY; 
	}
	public static ArrayList<Inhabitants> getInhabs() {
		return inhabs; 
	}
	public void setInhabs(ArrayList<Inhabitants> inhabs) {
		this.inhabs = inhabs; 
	}

	//add bugs, plants and obstacles to inhabitants arraylist
	public void addInhabs() {
		inhabs.clear();
		
		bugList = Bug.getBugs();
		plantList = Plant.getPlants();
		obstList = Obstacle.getObst();
		
		for (int i = 0; i < bugList.size(); i++) {
			Bug b = bugList.get(i);
			symbol = b.getSymbol();
			posX = b.getPositionX();
			posY = b.getPositionY();
			Inhabitants in = new Inhabitants(symbol, posX, posY);
			inhabs.add(in);
		}
		
		for (int i = 0; i < plantList.size(); i++) {
			Plant p = plantList.get(i);
			symbol = (char)Integer.toString(p.getPlantSize()).toString().charAt(0);
			posX = p.getPlantX();
			posY = p.getPlantY();
			Inhabitants in = new Inhabitants(symbol, posX, posY);
			inhabs.add(in);
		}
	
		for (int i = 0; i < obstList.size(); i++) {
			Obstacle o = obstList.get(i);
			symbol = o.getSymbol();
			posX = o.getObstX();
			posY = o.getObstY();
			Inhabitants in = new Inhabitants(symbol, posX, posY);
			inhabs.add(in);
		}
	}

}
