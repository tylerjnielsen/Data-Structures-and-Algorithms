
public class Recursion 
{
	public static void main(String[] args) 
	{
		final int sumTo = 40;
		System.out.println(sum_recursive(sumTo));
		System.out.println(sum_iterative(sumTo));
		System.out.println(sum_explicit(sumTo));
		
	}
	private static int sum_recursive(int num)
	{
		if (num == 1)
			return 1;
		return num+sum_recursive(num-1);
	}
	private static int sum_iterative(int num)
	{
		int sum = 0;
		for (int i = 1 ; i <= num; ++i)
			sum += i;
		return sum;
	}
	private static int sum_explicit(int num)
	{
		return num*(num+1)/2;
	}	
}
