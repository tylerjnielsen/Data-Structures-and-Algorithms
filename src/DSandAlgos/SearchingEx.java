package DSandAlgos;

public class SearchingEx
{
	public static <T> SearchResult linearSearch(T[] data, T target)
	{
		return linearSearch(data, target, 0, data.length - 1);
	}
	
	public static <T> SearchResult linearSearch(T[] data, T target, int min, int max)
	{
		SearchResult result = new SearchResult(-1, 0);
		
		if (target == null) throw new IllegalArgumentException("element cannot be null");
		if (data == null) throw new IllegalArgumentException("search pool cannot be null");
		
		if (min < 0) throw new IllegalArgumentException("index out of bounds");
		if (max >= data.length) throw new IllegalArgumentException("index out of bounds");
		
		for (int i = min; i <= max ; ++i)
		{
			result.incrementComparisons();
			if (target.equals(data[i])) 
			{
				result.setIndex(i);
				break;
			}
		}
		return result;
	}
	
	public static <T extends Comparable<T>> SearchResult binarySearch(T[] data, T target)
	{
		return binarySearch(data, target, 0, data.length - 1);
	}
	
	public static <T extends Comparable<T>> SearchResult binarySearch(T[] data, T target, int min, int max)
	{
		if (data == null) throw new IllegalArgumentException("data cannot be null");
		if (target == null) throw new IllegalArgumentException("target cannot be null");
		
		return binarySearchChecked(data, target, 0, data.length - 1, 0);
	}

	private static <T extends Comparable<T>> SearchResult binarySearchChecked(T[] data, T target, int min, int max, int comparisons)
	{			
		int indexOfFoundItem = -1;
		int midpoint = (min + max) / 2;
		int compVal = target.compareTo(data[midpoint]);
		
		if (compVal == 0) 
		{
			System.out.print("binarySearch found\t ");
			if (target.toString().length() < 2) System.out.print(" ");
			System.out.print(target + " at index ");
			if (midpoint < 10) System.out.print(" ");
			System.out.print(midpoint + " after ");
			if (comparisons < 10) System.out.print(" ");
			System.out.println((comparisons+1) + " comparisons.");
			return new SearchResult(midpoint, comparisons+1);
		}
		else if (compVal > 0)
		{
			if (midpoint + 1 <= max)
				indexOfFoundItem = binarySearchChecked(data, target, midpoint + 1, max, comparisons + 1).getIndex(); 
		}
		else
		{
			if (min <= midpoint - 1)
				indexOfFoundItem = binarySearchChecked(data, target, min, midpoint - 1, comparisons + 1).getIndex();
		}
		comparisons++;
		if (indexOfFoundItem == -1 && (min == max))
		{
			System.out.print("binarySearch didn't find ");
			if (target.toString().length() < 2) System.out.print(" ");
			System.out.print(target + "\t        after ");
			if (comparisons < 10) System.out.print(" ");
			System.out.println((comparisons) + " comparisons.");
		}
		return new SearchResult(indexOfFoundItem, comparisons);
	}
	
	public static class SearchResult
	{
		private int _index;
		private int _comparisons;

		public SearchResult(int index, int comparisons)
		{
			_index = index;
			_comparisons = comparisons;
		}
		
		public int getIndex() {return _index;}
		public int getComparisons() {return _comparisons;}
		public void setIndex(int index) {_index = index;}
		
		public void incrementComparisons() {++_comparisons;}
	}
}
