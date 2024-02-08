//Lea Frost
import java.util.Scanner;
public class ShapeFE {
	private static Scanner scan = new Scanner(System.in);
	private static ShapeManager shapeManager = new ShapeManager();
	public static void main(String[] args) 
	{
		
		System.out.println("Welcome to the Shape Tree!");
		boolean quit = false;
		while(!quit)
		{
			printGreeting();
			int action = scan.nextInt();
			switch(action)
			{
			case 1://scan file
				System.out.println("Enter the file name:");
				scan.nextLine();
				String file = scan.nextLine();
				shapeManager.readFile(file);
				System.out.println("Printing contents of file In-Order:");
				shapeManager.print(2);
				System.out.println();
				break;
			
			case 2://print to console
				System.out.println("Which traversal?"
						+ "\nEnter 1. Pre-order"
						+ "\nEnter 2. In-Order"
						+ "\nEnter 3. Post-order");
				int traversal = scan.nextInt();
				shapeManager.print(traversal);
				System.out.println();
				break;
			case 3://add shape
				System.out.println("Enter the type of shape to add:");
				scan.nextLine();
				String type = scan.nextLine();
				if(type.equalsIgnoreCase("right triangle")||type.equalsIgnoreCase("circle")||type.equalsIgnoreCase("rectangle"))
					shapeManager.addShape(makeShape(type));
				break;
			case 4://remove shape
				System.out.println("Enter the type of shape:");
				scan.nextLine();
				String type1 = scan.nextLine();
				if(type1.equalsIgnoreCase("right triangle")||type1.equalsIgnoreCase("circle")||type1.equalsIgnoreCase("rectangle"))
					shapeManager.removeShape(makeShape(type1));
				break;
			case 5://search for shape
				System.out.println("Enter the type of shape:");
				scan.nextLine();
				String type2 = scan.nextLine();
				if(type2.equalsIgnoreCase("right triangle")||type2.equalsIgnoreCase("circle")||type2.equalsIgnoreCase("rectangle"))
					System.out.println("Was the shape found in the tree? " +shapeManager.search(makeShape(type2))+"\n");
				break;
			case 6://find shape with max area
				Shape max = shapeManager.findMax();
				System.out.println("The shape with the largest area is: " +max.toString()+"\n");
				break;
			case 7://remove all shapes greater than an area
				System.out.println("Enter the area:");
				scan.nextLine();
				double area = scan.nextDouble();
				shapeManager.removeGreaterThan(area);
				System.out.println();
				break;
				
			case 8://print shape tree to file
				System.out.println("Enter the name of the file:");
				scan.nextLine();
				String file1 = scan.nextLine();
				shapeManager.writeFile(file1);
				break;
			case 0://quit
				quit = true;
				System.out.println("Goodbye!");
				break;
			default: 
				System.out.println("Invalid input");
				
			}	
			
		}	

	}
	private static void printGreeting()
	{
		System.out.println("Enter 1. To Read a Shape Tree from a File.\n"
				
				+ "Enter 2. To Print a Tree Traversal to the Console\n"
				+ "Enter 3. To Add a Shape.\n"
				+ "Enter 4. To Remove a Shape.\n"
				+ "Enter 5. To Search for a Shape.\n"
				+ "Enter 6. To Find the Shape with the Max Area.\n"
				+ "Enter 7. To Remove All Shapes Greater than an Area.\n"
				+ "Enter 8. To Print Shape Tree to File.\n"
				+ "Enter 0. To Quit.");
	}
	private static Shape makeShape(String type)
	{
		
		if(type.equalsIgnoreCase("right triangle"))
		{

			System.out.println("Enter the base followed by the height:");
			double base = scan.nextDouble();
			double height = scan.nextDouble();
			Shape tri = new Shape("Right Triangle", base, height);
			return tri;
		}
		else if (type.equalsIgnoreCase("circle"))
		{
			System.out.println("Enter the radius:");
			double radius = scan.nextDouble();
			Shape circle = new Shape("Circle", radius);
			return circle;
		}
		else//Rectangle
		{
			System.out.println("Enter the length followed by the width:");
			double length = scan.nextDouble();
			double width = scan.nextDouble();
			Shape rec = new Shape("Rectangle", length,width);
			return rec;
		}
	}
	
	
	
}
