import DSandAlgos.*;

public class StackTester 
{

	public static void main(String[] args) 
	{
		LinkedStack<Integer> linkBased = new LinkedStack<>();
		ArrayStack<Integer> arrayBased = new ArrayStack<>();
		
		Exercise(linkBased);
		System.out.println();
		Exercise(arrayBased);

	}
	
	private static void Exercise(IStack<Integer> soi)
	{
		soi.push(1);
		soi.push(2);
		soi.push(3);
		System.out.println(soi);
		System.out.println(soi.pop());
		System.out.println(soi);
		System.out.println(soi.pop());
		System.out.println(soi);
		System.out.println(soi.pop());
		System.out.println(soi);
		soi.push(1);
		System.out.println(soi);
	}
	
}
