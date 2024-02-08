//Lea Frost
import java.util.Scanner;
public class RobotManagerFE {
	public static RobotManager robotManager = new RobotManager();
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String action="";
		while(!action.equals("n"))
		{
			System.out.println("Welcome to the Robot Simulator!\nEnter the file for the Board:");
			String board = scan.nextLine();
			System.out.println("Enter the file for the Robot Commands:");
			String commands = scan.nextLine();
			robotManager.readBoardFile(board);
			robotManager.readCommandFile(commands);
			System.out.println("Simulation begins:");
			robotManager.move();
			System.out.println("Simulation complete.\nWould you like to restart? (y/n)");
			action = scan.nextLine();
		}
		System.out.println("Goodbye!");
		
		

	}

}
