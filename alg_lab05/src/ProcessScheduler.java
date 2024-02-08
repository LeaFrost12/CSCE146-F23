//Lea Frost
public class ProcessScheduler {
	private QueueI<Process> processes;
	private Process currentProcess;
	
	public ProcessScheduler()
	{
		processes = new LLQueue<Process>();
		currentProcess = null;
	}
	public Process getCurrentProcess()
	{
		return currentProcess;
	}
	public void addProcess(Process newProcess)//enqueues the new process if it isn't null
	{
		
		if (currentProcess==null)
			currentProcess = newProcess;
		else
			processes.enqueue(newProcess);
	}
	public void runNextProcess()//sets the current process to the first element while also removing the first element
	{
		currentProcess = processes.dequeue();
	}
	public void cancelCurrentProcess()
	{
		Process nextProcess = processes.dequeue();//first element is dequeued
		if(nextProcess == null)
			currentProcess = null;
		else
		{
			processes.enqueue(currentProcess);//enqueue the current process
			currentProcess = nextProcess;//current process is now the original first element
		}
	}
	public void printProcessQueue()
	{
		processes.print();
	}
}
