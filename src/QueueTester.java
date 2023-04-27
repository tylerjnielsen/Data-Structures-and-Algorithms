
import DSandAlgos.*;

public class QueueTester 
{

	public static void main(String[] args) 
	{
		LinkedQueue<Integer> linkBased = new LinkedQueue<>();
		ArrayQueue<Integer> arrayBased = new ArrayQueue<>(2);
		
		Exercise(linkBased);
		
		Exercise(arrayBased);

	}
	
	private static void Exercise(IQueue<Integer> soi)
	{
		soi.enqueue(1);
		soi.enqueue(2);
		soi.enqueue(3);
		System.out.println(soi);
		System.out.println(soi.dequeue());
		System.out.println(soi);
		System.out.println(soi.dequeue());
		System.out.println(soi);
		System.out.println(soi.dequeue());
		System.out.println(soi);
		soi.enqueue(1);
		System.out.println(soi);
		System.out.println();
	}
	
}
