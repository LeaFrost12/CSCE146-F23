//Written by Lea Frost for CSCE 146
package algII_lab01;

public class WordHelper {
	//method that returns true if a character is a vowel and returns false if it's not
	public static boolean isVowel(char ch)
	{
		boolean bool = false; 
		if (ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u'||ch == 'y')
		{
			bool = true;
		}
		return bool;
	}
	//method that returns the number of vowels in a string
	public static int countVowels(String s)
	{
		int count = 0;
		//Make sure the string is all lower case
		s = s.toLowerCase();
		for (int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			if (isVowel(ch))
			{
				count++;
			}
		}
		return count;
	}
	//method that counts consonants by subtracting length of string by the number of vowels
	public static int countConsonants(String s)
	{
		
		return s.length() - countVowels(s);
		
	}
	
	//sorts array by vowels by using the countVowels method
	public static String[] sortByVowels(String[] s)
	{
		//create a copy of the array
		String[] copy = s.clone();
		//Bubble Sort to sort by vowels
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i<copy.length-1; i++)
			{
				//swaps the string at index i if it has more vowels than the String at i+1
				if(countVowels(copy[i])>countVowels(copy[i+1]))
				{
					//Swap
					String temp = copy[i];
					copy[i] = copy[i+1];
					copy[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		//returns the sorted array
		return copy;
	}
	
	//Sorts array by consonants using the countConsonants method
	public static String[] sortByConsonants(String[] s)
	{
		//create copy of the array
		String[] copy = s.clone();
		//Bubble Sort to sort by number of consonants
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i<copy.length-1; i++)
			{
				//Swaps string at index i if the string at i+1 has less consonants
				if(countConsonants(copy[i])>countConsonants(copy[i+1]))
				{
					//Swap
					String temp = copy[i];
					copy[i] = copy[i+1];
					copy[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		//returns the sorted array
		return copy;
	}
	
	//Sorts array by length
	public static String[] sortByLength(String[] s)
	{
		//Create a copy of the array
		String[] copy = s.clone();
		//Bubble Sort to sort by length
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i<copy.length-1; i++)
			{
				//Swaps string at index i if string i+1 is shorter
				if(copy[i].length()>copy[i+1].length())
				{
					//Swap
					String temp = copy[i];
					copy[i] = copy[i+1];
					copy[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
		//returns the array sorted by length
		return copy;
	}
}
