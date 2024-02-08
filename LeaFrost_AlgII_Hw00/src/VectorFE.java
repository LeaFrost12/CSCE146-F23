//Written by Lea Frost for CSCE 146
import java.util.Scanner;

//Front end
public class VectorFE {
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Vector Operations Program!");
		Scanner scan = new Scanner(System.in);
		//Use while loop so that it continues to prompt the user until they choose to quit
		int action = 0;
		while (action != 4)
		{
			//Prompt user for action
			System.out.println("Enter 1. To Add 2 Vectors\n"
					+ "Enter 2. To Subtract 2 Vectors\n"
					+ "Enter 3. To Find the Magnitude of a Vector\n"
					+ "Enter 4. To Quit");
			action = scan.nextInt();
			//If the user enters an invalid action, they are prompted to try again
			if (action<1 ||action>4)
			{
				System.out.println("Invalid entry. Please try again");
			}
			//Quit
			if(action == 4)
			{
				System.out.println("Goodbye!");
			}
			
			//Adding or subtracting
			else if (action==1||action==2)
			{
				//Prompt user to enter size
				System.out.println("Enter the size of the Vectors:");
				int size = scan.nextInt();
				//Check if size is valid
				if(size<1)
				{
					System.out.println("\nInvalid Size: The size of a vector must be at least 1");
				}
				//Continue if size is valid
				else
				{
					//Create 2 arrays to store values for the 2 vectors
					double[] v1 = new double[size];
					double[] v2 = new double[size];
					//Prompt user for values of Vector 1 and 2 and use for loops to fill the arrays
					System.out.println("Enter values for Vector1:");
					for (int i=0; i<size; i++)
					{
						v1[i] = scan.nextDouble();
					}
					System.out.println("Enter values for Vector2:");
					for (int i=0; i<size; i++)
					{
						v2[i] = scan.nextDouble();
					}
					//Use add method to return output
					if(action==1)
					{
						System.out.println(Vector.add(v1,v2,size));
					}
					//Use subtract method to return output
					else if(action==2)
					{
						System.out.println(Vector.subtract(v1,v2,size));
					}
						
				}
			}
			//Finding Magnitude
			else if (action == 3)
			{
				//Prompt user to enter size
				System.out.println("Enter the size of the Vector:");
				int size = scan.nextInt();
				//Check if size is valid
				if(size<1)
				{
					System.out.println("Invalid Size: The size of a vector must be at least 1");
				}
				//Continue if size is valid
				else
				{
					//Create an array to store values for the vector
					double[] v1 = new double[size];
					//Prompt user for values of Vector 1 and use a for loop to fill the array
					System.out.println("Enter values for the Vector:");
					for (int i=0; i<size; i++)
					{
						v1[i] = scan.nextDouble();
					}
					//Use Magnitude method to return the magnitude
					System.out.println("The magnitude is: " + Vector.magnitude(v1));
				}
			}
		}

	}
}
