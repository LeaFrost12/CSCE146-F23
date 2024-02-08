//Lea Frost
import java.util.Scanner;
public class SheepFE {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		SheepScheduler sheepScheduler = new SheepScheduler();
		System.out.println("Welcome to the sheep scheduler!\nGive me a file of your sheep and I will make a good schedule:");
		String file = scan.nextLine();
		System.out.println("\nThis is the most optimal schedule:");
		//read file and create array of sheep
		sheepScheduler.readFile(file);
		//simulate and print schedule
		sheepScheduler.scheduleSheep();
	}

}
