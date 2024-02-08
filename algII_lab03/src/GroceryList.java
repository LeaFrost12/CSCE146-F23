/*
 * Lea Frost
 */
public class GroceryList {
	private class ListNode
	{
		GroceryItem data;
		ListNode link;
		public ListNode()
		{
			data = null;
			link = null;
		}
		public ListNode(GroceryItem aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head; 
	private ListNode current;
	private ListNode previous;
	public GroceryList()
	{
		head = current = previous = null;
	}
	public void gotoNext()
	{
		if(current != null)
			previous = current;
			current = current.link;
		
	}
	public GroceryItem getCurrent()
	{
		if(current== null)
			return null;
		return current.data;
	}
	public void setCurrent(GroceryItem item)
	{
		if(item==null||current==null)
			return;
		current.data = item;
		
	}
	public void addItem(GroceryItem item)
	{
		ListNode newNode = new ListNode(item, null);
		if (head == null)
		{
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.link!=null)//finds the first null element starting from the head 
			temp = temp.link;
		temp.link = newNode;//puts the new node at the end
	}
	public void addItemAfterCurrent(GroceryItem item)
	{	
		if(item==null||current==null)//Don't do anything if item is null or list is empty
			return;
		ListNode newNode = new ListNode(item, null);
		current.link = newNode;//add after current
	}
	public void removeCurrent()
	{
		if(current==head)//If current is the head, set current and head to the next value
		{
			head = head.link;
			current = head;
			return;
		}
		previous.link = current.link;
		current = current.link;
	}
	public void showList()//iterate through the list and print each item
	{
		ListNode temp = head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public boolean contains(GroceryItem item)//iterate through the list and return true if the item is found
	{
		ListNode temp = head;
		while(temp.link!=null)
		{
			if(temp.data.equals(item))
				return true;
			temp = temp.link;
		}
		return false;
	}
	public double totalCost()//Iterate through the list and get the price of each item
	{
		double price = 0;
		ListNode temp = head;
		while(temp!= null)
		{
			price += temp.data.getPrice();
			temp = temp.link;
		}
		return price;
	}
	
	
	
}
