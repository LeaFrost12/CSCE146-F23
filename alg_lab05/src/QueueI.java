//Lea Frost
public interface QueueI <T>//Generic type because it is an abstract structure
							//T is a variable for an object type, is not an object
							//Queue can be any data structure
{
	public void enqueue(T aData);//Add to tail
	public T dequeue();//Remove and return head
	public T peek();//Observes and returns head but does not remove
	public void print();//prints
	
}
