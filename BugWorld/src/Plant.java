import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.paint.Color;

public class Plant {
	private int plantSize;
	private int plantX;
	private int plantY;
	private Color color = Color.GREEN;
	private static ArrayList<Plant> plants = new ArrayList<Plant>();
	
	World w = new World();
	
	//getters and setters
	public int getPlantSize() {
		return plantSize;
	}
	public void setPlantSize(int plantSize) {
		this.plantSize = plantSize;
	}
	public int getPlantX() {
		return plantX;
	}
	public void setPlantX(int plantX) {
		this.plantX = plantX;
	}
	public int getPlantY() {
		return plantY;
	}
	public void setPlantY(int plantY) {
		this.plantY = plantY;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public static ArrayList<Plant> getPlants() {
		return plants;
	}
	public void setPlants(ArrayList<Plant> plants) {
		this.plants = plants;
	}

	
	//constructor
	public Plant(int s, int x, int y, Color c) {
		plantSize = s;
		plantX = x;
		plantY = y;
		color = c;
	}

	//no argument constructor
	public Plant() {
		plantSize = 5;
		plantX = 2;
		plantY = 2;
		color = color.GREEN;
	}

	
	//create plants for world, generated randomly
	public void createPlant() {
		World w = new World();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many plants do you want to create?");
		int numPlants = scan.nextInt();
		
		for (int i = 0; i < numPlants; i++) {
			plantSize = (int) (1 + Math.random() * 9);
			plantX = (int) (Math.random() * w.getWidth());
			plantY = (int) (Math.random() * w.getHeight());
			System.out.println("Plant size: " + plantSize + ", plantX: " + plantX + ", plantY: " + plantY);
			Plant p = new Plant(plantSize, plantX, plantY, color);
			plants.add(p);
		}
	}
	
	//generate plants for world
		public void generatePlant() {
			for (int i = 0; i < 5; i++) {
				plantSize = (int) (1 + Math.random() * 9);
				plantX = (int) (Math.random() * w.getWidth());
				plantY = (int) (Math.random() * w.getHeight());
				System.out.println("Plant size: " + plantSize + ", plantX: " + plantX + ", plantY: " + plantY);
				Plant p = new Plant(plantSize, plantX, plantY, color);
				plants.add(p);
			}
		}
	
	
	//print plant info
	public String plantInfo() {
		return ("Plant size: " + plantSize + " PlantX: " + plantX + " PlantY: " + plantY);
	}
}
