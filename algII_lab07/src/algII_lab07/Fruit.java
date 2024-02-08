//Lea Frost
package algII_lab07;

public class Fruit implements Comparable<Fruit>{
	
	private String type;
	private double weight;
	
	public Fruit()
	{
		this.type = "Apple";
		this.weight = 1.0;
	}
	public Fruit (String type, double weight)
	{
		//make sure type is valid
		if(type.equals("Apple")||type.equals("Orange") || type.equals("Banana")|| type.equals("Kiwi") ||type.equals("Tomato"))
			this.type = type;
		else
			this.type = "Apple";
		//make sure weight is valid
		if(weight>0)
			this.weight = weight;
		else
			this.weight = 1.0;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		if(type=="Apple"||type == "Orange" || type ==  "Banana" || type == "Kiwi" ||type == "Tomato")
			this.type = type;
		else
			this.type = "Apple";
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if(weight>0)
			this.weight = weight;
		else
			this.weight = 1.0;
	}
	public String toString()
	{
		return  type +"\t"+ weight;
	}
	public int compareTo(Fruit fruit)
	{
		if(fruit==null)
			return -1;
		//if this fruit weighs more, return positive
		else if(fruit.weight<this.weight)
			return 1;
		//if this fruit weighs less, return negative
		else if(fruit.weight>this.weight)
			return -2;
		//if they are equal
		else 
			return fruit.type.compareTo(this.type);
	}

	

}
