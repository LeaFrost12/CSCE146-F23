//Lea Frost

public class Sheep implements Comparable<Sheep>{
private String name;
private int shearingTime;
private int arrivalTime;
private int shearingTimeLeft;

	public Sheep(String name, int shearingTime, int arrivalTime)
	{
		this.name = name;
		this.shearingTime = this.shearingTimeLeft = shearingTime;
		this.arrivalTime = arrivalTime;
	}
	public int compareTo(Sheep sheep)
	{
		//return positive if this sheep has longer time, negative if this sheep has shorter time
		if(this.shearingTime!=sheep.shearingTime)
			return this.shearingTime-sheep.shearingTime;
		//if times are equal, return the alphabetical difference
		else
			return this.name.compareTo(sheep.name);
	}
	public void shearForOneMin()
	{
		shearingTimeLeft--;
	}
	public String toString()
	{
		return "Name: " + name + ", Shear Time: " + shearingTime + ", Arrival Time: " + arrivalTime;
	}
	public boolean isDone()
	{
		return shearingTimeLeft==0;
	}
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	public int getShearTimeLeft()
	{
		return shearingTimeLeft;
	}
	public int getShearTime()
	{
		return shearingTime;
	}
}
