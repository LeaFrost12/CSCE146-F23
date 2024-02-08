/*
 * Lea Frost
 */
import java.util.Scanner;

public class TaskManagerFE {
	public static Scanner scan = new Scanner(System.in);
	public static TaskManager taskManager = new TaskManager();
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Task Organizer!");
		//quit tracks if the user wants to terminate
		boolean quit = false;
		while(!quit)
		{
			System.out.println("\nEnter 1 to add a Task\n"
					+ "Enter 2 to remove a Task\n"
					+ "Enter 3 to print tasks to the console\n"
					+ "Enter 4 to read from a task file\n"
					+ "Enter 5 to write to a task file\n"
					+ "Enter 0 to quit");
			int choice = scan.nextInt();	
			scan.nextLine();
			//Use user input for switch
			switch(choice)
			{
			case 1:
				addTask();
				break;
			case 2:
				removeTask();
				break;
			case 3:
				printTasks();
				break;
			case 4:
				readTaskFile();
				break;
			case 5:
				writeFile();
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
	public static void addTask()
	{
		System.out.println("Enter the task's priority:");
		int priority = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the task's action:");
		String action = scan.nextLine();
		taskManager.addTask(priority, action);
	}
	//case 2
	public static void removeTask()
	{
		System.out.println("Enter the task's priority:");
		int priority = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the task's action:");
		String action = scan.nextLine();
		taskManager.removeTask(priority, action);
	}
	//case3
	public static void printTasks()
	{
		taskManager.printTasks();
	}
	//case 4
	public static void readTaskFile()
	{
		System.out.println("Enter the name of the file you want to read from:");
		String fileName = scan.nextLine();
		taskManager.readFile(fileName);
	}
	
	//case 5
	public static void writeFile()
	{
		System.out.println("Enter the name of the file you want to print to:");
		String file = scan.nextLine();
		taskManager.writeFile(file);
	}

}
