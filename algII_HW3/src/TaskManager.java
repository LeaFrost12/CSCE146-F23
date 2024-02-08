/*
 * Lea Frost
 */
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskManager 
{
	GenLL<Task>[] organizedTasks;
	public static final String DELIM = "\t";
	public static final int SIZE = 5;
	
	public TaskManager()
	{
		organizedTasks = new GenLL[SIZE];
		for(int i=0;i<organizedTasks.length;i++)
		{
			organizedTasks[i] = new GenLL<Task>();
		}
	}
	
	public void addTask(int priority, String action)
	{
		Task newTask = new Task(priority, action);
		boolean repeat = false;
		while(organizedTasks[priority].hasMore())//check to make sure it's not a duplicate
		{
			if(organizedTasks[priority].getCurrent().getAction().equals(action))
			{
				System.out.println("Error: This task already exists. It was not added to the list.");
				repeat = true;
				break;
			}
			organizedTasks[priority].gotoNext();//iterate through the list
		}	
		if(!repeat)
			organizedTasks[priority].add(newTask);
	}
	
	public void removeTask(int priority, String action)
	{
		Task newTask = new Task(priority, action);
		organizedTasks[priority].reset();
		while(organizedTasks[priority].hasMore())
		{
			if(organizedTasks[priority].getCurrent().getAction().equals(action))
			{
				organizedTasks[priority].removeCurrent();
				break;
			}
			organizedTasks[priority].gotoNext();//iterate through the list
		}	
		
	}
	
	public void printTasks()
	{
		for(int i=0; i<SIZE; i++)
		{
			organizedTasks[i].showList();
		}
	}
	public void readFile(String file)
	{
		organizedTasks = new GenLL[SIZE];
		for(int i=0;i<organizedTasks.length;i++)
		{
			organizedTasks[i] = new GenLL<Task>();
		}
		try
		{
			Scanner fileScanner = new Scanner(new FileInputStream(file));
			while (fileScanner.hasNextLine())
			{
				
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);//split the priority and the action
				if(splitLines.length == 2)//Check if there are two inputs separated by a tab. If not, ignore the line
				{
					int priority = Integer.parseInt(splitLines[0]);
					String action = splitLines[1];
					Task task = new Task(priority, action);//Creates new instance of task
					organizedTasks[priority].add(task);//adds the task to the linked list
				}
			}
			fileScanner.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void writeFile(String file)
	{
		try
		{
			
			PrintWriter fileWriter = new PrintWriter(new FileWriter(file));
			
			for(int i=0; i<5; i++)
			{
				for(int j=0; j<organizedTasks[i].getSize(); j++)
				{
					fileWriter.print(organizedTasks[i].getAt(j).getPriority() + "\t" + organizedTasks[i].getAt(j).getAction() + "\n");
				}
			}
			fileWriter.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
}
