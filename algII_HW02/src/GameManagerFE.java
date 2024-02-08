/*
 * Lea Frost
 */
import java.util.Scanner;
public class GameManagerFE {
	public static Scanner scan = new Scanner(System.in);
	public static GameManager gameManager = new GameManager();
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Video Game Database!");
		//quit tracks if the user wants to terminate
		boolean quit = false;
		while(!quit)
		{
			System.out.println("\nEnter 1 to load the video game database\n"
					+ "Enter 2 to search the database\n"
					+ "Enter 3 to print current results to the console\n"
					+ "Enter 4 to print current results to a file\n"
					+ "Enter 0 to quit");
			int choice = scan.nextInt();	
			scan.nextLine();
			//Use user input for switch
			switch(choice)
			{
			case 1:
				readGameFile();
				break;
			case 2:
				searchGameFile();
				break;
			case 3:
				printCurrentResults();
				break;
			case 4:
				writeGameFile();
				break;
			case 0:
				quit = true;
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Invalid input");
				
			}
		}

	}
	//case 1
	public static void readGameFile()
	{
		System.out.println("Enter the name of the file you want to read from:");
		String fileName = scan.nextLine();
		gameManager.readFile(fileName);
	}
	//case 2
	public static void searchGameFile()
	{
		System.out.println("Enter the name of the game or '*' for all");
		String gameName = scan.nextLine();
		System.out.println("Enter the name of the console or '*' for all");
		String consoleName = scan.nextLine();
		gameManager.search(gameName, consoleName);
	}
	//case3
	public static void printCurrentResults()
	{
		gameManager.printResults();
	}
	//case 4
	public static void writeGameFile()
	{
		System.out.println("Enter the name of the file you want to print to:");
		String file = scan.nextLine();
		System.out.println("Would you like to append? true/false");
		boolean bool = scan.nextBoolean();
		gameManager.writeFile(file, bool);
	}
	

}
