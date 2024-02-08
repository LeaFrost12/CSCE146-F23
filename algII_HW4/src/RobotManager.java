//Lea Frost
import java.util.Scanner;
import java.io.*;
public class RobotManager 
{
	public static final int rows = 10;
	public static final int columns = 10;
	QueueI<String> commandQ;//command queue
	private char[][] board;//board 2D array
	
	public void move()
	{
		int roboRow = 0; 
		int roboColumn = 0; 
		board[roboRow][roboColumn] = 'O';//robot starts at top left
		int commandNumb = -1;
		printBoard();
		while(commandQ.peek()!=null)
		{
			commandNumb++;
			String command = commandQ.dequeue();
			if(command.equals("Move Up"))
			{
				board[roboRow][roboColumn] = '_';//robot's current position changes to "_"
				roboRow--;//robot moves up one row
				if(board[roboRow][roboColumn]=='X')
				{
					System.out.println("Command " + commandNumb + "\nCRASH!"); 
					return;
				}
				board[roboRow][roboColumn] = 'O';
				
			}
			else if(command.equals("Move Down"))
			{
				board[roboRow][roboColumn] = '_';
				roboRow++;//robot moves down one row
				if(board[roboRow][roboColumn]=='X')
				{
					System.out.println("Command " + commandNumb + "\nCRASH!"); 
					return;
				}
				board[roboRow][roboColumn] = 'O';
			}
			else if(command.equals("Move Left"))
			{
				board[roboRow][roboColumn] = '_';//robot's current position changes to "_"
				roboColumn--;//robot moves left
				if(board[roboRow][roboColumn]=='X')
				{
					System.out.println("Command " + commandNumb + "\nCRASH!"); 
					return;
				}
				board[roboRow][roboColumn] = 'O';
			}
			else//right
			{
				board[roboRow][roboColumn] = '_';//robot's current position changes to "_"
				roboColumn++;//robot moves right
				if(board[roboRow][roboColumn]=='X')
				{
					System.out.println("Command " + commandNumb + "\nCRASH!"); 
					return;
				}
				board[roboRow][roboColumn] = 'O';
			}
			System.out.println("Command " + commandNumb);
			printBoard();
		}
	}
	public void printBoard()
	{
		for(int i = 0; i<rows; i++)//iterate through the rows
		{
			for(int j = 0; j<columns; j++)//iterate through the columns
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public void readBoardFile(String file)
	{
		board = new char[rows][columns];//new 2D array to store the board
		try
		{
			Scanner fileScanner = new Scanner(new File(file));
			for(int i = 0; i<rows; i++)//iterate through the rows
			{
				String row = fileScanner.nextLine();//holds each row
				for(int j = 0; j<columns; j++)//iterate through the columns
				{
					board[i][j] = row.charAt(j);//assign each column to the next character
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void readCommandFile(String file)
	{
		commandQ = new ArrayQueue<String>();//initialize queue
		try {
			Scanner fileScanner = new Scanner(new File(file));
			while(fileScanner.hasNext())
			{
				String line = fileScanner.nextLine();
				//Check validity
				if(line.contains("Move Up")||line.contains("Move Down")||line.contains("Move Left")||line.contains("Move Right"))
					commandQ.enqueue(line);//enqueue next line
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
