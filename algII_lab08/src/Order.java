//Lea Frost

public class Order implements Comparable<Order>{
	
	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int cookingTimeLeft;
	
	public Order()
	{
		customer = "none";
		foodOrder = "none";
		cookingTime = 1;
		arrivalTime = 0;
		cookingTimeLeft = cookingTime;
		
	}
	public Order(String customer, String foodOrder, int cookingTime, int arrivalTime)
	{
		//use mutators to set the values
		setCustomer(customer);
		setFoodOrder(foodOrder);
		setCookingTime(cookingTime);
		setArrivalTime(arrivalTime);
		setCookingTimeLeft();
	}
	public String toString()
	{
		return "Customer: " + customer + " Order: " + foodOrder + " Cooking Time Left: " + cookingTimeLeft;
	}
	public int compareTo(Order order)
	{
		//returns positive if this time is more, negative is this time is less
		return this.cookingTime-order.cookingTime;
	}
	public void cookForOneMinute()
	{
		cookingTimeLeft--;
	}
	public boolean isDone()
	{
		return this.cookingTimeLeft == 0;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		if(customer!=null)
			this.customer = customer;
		else
			this.customer = "none";
	}
	public String getFoodOrder() {
		return foodOrder;
	}
	public void setFoodOrder(String foodOrder) {
		if(foodOrder!=null)
			this.foodOrder = foodOrder;
		else
			this.foodOrder = "none";
	}
	public int getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(int cookingTime) {
		if(cookingTime>0)
		{
			this.cookingTime = cookingTime;
			cookingTimeLeft = cookingTime;//cooking time left start as the same as cooking time
		}
		
		else
			this.cookingTime = cookingTimeLeft = 1;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		if(arrivalTime>0)
			this.arrivalTime = arrivalTime;
		else
			this.arrivalTime = 0;
	}
	public int getCookingTimeLeft() {
		return cookingTimeLeft;
	}
	public void setCookingTimeLeft() {
		this.cookingTimeLeft = this.cookingTime;
	}
	

}
