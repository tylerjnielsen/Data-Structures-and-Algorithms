import DSandAlgos.LinkedMinHeap;
public class Tests
{
	public static void main(String[] args)
	{
		LinkedMinHeap<Integer> heap = new LinkedMinHeap<>();
		
		for (int i = 10; i > 0; --i)
			heap.addElement(i);
		
		heap.removeMin();
		heap.removeMin();
		heap.removeMin();
		heap.removeMin();
		System.out.println(heap);
		
	}
	
	public static long factorial(long n)
	{
		if (n == 1 || n == 0)
			return 1;
		return n * factorial(n-1);
	}
	
	public static long choose(long n, long k)
	{
		if (k > n) return 0;
		return (factorial(n) / (factorial(n-k) * factorial(k)));
	}
}
