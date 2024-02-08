//Lea Frost

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class FileIOSolutions {

	public static void pastTense(String file1, String file2)
	{
		File present = new File(file1);
		File past = new File(file2);
		//arraylist will store the words
		ArrayList<String> words = new ArrayList<String>();
		try 
		{
			//create printwriter so we can write in the new file
			PrintWriter printer = new PrintWriter(new FileOutputStream(past));
			//Create scanner for the input file
			Scanner fileScanner = new Scanner(present);
			//add each word to the arraylist
			while(fileScanner.hasNext())
			{
				words.add(fileScanner.next());
			}
			//print each word to the console and to the file while changing is to was
			for(int i = 0; i<words.size(); i++)
			{
				if(words.get(i).toLowerCase().equals("is"))
				{
					words.set(i,"was");
				}
				printer.println(words.get(i));
				System.out.println(words.get(i));
			}
			printer.close();
			fileScanner.close();
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static double totalTubeVolume(String file)
	{
		double volume = 0.0;
		try 
		{
			Scanner fileScanner = new Scanner(new File(file));
			//Splits each line by tab, calculates the volume from the radius and height, adds the value to total volume
			while(fileScanner.hasNext())
			{
				String line = fileScanner.nextLine();
				String[] array = line.split("\t");
				volume += (calculateVolume(Double.parseDouble(array[1]), Double.parseDouble(array[2])));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return volume;
	}
	//returns the volume of a single tube
	public static double calculateVolume(double r, double h)
	{
		return (Math.pow(r,2) * Math.PI * h);
	}
}












































