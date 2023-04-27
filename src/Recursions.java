public class Recursions
{

	public static void main(String[] args) 
	{		
		System.out.println("Solving Towers of Hanoi with 3 discs:\n-------------------------------------");
		System.out.println("-------------------------------------\nTotal Moves: " + towersOfHanoi(0, 3, 1, 3, 2) + "\n");
		System.out.println("Solving Towers of Hanoi with 9 discs:\n-------------------------------------");
		System.out.println("-------------------------------------\nTotal Moves: " + towersOfHanoi(0, 9, 1, 3, 2) + "\n");
		System.out.println("The  5th Fibonacci number is     " + fibonacci(5) + ".");
		System.out.println("The 12th Fibonacci number is   " + fibonacci(12) + ".");
		System.out.println("The 18th Fibonacci number is  " + fibonacci(18) + ".");
	}
	
	public static int towersOfHanoi(int movesSoFar, int n, int origin, int destination, int auxiliary)
	{
		if (n == 1)
		{
			System.out.println("Move disc 1 from pole " + origin + " to pole " + destination);
			return 1;
		}
		int moves = towersOfHanoi(movesSoFar + 1, n - 1, origin, auxiliary, destination);
		System.out.println("Move disc " + n + " from pole " + origin + " to pole " + destination);
		moves += towersOfHanoi(movesSoFar + 1, n - 1, auxiliary, destination, origin);
		
		return moves + 1;
	}
	
	public static int fibonacci(int n)
	{
		if (n <= 1)
			return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
