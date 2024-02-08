//Lea Frost
public class Process {
	private String name;
	private double completionTime;
	
	public Process()
	{
		this.name = "none";
		this.completionTime = 0.0;
	}
	public Process(String name, double completionTime)
	{
		this.setName(name);
		this.setCompletionTime(completionTime);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!=null)
			this.name = name;
		else
			this.name = "none";
	}
	public double getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(double completionTime) {
		if(completionTime>=0)
			this.completionTime = completionTime;
		else
			this.completionTime = 0.0;
	}
	public String toString()
	{
		return "Process Name: " + this.name + " Completion Time: " + this.completionTime;
	}
	
}
