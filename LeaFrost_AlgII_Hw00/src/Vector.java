//Written by Lea Frost for CSCE 146

//Class that contains the operator methods
public class Vector{
	
	//Method for adding
		public static String add(double[] v1, double[] v2, int size)
		{
			double[] v3 = new double[size];
			for (int i = 0; i<size; i++)
			{
				v3[i] = v1[i] + v2[i];
			}
			//Create string for output
			String str = "Result:\n" +  print(v1) + "+\n" + print(v2) + "=\n" + print(v3);
			
			return str;
		}
	
	//Method for subtracting
		public static String subtract(double[] v1, double[] v2, int size)
		{
			double[] v3 = new double[size];
			for (int i = 0; i<size; i++)
			{
				v3[i] = v1[i] - v2[i];
			}
			//Create string for output
			String str = "Result:\n" +  print(v1) + "-\n" + print(v2) + "=\n" + print(v3);
			
			return str;
		}
	
	//Method for finding magnitude
		public static double magnitude(double[] v1)
		{
			double mag = 0;
			for (int i = 0; i<v1.length; i++)
			{
				mag += Math.pow(v1[i], 2);
			}
			return Math.sqrt(mag);
		}
		
		//Method for printing a vector as a String
		public static String print(double v[])
		{
			String str = "";
			for(int i = 0; i<v.length; i++)
			{
				str += v[i] + "\n";
			}
			return str;
		}
	

}
