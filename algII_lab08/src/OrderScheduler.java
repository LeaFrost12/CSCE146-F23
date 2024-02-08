//Lea Frost
public class OrderScheduler {
	private MinHeap<Order> orders;
	private Order currentOrder;
	private int currentMinute, totalOrders;
	private double summedTimes;//make this a double so the average time is a double
	public OrderScheduler()
	{
		//set to default values
		orders = new MinHeap<Order>();
		currentOrder = null;
		currentMinute = totalOrders = 0;
		summedTimes = 0;
	}
	public void addOrder(Order order)
	{
		if(currentOrder == null)
			currentOrder = order;
		else
			orders.add(order);
		totalOrders++;
	}
	public void advanceOneMinute() {
        currentMinute++;
        
        currentOrder.cookForOneMinute();
        if (currentOrder.isDone())
        {
        	System.out.println(currentOrder.toString());
        	//summedTimes += currentMinute - currentOrder.getArrivalTime();
        	currentOrder = orders.remove();//if it is done, remove it
        	
        }
        
    }
	public boolean isDone()
	{
		return currentOrder == null;
	}
	public double getAverageWaitingTime()
	{
		return summedTimes/totalOrders;
	}

	public Order getCurrentOrder()
	{
		return currentOrder;
	}
	
}
