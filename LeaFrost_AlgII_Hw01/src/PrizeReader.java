//Lea Frost
import java.util.Scanner;
import java.io.*;

//Reads the file and populates an array for both the prize and the price
//Contains methods for returning the name and value of a prize
public class PrizeReader {
	
	static int lines = countLines();
	
	//counts number of lines so we can set up an array
	public static int countLines()
	{
		int words = 0;
		
		try 
		{
			Scanner fileScanner = new Scanner(new File("./PrizeFile.txt"));
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				words++;
			}
			fileScanner.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return words;

	}
	//Creates an array with each line stored in a separate index
	//Ignores an incorrectly formatted line, creates a new array without any incorrect lines
	public static String[] createArray()
	{
		//Create an array to store each line
		String[] array = new String[lines];
		try
		{
			Scanner fileScanner = new Scanner(new File("./PrizeFile.txt"));
			for (int i = 0; i<lines; i++)
			{
				String line = fileScanner.nextLine();
				//Check if the line contains a tab and end line, if not it skips it and assigns the index the next line
				if(line.contains("\t")||line.contains("\n"))
				{
					array[i] = line;
				}
				
			}
			//move null element to end
			for(int i = 0; i<lines-1; i++)
			{
				if(array[i]==null)
				{
					String temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			//Count number of nulls
			int nulls = 0;
			for(int i = 0; i<lines; i++)
			{
				if(array[i]==null)
				{
					nulls++;
				}
			}
			//If there is a null, create a new array not including nulls and return that array
			if(nulls>0)
			{
				String[] newArray = new String[lines-nulls];
				for(int i = 0; i<lines-nulls; i++)
				{
					newArray[i] = array[i];
				}
				return newArray;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return array;
	}
	
	//return the name of the prize
	public static String prizeName(String s)
	{
		String str = "";
		String[] array = s.split("\t");
		for (int i = 0; i<array.length-1; i++)
		{
			str += array[i];
		}
		return str;
		
	}
	
	//return the prize value as an int
	public static int prizeValue(String s)
	{
		String[] array = s.split("\t");
		int value = Integer.parseInt(array[array.length-1]);
		return value;
	}
	
}
