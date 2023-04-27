package DSandAlgos;

public class SortingEx 
{
	
	public static <T extends Comparable<T>> int bubbleSort(T[] data)
	{
		int comparisons = 0;
		for (int position = data.length - 1 ; position >= 0 ; --position)
			for (int i = 0 ; i < position ; ++i)
			{
				++comparisons;
				if (data[i].compareTo(data[i + 1]) > 0)
					swap(data, i, i+1);		
			}
		return comparisons;
	}
	
	public static <T extends Comparable<T>> int selectionSort(T[] data)
	{
		int comparisons = 0;
		for (int i = 0 ; i < data.length - 1 ; ++i)
		{
			int min = i;
			for (int j = i + 1 ; j < data.length ; ++j)
			{
				++comparisons;
				if (data[j].compareTo(data[min]) < 0)
					min = j;
			}
			swap(data, i, min);
		}
		return comparisons;
	}
	
	public static <T extends Comparable<T>> int insertionSort(T[] data)
	{
		int comparisons = 0;
		for (int index = 1 ; index < data.length ; ++index)
		{
			T key = data[index];
			int position = index;
			
			while (position > 0)
			{
				++comparisons;
				if (data[position - 1].compareTo(key) > 0)
				{
					data[position] = data[position - 1];
					--position;
				}
				else
				{
					break;
				}
			}	
			data[position] = key;
		}
		return comparisons;
	}
	
	private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	public static <T extends Comparable<T>> int quickSort(T[] data)
	{
		return quickSort(data, 0, data.length - 1);
	}
	
	private static <T extends Comparable<T>> int quickSort(T[] data, int min, int max)
	{
		int comparisons = 0;
		if (min < max)
		{
			QuickSortPartitionResult res = partition(data, min, max);
			int indexOfPartition = res.getIndex();
			comparisons += res.getComparisons();
			comparisons += quickSort(data, min, indexOfPartition - 1);
			comparisons += quickSort(data, indexOfPartition + 1, max);
		}
		return comparisons + 2;
	}
	
private static <T extends Comparable<T>> QuickSortPartitionResult partition(T[] data, int min, int max)
	{
		int comparisons = 0;
		int middle = (min + max) / 2;
		T partitionElement = data[middle];
		
		swap(data, middle, min);
		
		int left = min;
		int right = max;
		
		while (left < right)
		{
			while (left < right && data[left].compareTo(partitionElement) <= 0)
			{
				++left;
				++comparisons;
			}
			while (data[right].compareTo(partitionElement) > 0)
			{
				--right;
				++comparisons;
			}
			if (left < right)
			{
				swap(data, left, right);
			}
		}
		swap(data, min, right);
		
		QuickSortPartitionResult result = new QuickSortPartitionResult(right, comparisons);
		
		return result;
	}
	
	public static <T extends Comparable<T>> int mergeSort(T[] data)
	{
		return mergeSort(data, 0, data.length - 1);
	}
	
	private static <T extends Comparable<T>> int mergeSort(T[] data, int min, int max)
	{
		int comparisons = 0;
		if (min < max)
		{
			int mid = (min + max) / 2;
			comparisons += mergeSort(data, min, mid);
			comparisons += mergeSort(data, mid + 1, max);
			comparisons += merge(data, min, mid, max);
		}
		return comparisons;
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> int merge(T[] data, int first, int mid, int last)
	{
		int comparisons = 0;
		T[] temp = (T[]) new Comparable[data.length];
		int first1 = first;
		int last1 = mid;
		int first2 = mid + 1;
		int last2 = last;
		int index = first1;
		
		while (first1 <= last1 && first2 <= last2)
		{
			++comparisons;
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				++first1;
			}
			else
			{
				temp[index] = data[first2];
				++first2;
			}
			++index;
		}
		
		while (first1 <= last1)
		{
			temp[index] = data[first1];
			++first1;
			++index;
		}
		
		while (first2 <= last2)
		{
			temp[index] = data[first2];
			++first2;
			++index;
		}
		
		for (int i = first; i <= last; ++i)
			data[i] = temp[i];
		
		return comparisons;
	}
	
	private static class QuickSortPartitionResult
	{
		private int _index;
		private int _comparisons;
		
		public QuickSortPartitionResult(int index, int comparisons)
		{
			_index = index;
			_comparisons = comparisons;
		}
		public int getIndex() {return _index;}
		public int getComparisons() {return _comparisons;}
	}
}
