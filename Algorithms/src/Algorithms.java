import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Algorithms {
	private static int[] arrayData;
	
	public void createArray() {
		arrayData = new int[5000];
		
		try {
			Scanner scanner = new Scanner(new File("Data"));
			while (scanner.hasNext()) {

				for (int i = 0; i < arrayData.length; i++) {
					int data = scanner.nextInt();
					arrayData[i] = data;
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.printf("Error loading file: %s%n", e);
		}
		
		System.out.println(arrayData[0] + " " + arrayData[4999]);
	}
		
	
	public void reverseArray() {
		
	}
	
	public static void main(String[] args) {
		
	}

}
