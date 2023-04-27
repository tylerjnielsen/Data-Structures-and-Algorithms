import DSandAlgos.SearchingEx;
import DSandAlgos.SearchingEx.SearchResult;
public class CompareSearchStrategies
{
	public static void main(String[] args) 
	{
		Integer[] arrayOfIntegers = {2, 4, 6, 7, 16, 19, 25, 30, 31, 39, 41, 52, 
							         55, 70, 75, 80, 81, 83, 88, 90, 94, 97, 98};
		
		Integer[] searchFor = {52, 19, 6, 2, 4, 5};

		for (int i = 0; i < searchFor.length; ++i)
			SearchingEx.binarySearch(arrayOfIntegers, searchFor[i]);
		
		System.out.println();	
		
		for (int i = 0; i < 6; ++i)
		{
			SearchResult s = SearchingEx.linearSearch(arrayOfIntegers, searchFor[i]);
			
			if (s.getIndex() != -1)
			{
				System.out.print("linearSearch found\t ");
				if (searchFor[i] < 10) System.out.print(" ");
				System.out.print(searchFor[i] + " at index ");
				if (s.getIndex() < 10) System.out.print(" ");
				System.out.print(s.getIndex() + " after ");
			}
			else
			{
				System.out.print("linearSearch didn't find ");
				if (searchFor[i] < 10) System.out.print(" ");
				System.out.print(searchFor[i] + "\t\tafter ");
			}
			if (s.getComparisons() < 10) System.out.print(" ");
			System.out.println(s.getComparisons() + " comparisons.");	
		}
	}
}
