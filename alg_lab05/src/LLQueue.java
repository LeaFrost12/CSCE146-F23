//Lea Frost
public class LLQueue<T> implements QueueI<T>
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
	private ListNode head;//first element
	private ListNode tail;//last element
	public LLQueue()
	{
		head = tail = null;
	}
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode(aData, null);//create new node for the new data
		if(head == null)//if list is empty
		{
			head = tail = newNode;
		}
		else
		{
			tail.link = newNode;//set tail's link to newNode
			tail = tail.link;//change tail to the new last element
		}
		
	}
	public T dequeue()
	{
		if(head == null)//if queue is empty
			return null;
		T ret = head.data;//ret is head's data
		head = head.link;//change head to head's link
		return ret;
	}
	public T peek()
	{
		if(head == null)
			return null;
		return head.data;
	}
	public void print()
	{
		for(ListNode temp = head;temp!= null; temp = temp.link)//iterate through the list and print 
			System.out.println(temp.data);
	}
}
