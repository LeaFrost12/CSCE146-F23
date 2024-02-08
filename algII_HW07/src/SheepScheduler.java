
//Lea Frost
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SheepScheduler {
	private MinHeap<Sheep> sheeps;//I know sheeps isn't a word but I needed a good name
	private Sheep currentSheep;
	private Sheep[] waitingSheep;//Array of sheep sorted by arrival time
	public static final int TOTAL_SHEEP = 60;
	
	public SheepScheduler()
	{
		sheeps = new MinHeap<Sheep>();
		this.currentSheep = null;
		this.waitingSheep = new Sheep[TOTAL_SHEEP];
	}
	public void scheduleSheep()//simulates shearing and prints the best schedule
	{
		int currMin =0;
		while(true)
		{
			for(int i=0;i<TOTAL_SHEEP;i++)//find the next sheep(s) to be added to the heap
				if(currMin==waitingSheep[i].getArrivalTime())
				{
					addSheep(waitingSheep[i]);
					i++;
				}
			if(isDone())
				break;
			advanceOneMinute();
			currMin++;
		}
	}
	public boolean isDone()
	{
		return this.currentSheep==null;
	}
	
	public void addSheep(Sheep sheep)
	{
		if(currentSheep==null)
			currentSheep = sheep;
		else
			sheeps.add(sheep);	
	}
	public void advanceOneMinute()
	{
		currentSheep.shearForOneMin();
		
		if(currentSheep.isDone())
		{
			//print the sheep that just finished
			System.out.println(currentSheep);
			//start sheering next sheep
			currentSheep = sheeps.remove();
		}
	}
	public void readFile(String file)
	{
		try {
			Scanner fileScanner = new Scanner(new FileInputStream(file));
			int lines  = 0;
			while(fileScanner.hasNextLine())
			{
				String[] line = fileScanner.nextLine().split("\t");
				Sheep sheep = new Sheep(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
				waitingSheep[lines] = sheep;
				lines++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
