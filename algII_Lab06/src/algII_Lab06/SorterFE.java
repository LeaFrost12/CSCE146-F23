//Lea Frost
package algII_Lab06;
import java.util.Scanner;

public class SorterFE {
	
	public static Scanner scan= new Scanner(System.in);
	public static Sorter sorter = new Sorter();
	
	public static void main(String[] args) {
		String s = "";
		while (!s.equals("NO"))//allow user to stop whenever
		{
			System.out.println("How many strings would you like to enter?");
			int size = scan.nextInt();
			System.out.println("Enter " + size +  " strings and I will sort them by the number of \"sorts\" that appear");
			
			String[] strings = new String[size];//make the array to hold the strings
			String str = "";
			scan.nextLine();
			for(int i = 0; i<size; i++)
			{
				str = scan.nextLine();
				strings[i] = str;
				
			}
			
			System.out.println("\nHere's the sorted list:");
			Sorter.mergeSort(strings);
			Sorter.print(strings);
			
			System.out.println("\nWould you like to sort more Strings? (yes/no)");
			s = scan.nextLine().toUpperCase();
		}
		System.out.println("Goodbye!");
	
		

	}

}
