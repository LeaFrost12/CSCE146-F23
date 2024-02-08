//Lea Frost

import java.util.Scanner;
public class ShowcaseFE {
	
	public static void main(String[] args) 
	{
		
		int end = 1;
		while(end==1)
		{
			//Creates a new random array
			String[] array = PrizeArray.prizes();
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to the showcase showdown!\nYour prizes are:\n" 
				+ PrizeReader.prizeName(array[0]) 
				+"\n"+ PrizeReader.prizeName(array[1]) 
				+"\n"+ PrizeReader.prizeName(array[2]) 
				+"\n"+ PrizeReader.prizeName(array[3]) 
				+"\n"+ PrizeReader.prizeName(array[4]) 
				+ "\nGuess the total value of the prizes without going over and within $1300 below the total value"
				+ "\nEnter your guess:");
			int guess = scan.nextInt();
			System.out.println("The actual value is " + PrizeArray.actualPrice(array));
			//Uses the win method to determine if a user won
			if (PrizeArray.win(guess, array)==2)
			{
				System.out.println("You won! Great job!");
			}
			else if (PrizeArray.win(guess, array)==1)
			{
				System.out.println("Your guess was over. Try again next time");
			}
			else
			{
				System.out.println("Your guess was under. Try again next time");
			}
			//Allows the user to chose to quit
			System.out.println("Enter 1 to keep playing. Enter 2 to quit");
			end = scan.nextInt();
		}
		System.out.println("Goodbye!");
		
		
	}
	

}
