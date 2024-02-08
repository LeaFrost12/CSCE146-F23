//Lea Frost

//Creates an array of 5 random prizes
//Adds the prize values
//Evaluates whether a user won
public class PrizeArray
{
	public static String[] prizes = prizes();
	//Need to make sure it doesn't repeat
	//returns an array of  5 random prizes
	public static String[] prizes()
	{
		String[] array = PrizeReader.createArray();
		String[] prizes = new String[5];
		//Assigns a random value to each index, checking to make sure none are repeated
		prizes[0] = array[(int)(Math.random()*array.length-1)+1];
		prizes[1] = array[(int)(Math.random()*array.length-1)+1];
		while(prizes[1] == prizes[0])
		{
			prizes[1] = array[(int)(Math.random()*array.length-1)+1];
		}
		prizes[2] = array[(int)(Math.random()*array.length-1)+1];
		while(prizes[2]==prizes[1]||prizes[2]==prizes[0])
		{
			prizes[2] = array[(int)(Math.random()*array.length-1)+1];
		}
		prizes[3] = array[(int)(Math.random()*array.length-1)+1];
		while(prizes[3]==prizes[1]||prizes[3]==prizes[0]||prizes[3]==prizes[2])
		{
			prizes[3] = array[(int)(Math.random()*array.length-1)+1];
		}
		prizes[4] = array[(int)(Math.random()*array.length-1)+1];
		while(prizes[4]==prizes[1]||prizes[4]==prizes[0]||prizes[4]==prizes[2]||prizes[4]==prizes[3])
		{
			prizes[4] = array[(int)(Math.random()*array.length-1)+1];
		}
		
		return prizes;
	}
	//Returns an int of the actual prize of the 5 prizes
	public static int actualPrice(String[] s)
	{
		
		int price = 0;
		for (int i = 0; i<5; i++)
		{
			price += PrizeReader.prizeValue(s[i]);
		}
		return price;
	}
	//Determines whether the player won
	public static int win(int guess, String[] s)
	{
		int totalPrice = actualPrice(s);
		if(guess>totalPrice)
		{
			return 1;
		}
		else if(guess >= totalPrice-1300)
		{
			return 2; 
		}
		return 0;
	}

}
