import java.util.*;
public class IntBubbleSortTest
{

	public static void main(String[] args) 
	{
		int[] test = new int[50];
		Random rand = new Random();
		for (int i = 0; i < test.length; ++i)
		{
			test[i] = rand.nextInt(50);
		}
		for (int i = 0; i < test.length; ++i)
		{
			System.out.print(test[i] + " ");
		}
		IntBubbleSort(test);
		System.out.println();
		for (int i = 0; i < test.length; ++i)
		{
			System.out.print(test[i] + " ");
		}
	}
	
	private static int[] IntBubbleSort(int[] intArray)
	{
		for (int i = 0; i < intArray.length; ++i)
		{
			for (int j = i; j < intArray.length; ++j)
			{
				if (intArray[i] > intArray[j])
				{
					int jSave = intArray[j];
					intArray[j] = intArray[i];
					intArray[i] = jSave;
				}
			}
		}
		return intArray;
	}
}
