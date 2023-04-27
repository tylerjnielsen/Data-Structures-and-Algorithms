package DSandAlgos;

public class Sorting 
{
	
	public static <T extends Comparable<T>> void bubbleSort(T[] data)
	{
		for (int position = data.length - 1 ; position >= 0 ; --position)
			for (int i = 0 ; i < position ; ++i)
				if (data[i].compareTo(data[i + 1]) > 0) 
					swap(data, i, i+1);
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] data)
	{
		for (int i = 0 ; i < data.length - 1 ; ++i)
		{
			int min = i;
			for (int j = i + 1 ; j < data.length ; ++j)
			{
				if (data[j].compareTo(data[min]) < 0)
					min = j;
			}
			swap(data, i, min);
		}
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] data)
	{
		for (int index = 1 ; index < data.length ; ++index)
		{
			T key = data[index];
			int position = index;
			
			while (position > 0)
			{
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
	}
	
	private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] data)
	{
		quickSort(data, 0, data.length - 1);
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max)
	{
		if (min < max)
		{
			int indexOfPartition = partition(data, min, max);
			quickSort(data, min, indexOfPartition - 1);
			quickSort(data, indexOfPartition + 1, max);
		}
	}
	
	private static <T extends Comparable<T>> int partition(T[] data, int min, int max)
	{
		int middle = (min + max) / 2;
		T partitionElement = data[middle];
		
		swap(data, middle, min);
		
		int left = min;
		int right = max;
		
		while (left < right)
		{
			while (left < right && data[left].compareTo(partitionElement) <= 0)
				++left;
			
			while (data[right].compareTo(partitionElement) > 0)
				--right;
			
			if (left < right)
				swap(data, left, right);
		}
		swap(data, min, right);
		
		return right;
	}
	
	public static <T extends Comparable<T>> void mergeSort(T[] data)
	{
		mergeSort(data, 0, data.length - 1);
	}
	
	private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid + 1, max);
			merge(data, min, mid, max);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last)
	{
		T[] temp = (T[]) new Comparable[data.length];
		int first1 = first;
		int last1 = mid;
		int first2 = mid + 1;
		int last2 = last;
		int index = first1;
		
		while (first1 <= last1 && first2 <= last2)
		{
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
	}
}
