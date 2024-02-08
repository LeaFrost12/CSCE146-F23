/*
 * Lea Frost
 */

public class GroceryItem {
	private String name;
	private double price;
	
	public GroceryItem()
	{
		this.name = "none";
		this.price = 0;
	}
	public GroceryItem(String name, double price)
	{
		this.setName(name);
		this.setPrice(price);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) 
	{
		if (name != null)
			this.name = name;
		else
			this.name = "none";
			
	}
	public double getPrice() 
	{
		return this.price;
	}
	public void setPrice(double price) 
	{
		if (price >= 0)
			this.price = price;
		else
			this.price = 0;
	}
	public String toString()
	{
		return "Grocery Item Name: " + this.getName()
						+ " Value: " + this.getPrice();
	}
	public boolean equals(GroceryItem item)
	{
		return item != null  
				&& item.getName().equals(this.getName()) 
					&& item.getPrice()==(this.getPrice());
	}
	
}
