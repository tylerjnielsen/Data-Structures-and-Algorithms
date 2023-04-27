import DSandAlgos.Search;
public class SearchTest {

	public static void main(String[] args)
	{
		Integer[] pool = {1, 4, 7, 12, 16, 23, 25, 28, 35, 42, 43, 52, 55, 57, 65, 66, 70, 73, 76, 78, 88, 93, 95};
		
		int target = 25;
		
		int indexOfTarget = Search.linearSearch(pool, target);
		
		System.out.println(indexOfTarget);
		
		indexOfTarget = Search.binarySearch(pool, target);
		
		System.out.println(indexOfTarget);

	}

}
