//Lea Frost

public class Task //Constructs the task object
{
	private int priority;
	private String action;
	
	public Task()
	{
		this.priority = 4;
		this.action = "none";
	}
	public Task(int priority, String action)
	{
		this.setPriority(priority);
		this.setAction(action);
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) 
	{
		if(priority <0 || priority >4)
			this.priority = 4;
		else
			this.priority = priority;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) 
	{
		if(action == null)
			this.action = "none";
		else
			this.action = action;
	}
	public String toString()
	{
		return "Priority: " + this.priority + "\tTask: " + this.action +"\n";
	}
	public boolean equals(Task task)
	{
		return task != null && 
				this.action.equals(task.getAction())&& 
				this.priority==task.getPriority();
			
			
	}
	
	
}
