import java.util.Scanner;
import java.util.StringTokenizer;

import DSandAlgos.*;

public class PostfixEvaluator
{

	public static void main(String[] args) 
	{
		ArrayStack<String> postFixStack = new ArrayStack<>();
		System.out.print("Enter an expression in postfix notation: ");
		Scanner input = new Scanner(System.in);
		String postFix = input.nextLine();
		input.close();
		StringTokenizer st = new StringTokenizer(postFix);
		while (st.hasMoreElements())
		{
			String token = st.nextToken();
			postFixStack.push(token);
			
			if (token.equals("+"))
			{
				postFixStack.pop();
				postFixStack.push("" + (Integer.parseInt(postFixStack.pop()) + Integer.parseInt(postFixStack.pop())));
			}
			if (token.equals("-"))
			{
				postFixStack.pop();
				postFixStack.push("" + -(Integer.parseInt(postFixStack.pop()) - Integer.parseInt(postFixStack.pop())));
			}
			if (token.equals("/"))
			{
				postFixStack.pop();
				int b = Integer.parseInt(postFixStack.pop());
				int a = Integer.parseInt(postFixStack.pop());
				postFixStack.push("" + (a / b));
			}
			if (token.equals("*"))
			{
				postFixStack.pop();
				postFixStack.push("" + (Integer.parseInt(postFixStack.pop()) * Integer.parseInt(postFixStack.pop())));
			}
		}
		
		System.out.println("The result of that calculation is......: " + postFixStack.peek());

	}

}
