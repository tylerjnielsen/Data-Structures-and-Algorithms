import DSandAlgos.*;
public class HeapSort
{

	public static void main(String[] args) 
	{
		Integer[] numbers = {2, 8, 5, 6, 7, 4, 3, 1, 10, 9};
		
		System.out.println("Heap Sort Demo\n------------------------------------------");
		System.out.print("Pre-sort : [");
		for (int i = 0; i < numbers.length - 1; ++i)
			System.out.print(numbers[i] +", ");
		System.out.println(numbers[numbers.length - 1] + "]");
		
		LinkedMinHeap<Integer> heap = new LinkedMinHeap<>();
		
		for (int i = 0; i < numbers.length; ++i)
			heap.addElement(numbers[i]);
		
		for (int i = 0; i < numbers.length; ++i)
			numbers[i] = heap.removeMin();
		
		System.out.print("Post-sort: [");
		for (int i = 0; i < numbers.length - 1; ++i)
			System.out.print(numbers[i] +", ");
		System.out.println(numbers[numbers.length - 1] + "]");

	}

}
