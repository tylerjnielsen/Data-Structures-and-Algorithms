import java.util.Arrays;

import DSandAlgos.SortingEx;
public class CompareSortStrategies
{

	public static void main(String[] args) 
	{
		
		Integer[] toSort = {6, 52, 81, 7, 31, 75, 41, 70, 90, 55, 16, 19, 83, 4, 98, 97, 94, 39, 30, 88, 25, 80, 2};
		
		System.out.println("Algorithm\t  # of Comparisons\n----------------------------------");
		System.out.println("Bubble Sort\t\t       " + SortingEx.bubbleSort(Arrays.copyOf(toSort, toSort.length)));
		System.out.println("Selection Sort\t\t       " + SortingEx.selectionSort(Arrays.copyOf(toSort, toSort.length)));
		System.out.println("Insertion Sort\t\t       " + SortingEx.insertionSort(Arrays.copyOf(toSort, toSort.length)));
		System.out.println("Merge Sort\t\t        " + SortingEx.mergeSort(Arrays.copyOf(toSort, toSort.length)));
		System.out.println("Quick Sort\t\t       " + SortingEx.quickSort(Arrays.copyOf(toSort, toSort.length)));
		

	}

}
