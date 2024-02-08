/*
 * Lea Frost
 */
import java.io.*;
import java.util.Scanner;

public class GameManager {
	
	private GenLL<Game> games;
	private GenLL<Game> results;
	public static final String DELIM = "\t";
	public static final int GAME_AMT = 2;
	
	public GameManager()//create instance
	{
		games = new GenLL<Game>();
	}
	
	public void addGame(Game aG)
	{
		games.add(aG);
	}
	
	public void removeGame(String aN)
	{
		games.reset();
		while(games.hasMore())
		{
			if(games.getCurrent().getName().equals(aN))
			{
				games.removeCurrent();
				break;
			}
			games.gotoNext();
		}
	}
	//Creates a new Game from each line and adds it to the linked list
	public void readFile(String file)
	{
		games = new GenLL<Game>();
		try
		{
			Scanner fileScanner = new Scanner(new FileInputStream(file));
			while (fileScanner.hasNextLine())
			{
				
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);//split the name and the console
				if(splitLines.length == GAME_AMT)//Check if there are two inputs separated by a tab. If not, ignore the line
				{
					String name = splitLines[0];
					String console = splitLines[1];
					Game game = new Game(name, console);//Creates new instance of game
					games.add(game);//adds the game to the linked list
				}
			}
			fileScanner.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Search for games that match the input and add to a new linked list
	public void search(String name, String console)
	{
		results = new GenLL<Game>();
		//non case-sensitive
		name = name.toLowerCase();
		console = console.toLowerCase();
		//Check for null
		if(name.equals(null)||console.equals(null))
			System.out.println("Invalid input: Please enter a value");
		//if both are *
		else if (name.equals("*") && console.equals("*"))
		{
			for(int i = 0; i<games.getSize(); i++)
			{
				if(!games.getAt(i).equals(null))
					results.add(games.getAt(i));
			}
		}
		//if name is *, return all matching consoles
		else if (name.equals("*"))
		{
			for(int i = 0; i<games.getSize(); i++)
			{
				if(games.getAt(i).getConsole().toLowerCase().contains(console))
				{
					results.add(games.getAt(i));
				}
			}
		}
		//if console is *, return all matching names
		else if(console.equals("*"))
		{
			for(int i = 0; i<games.getSize(); i++)
			{
				if(games.getAt(i).getName().toLowerCase().contains(name))
				{
					results.add(games.getAt(i));
				}
			}
		}
		//if neither are "*"
		else
		{
			
			for(int i = 0; i<games.getSize(); i++)
			{
				if(games.getAt(i).getName().toLowerCase().contains(name)&&games.getAt(i).getConsole().toLowerCase().contains(console))
				{
					results.add(games.getAt(i));
				}
			}
		}
		printResults();
	}
	
	public void writeFile(String file, boolean bool)
	{
		//results = new GenLL<Game>();
		try
		{
			
			PrintWriter fileWriter = new PrintWriter(new FileWriter(file), bool);
			
			for(int i=0; i<results.getSize(); i++)
			{
				fileWriter.println(results.getAt(i).getName() + DELIM + results.getAt(i).getConsole());
			}
		
			
			fileWriter.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void printResults()
	{
		for(int i=0; i<results.getSize(); i++)
		{
			System.out.print(results.getAt(i).getName() + "\t" 
							+ results.getAt(i).getConsole()+"\n");
		}
	}
}

























