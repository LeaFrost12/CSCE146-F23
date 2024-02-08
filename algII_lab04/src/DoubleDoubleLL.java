/*
 * Lea Frost
 */

public class DoubleDoubleLL
{
	public class ListNode
	{
		double data;
		ListNode next;
		ListNode back;
		public ListNode(double aData)
		{
			data = aData;
			next = null;
			back = null;
		}
	}
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	public DoubleDoubleLL()
	{
		head = current = previous = null;
	}
	public void gotoNext()
	{
		if(current == null)
			return;
		else
			previous = current;
			current = current.next;
	}
	public void gotoPrev()
	{
		if(current == null)
			return;
		else
			previous = previous.back;
			current = current.back;
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	public void gotoEnd()
	{
		current = head;
		if(current==null)
			return;
		while(current.next!= null)
		{
			current = current.next;
		}
	}
	public boolean hasMore()
	{
		return !(current==null);
	}
	public double getCurrent()
	{
		return current.data;
	}
	public void setCurrent(double aData)
	{
		if(current==null)
			return;
		else
			current.data = aData;
					
	}
	public void add(double aData)
	{
		ListNode newNode = new ListNode(aData);
		if(head==null)
		{
			head = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = newNode;//new node is in front of temp
		newNode.back = temp;//set the new node's backward link to temp
		
		
	}
	public void addAfterCurrent(double aData)
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(aData);
		newNode.next = current.next;//New node's forward reference is current's next
		newNode.back = current; //current is behind newNode
		newNode.next.back = newNode;//The node after newNode has a back link to newNode
		current.next = newNode;//new node is in front of current
		
	}
	public void remove(double aData)
	{
		ListNode temp = head;
		while(temp!=null)
		{
			if(temp.data==aData)
			{
				if(temp.back != null)
				{
					temp.back.next = temp.next;
				}
				else
				{
					head = temp.next;
				}
				if(temp.next!=null)
				{
					temp.next.back = temp.back;
				}
				temp.next = null;
				temp.back = null;
				//temp.next.back = temp.back;//the value after temp has a backward reference to the value before temp
				//temp.back.next = temp.next;//the value behind temp has a forward reference to the value in front of temp
			}
			temp = temp.next;
		}
	}
	public void removeCurrent()
	{
		if(current == null)
			return;
		if(current.back != null)
			current.back.next = current.next;
		else
			head = current.next;
		if(current.next != null)
		{
			current.next.back = current.back;
		}
		current.next = null;
		current.back = null;
		current = null;
	}
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public boolean contains(double aData)
	{
		ListNode temp = head;
		while(temp!=null)
		{
			if (temp.data == aData)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
}
