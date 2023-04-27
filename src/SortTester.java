import java.util.Arrays;
import java.util.Random;
import DSandAlgos.*;
public class SortTester {

	public static void main(String[] args) 
	{
		Random rand = new Random();
	
		int size = 100000;
		
		Integer[] nums = new Integer[size];
		
		for (int i = 0; i < size; ++i)
		{
			nums[i] = rand.nextInt(100000);
		}
		
		Integer[] backnums = new Integer[size];
		
		for (int i = size - 1; i > 0 ; --i)
		{
			backnums[size- i] = i;
		}
		backnums[0] = 0;
		System.out.println();
		System.out.println(" All sorts are done on arrays of size " + size + " that contain random integer elements");
		System.out.println(" Each sorting algorithm uses the same randomized array for fairness\n");
		
		final long startTime2 = System.currentTimeMillis();
		Sort.quickSort(Arrays.copyOf(nums, size));
		final long endTime2 = System.currentTimeMillis();
		System.out.println(" Quick sort total execution time (milliseconds): " + (endTime2 - startTime2));
		
		final long startTime = System.currentTimeMillis();
		Sort.mergeSort(Arrays.copyOf(nums, size));
		final long endTime = System.currentTimeMillis();
		System.out.println(" Merge sort total execution time (milliseconds): " + (endTime - startTime));
		
		final long startTime5 = System.currentTimeMillis();
		Sort.insertionSort(Arrays.copyOf(nums, size));
		final long endTime5 = System.currentTimeMillis();
		System.out.println(" Insertion sort total execution time (milliseconds): " + (endTime5 - startTime5));
		
		final long startTime4 = System.currentTimeMillis();
		Sort.selectionSort(Arrays.copyOf(nums, size));
		final long endTime4 = System.currentTimeMillis();
		System.out.println(" Selection sort total execution time (milliseconds): " + (endTime4 - startTime4));
		
		final long startTime3 = System.currentTimeMillis();
		Sort.bubbleSort(nums);
		final long endTime3 = System.currentTimeMillis();
		System.out.println(" Bubble sort total execution time (milliseconds): " + (endTime3 - startTime3));
		
		System.out.println();
		
		final long startTime6 = System.currentTimeMillis();
		Sort.quickSort(nums);
		final long endTime6 = System.currentTimeMillis();
		System.out.println(" Quick sort time to figure out an array is already sorted (milliseconds): " + (endTime6 - startTime6));
		
		final long startTime7 = System.currentTimeMillis();
		Sort.mergeSort(nums);
		final long endTime7 = System.currentTimeMillis();
		System.out.println(" Merge sort time to figure out an array is already sorted (milliseconds): " + (endTime7 - startTime7));
		
		final long startTime8 = System.currentTimeMillis();
		Sort.insertionSort(nums);
		final long endTime8 = System.currentTimeMillis();
		System.out.println(" Insertion sort time to figure out an array is already sorted (milliseconds): " + (endTime8 - startTime8));
		
		final long startTime9 = System.currentTimeMillis();
		Sort.selectionSort(nums);
		final long endTime9 = System.currentTimeMillis();
		System.out.println(" Selection sort time to figure out an array is already sorted (milliseconds): " + (endTime9 - startTime9));
		
		final long startTime10 = System.currentTimeMillis();
		Sort.bubbleSort(nums);
		final long endTime10 = System.currentTimeMillis();
		System.out.println(" Bubble sort time to figure out an array is already sorted (milliseconds): " + (endTime10 - startTime10));
		
		System.out.println();
		
		final long startTime11 = System.currentTimeMillis();
		Sort.quickSort(Arrays.copyOf(backnums, size));
		final long endTime11 = System.currentTimeMillis();
		System.out.println(" Quick sort time to sort an array that is sorted backwards (milliseconds): " + (endTime11 - startTime11));
		
		final long startTime12 = System.currentTimeMillis();
		Sort.mergeSort(Arrays.copyOf(backnums, size));
		final long endTime12 = System.currentTimeMillis();
		System.out.println(" Merge sort time to sort an array that is sorted backwards (milliseconds): " + (endTime12 - startTime12));
		
		final long startTime13 = System.currentTimeMillis();
		Sort.insertionSort(Arrays.copyOf(backnums, size));
		final long endTime13 = System.currentTimeMillis();
		System.out.println(" Insertion sort time to sort an array that is sorted backwards (milliseconds): " + (endTime13 - startTime13));
		
		final long startTime14 = System.currentTimeMillis();
		Sort.selectionSort(Arrays.copyOf(backnums, size));
		final long endTime14 = System.currentTimeMillis();
		System.out.println(" Selection sort time to sort an array that is sorted backwards (milliseconds): " + (endTime14 - startTime14));
		
		final long startTime15 = System.currentTimeMillis();
		Sort.bubbleSort(Arrays.copyOf(backnums, size));
		final long endTime15 = System.currentTimeMillis();
		System.out.println(" Bubble sort time to sort an array that is sorted backwards (milliseconds): " + (endTime15 - startTime15));
	}

}
