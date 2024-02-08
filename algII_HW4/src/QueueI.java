//Lea Frost
public interface QueueI <T>//Generic type because it is an abstract structure
							//T is a variable for an object type, is not an object
							//Queue can be any data structure
{
	public T dequeue();//Remove and return head
	public void enqueue(T aData);//Add to tail
	public T peek();//Observes and returns head but does not remove
	
}
