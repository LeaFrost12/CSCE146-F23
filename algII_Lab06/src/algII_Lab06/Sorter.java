//Lea Frost
package algII_Lab06;

public class Sorter {
	
	public static int countSorts(String str)//Counts sorts in a string
	{
		int count = 0;
		for(int i = 0; i<str.length()-3;i++)
		{
			//checks if each 4 letter section is equal to sort
			if(str.substring(i, i+4).toUpperCase().equals("SORT"))
			{
				count++;
			}
		}
		return count;
	}
	
	public static void mergeSort(String[] a)
	{
		int size = a.length;
		if(size<2)
			return;
		int mid = size/2;
		int leftSize = mid;
		int rightSize = size-mid;
		//split into left and right array
		String[] left = new String[leftSize];
		String[] right  = new String[rightSize];
		for(int i = 0; i<mid; i++)//populate left array
			left[i] = a[i];
		for(int i = mid; i<size; i++)//populate right array
			right[i-mid] = a[i];
		//get down to singular elements
		mergeSort(left);
		mergeSort(right);
		//merge them together
		merge(left, right, a);
	}
	public static void merge(String[] left, String[] right, String[] a)
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;//left array's index
		int j = 0; //right array's index
		int k = 0;//merged array's (a) index
		while(i<leftSize && j<rightSize)//left and right array are not exhausted
		{
			if(countSorts(left[i])<= countSorts(right[j]))//left is smaller than right
			{
				a[k] = left[i];
				i++;
				k++;
			}
			else//right is smaller than left
			{
				a[k] = right[j];
				j++;
				k++;
			}
			
		}
		while(i<leftSize)//put left into the merged array
		{
			a[k] = left[i];
			i++;
			k++;
		}
		while(j<rightSize)//put right into the merged array
		{
			a[k] = right[j];
			j++;
			k++;
		}
	}
	public static void print(String[] a)
	{
		for(int i = 0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	
}
