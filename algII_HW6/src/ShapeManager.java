//Lea Frost
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeManager 
{
	LinkedBST<Shape> shapes;
	public static final String DELIM = "\t";
	public static final int SIZE = 5;
	
	public ShapeManager()
	{
		shapes = new LinkedBST<Shape>();
	}
	
	public void addShape(Shape shape)
	{
		shapes.add(shape);
	}
	
	public void removeRectangle(double length, double width)
	{
		Shape rec = new Shape("Rectangle", length, width);
		shapes.remove(rec);
	}
	public void removeCircle(double radius)
	{
		Shape circle = new Shape("Circle", radius);
		shapes.remove(circle);
	}
	
	public void removeTriangle(double base, double height)
	{
		Shape tri = new Shape("Right Triangle", base, height);
		shapes.remove(tri);
	}
	public void removeShape(Shape shape)
	{
		shapes.remove(shape);
	}
	public boolean search(Shape shape)
	{
		return shapes.search(shape);
	}
	public Shape findMax()
	{
		return shapes.getMax();
	}
	public void removeGreaterThan(double area)
	{
		//recursively remove until we reach a shape with a smaller or area
		if(shapes.getMax().getArea()<=area)
			return;
		shapes.remove(shapes.getMax());
		removeGreaterThan(area);
	}
	public void readFile(String file)
	{
		try {
			Scanner fileScanner = new Scanner(new FileInputStream(file));
			while(fileScanner.hasNextLine())
			{
				String[] line = fileScanner.nextLine().split("\t");
				
				//ignore any shapes that are not valid
				if(line[0].equals("Right Triangle")||line[0].equals("Circle")||line[0].equals("Rectangle"))
					shapes.add(makeShape(line));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Shape makeShape(String[] line)
	{
		if(line[0].equals("Right Triangle"))
		{
			double base = Double.parseDouble(line[1]);
			double height = Double.parseDouble(line[2]);
			Shape shape = new Shape("Right Triangle", base, height);
			return shape;
		}
		else if (line[0].equals("Circle"))
		{
			double radius = Double.parseDouble(line[1]);
			Shape shape = new Shape("Circle", radius);
			return shape;
		}
		else//Rectangle
		{
			double length = Double.parseDouble(line[1]);
			double width = Double.parseDouble(line[2]);
			Shape shape = new Shape("Rectangle", length,width);
			return shape;
		}
		
	}
	public void print(int traversal)
	{
		if(traversal==1)//Pre-order
		{
			shapes.printPreorder();
		}
		else if(traversal==2)//In-order
		{
			shapes.printInorder();
		}
		else if(traversal==3)//Post-order
		{
			shapes.printPostorder();
		}
		else
			System.out.println("Invalid entry. Please enter 1,2, or 3.");
		
	}
	public void writeFile(String file)
	{
		shapes.writeFile(file);
	}
}

























