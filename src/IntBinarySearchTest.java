public class IntBinarySearchTest
{
	public static void main(String[] args) 
	{
		int[] test = new int[15];
		for (int i = 0; i < test.length; ++i)
		{
			test[i] = 2*i;
		}
		for (int i = 0; i < test.length; ++i)
		{
			System.out.print(test[i] + " ");
		}	
		System.out.println();
		for (int i = 0; i <= test[14]; ++i)
		{
			System.out.println("Index of " + i + ": " + BinarySearch(i, test));
		}
		
	}
	// BUGGED METHOD BELOW:
	private static int BinarySearch(int num, int[] intArray)
	{
		int lowIndex = 0;
		int highIndex = intArray.length-1;
		for (int i = 0; i < intArray.length; ++i)
		{
			int index = (int)((highIndex-lowIndex)/2);
			if (highIndex - 2 == lowIndex)
				if (intArray[lowIndex + 1] == num) return lowIndex + 1;
			if (intArray[index] < num)
			{
				lowIndex = index;
			}
			else if (intArray[index] > num)
			{
				highIndex = index;
			}
			else return index;
		}
		return -1;
	}
}
