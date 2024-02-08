//Lea Frost
public class ArrayQueue <T> implements QueueI<T>//T because it can be any type
{
	public static final int DEF_SIZE = 30;//large number to initialize array
	private T[] queue;
	private int headIndex;//first element
	private int tailIndex;//first null element(empty space)
	public ArrayQueue()
	{
		init(DEF_SIZE);//use default size
	}
	public ArrayQueue(int size)
	{
		init(size);//use input size
	}
	public T dequeue()//remove and return head
	{
		T ret = queue[headIndex];//store the first element
		headIndex = (headIndex+1)%queue.length;//change the first element to the next element
		return ret;//return the original first element
	}
	public void enqueue(T aData)//add to end
	{
		if(queue[headIndex] != null && headIndex==tailIndex)
			return;//the array is full because it is not empty and tail has looped to the head
		queue[tailIndex] = aData;//set the tail to the data
		tailIndex = (tailIndex+1)%queue.length;//circular link (if array is full, tail will loop around)
	}
	public void init(int size)//initialize the array
	{
		headIndex = tailIndex = 0;
		if(size >= 1)
			queue = (T[])(new Object[size]);//T is not an object itself so create a new object and type cast it to T
		else
			queue = (T[])(new Object[DEF_SIZE]);
	}
	public T peek()
	{
		return queue[headIndex];
	}
	
			
}
