
import java.awt.Menu;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	//main menu
	public static void menu() {
		World w = new World();
		Bug b = new Bug();
		Plant p = new Plant();
		Obstacle o = new Obstacle();
		BugWorldFX f = new BugWorldFX();
		String[] args = {};
		
		System.out.println();
		System.out.println("Press I to return information about building your bug world");
		System.out.println("Press C to create bugs");
		System.out.println("Press P to create plants");
		System.out.println("Press O to create obstacles");
		System.out.println("Press R to return bug attributes");
		System.out.println("Press M to move your chosen bug 100 times at random");
		System.out.println("Press D to draw your bug world");
		System.out.println("Press U to move bugs around your bug world");
		System.out.println("Press F to draw your bug world with special FX");
		System.out.println("Press G to generate a random bug world");
		System.out.println("Press E to exit if creepy crawlies freak you out!");
		
		Scanner scan = new Scanner(System.in);
		char option = scan.next().charAt(0);
		
		switch(option) {
		case 'I':
			w.bugWorldInfo();
			break;
		case 'C':
			b.createBug();
			break;
		case 'P':
			p.createPlant();
			break;
		case 'O':
			o.createObstacle();
			break;
		case 'R':
			b.bugsAttributes();
			break;
		case 'M':
			b.selectBugForRandomMove();
			break;
		case 'D':
			w.drawWorld();
			break;
		case 'U':
			w.updateWorldAllBugs();
			break;
		case 'F':
			f.main(args);
			break;
		case 'G':
			w.generateBugWorld();
			break;
		case 'E':
			System.out.println("Closing Bug World");
			System.exit(0);
			break;
		default:
			System.out.println("Your selection is not valid");
		}	
	}
	

	//main method
	public static void main(String[] args) {
			
		System.out.println("Welcome to the crazy world of bugs!");
		System.out.println();
		System.out.println("Please select from the following options:");
		
		while (true) {
			Main.menu();
		}
	}
}
