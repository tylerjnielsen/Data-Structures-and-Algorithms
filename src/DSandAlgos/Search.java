package DSandAlgos;

public class Search
{
	public static <T> int linearSearch(T[] data, T target)
	{
		return linearSearch(data, target, 0, data.length - 1);
	}
	
	public static <T> int linearSearch(T[] data, T target, int min, int max)
	{
		if (target == null) throw new IllegalArgumentException("element cannot be null");
		if (data == null) throw new IllegalArgumentException("search pool cannot be null");
		
		if (min < 0) throw new IllegalArgumentException("index out of bounds");
		if (max >= data.length) throw new IllegalArgumentException("index out of bounds");
		
		for (int i = min; i <= max ; ++i)
		{
			if (target.equals(data[i])) return i;
		}
		return -1;
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] data, T target)
	{
		return binarySearch(data, target, 0, data.length - 1);
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] data, T target, int min, int max)
	{
		if (data == null) throw new IllegalArgumentException("data cannot be null");
		if (target == null) throw new IllegalArgumentException("target cannot be null");
		
		return binarySearchChecked(data, target, 0, data.length - 1);
	}
	
	private static <T extends Comparable<T>> int binarySearchChecked(T[] data, T target, int min, int max)
	{			
		int indexOfFoundItem = -1;
		int midpoint = (min + max) / 2;
		int compVal = target.compareTo(data[midpoint]);
		
		if (compVal == 0) 
		{
			return midpoint;
		}
		else if (compVal > 0)
		{
			if (midpoint + 1 <= max)
				indexOfFoundItem = binarySearchChecked(data, target, midpoint + 1, max); 
		}
		else
		{
			if (min <= midpoint - 1)
				indexOfFoundItem = binarySearchChecked(data, target, min, midpoint - 1);
		}
		
		return indexOfFoundItem;
	}
}
