/*
 * Lea Frost
 */



public class GenLL<T>
{
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	private int size;
	public GenLL()
	{
		head = current = previous = null;
		this.size = 0;
	}
	public void add(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null)//if head is null, set head to newNode and set to current
		{
			head = current = newNode;
			this.size = 1;
			return;
		}
		ListNode temp = head;
		while(temp.link != null)//if head is not null, find the first null link and set that link to new Node
		{
			temp = temp.link;
		}
		temp.link = newNode;
		this.size++;
	}
	public void print()
	{
		
		ListNode temp = head;
		while (temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
		
	}
	public void addAfterCurrent(T aData)
	{
		if(current == null)
		{
			return;
		}
		ListNode newNode = new ListNode(aData, current.link);
		current.link = newNode;
		this.size++;
	}
	public T getCurrent()
	{
		if(current == null)
			return null;
		return current.data;
	}
	public void setCurrent(T aData)
	{
		if(aData == null || current == null)
			return;
		current.data = aData;
	}
	public void gotoNext()
	{
		if(current == null)
			return;
		previous = current;
		current = current.link;
	}
	public void reset()
	{
		current = head;
		previous = null;
	}
	public boolean hasMore()
	{
		return current != null;
	}
	public void removeCurrent()
	{
		if(current == head)
		{
			head = head.link;
			current = head;
			this.size = 0;
		}
		else
		{
			previous.link = current.link;
			current = current.link;
			this.size--;
		}
	}
	public int getSize()
	{
		return this.size;
	}
	public T getAt(int i)//acts as random access
	{
		if(i<0 || i>= size)
			return null;
		ListNode temp = head;
		for(int j=0;j<i;j++)//iterates starting from the head until it reaches the element at i
		{
			temp = temp.link;
		}
		return temp.data;//returns the desired data
	}
	public void setAt(int index, T aData)
	{
		if(index <0 || index>=size || aData==null)//make sure index and data are valid
			return;
		ListNode temp = head;
		for(int i=0;i<index;i++)//iterates through
		{
			temp = temp.link;
		}
		temp.data = aData;//sets the desired index to the given data
	}
	public boolean contains(T task)//iterate through the list and return true if the item is found
	{
		ListNode temp = head;
		while(temp.link!=null)
		{
			if(temp.data.equals(task))
				return true;
			temp = temp.link;
		}
		return false;
	}

}
	
















