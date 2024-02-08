/*
 * Lea Frost
 */

public class Game {
	private String name;
	private String console;
	
	public Game()//default 
	{
		this.name = "none";
		this.console = "none";
	}
	public Game(String aN, String aC)
	{
		this.setName(aN);
		this.setConsole(aC);
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) {
		if(name != null)
			this.name = name;
		else
			this.name = "none";
	}
	public String getConsole()
	{
		return console;
	}
	public void setConsole(String console) {
		if(console != null)
			this.console = console;
		else
			this.console = "none";
	}
}
