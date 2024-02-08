//Lea Frost
public class Shape implements Comparable<Shape>{

	public String type;
	public double radius, base, height, length, width, area;
	
	public Shape(String type, double radius)//Circle
	{
		this.type = type;
		this.radius = radius;
		this.area = Math.PI*Math.pow(radius, 2);
	}
	public Shape(String type, double baseOrLength, double heightOrWidth)
	{
		if(type.equals("Rectangle"))
		{
			this.type = type;
			this.length = baseOrLength;
			this.width = heightOrWidth;
			this.area = this.length * this.width;
		}
		else if(type.equals("Right Triangle"))
		{
			this.type = type;
			this.base = baseOrLength;
			this.height = heightOrWidth;
			this.area = 0.5*this.base*this.height;
		}
	}
	
	public double getArea()
	{
		return area;
	}
	public String getType()
	{
		return type;
	}
	public String toString()
	{
		if (type.equals("Circle"))
			return "Circle Radius: " + radius + " Area: " + area;
		else if (type.equals("Right Triangle"))
			return "Right Triangle Base: " + base + " Height: " + height + " Area: " + area;
		else
			return "Rectangle Length: " + length + " Width: " + width + " Area: " + area ;
	}
	 public String toFileString() {
	        if (type.equals("Circle"))
	            return String.format("Circle\t%.2f\n", radius);
	        else if (type.equals("Right Triangle"))
	            return String.format("Right Triangle\t%.2f\t%.2f\n", base, height);
	        else
	            return String.format("Rectangle\t%.2f\t%.2f\n", length, width);
	    }
	
	public int compareTo(Shape shape)
	{
		//if this shape is bigger, return a positive
		if(this.area>shape.area)
			return 1;
		//if this shape is smaller, return negative
		if(this.area<shape.area)
			return -1;
		//if areas are the same, return 0
		else
			return 0;
		
	}
	
	
	
}
