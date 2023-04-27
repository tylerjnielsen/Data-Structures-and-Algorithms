import java.util.Scanner; import java.util.StringTokenizer;

import DSandAlgos.*;
public class PostfixToInfixTranslator
{

	public static void main(String[] args) 
	{
		LinkedStack<String> postFixStack = new LinkedStack<>();
		System.out.print("Enter an expression in postfix notation: ");
		Scanner input = new Scanner(System.in);
		String postFix = input.nextLine();
		input.close();
		StringTokenizer st = new StringTokenizer(postFix);
		while (st.hasMoreElements())
		{
			String token = st.nextToken();
			postFixStack.push(token);
			if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*"))
			{
				postFixStack.pop();
				String b = postFixStack.pop();
				String a = postFixStack.pop();
				postFixStack.push("(" + a + token + b + ")");
			}
		}
		System.out.println("Expressed with infix notation that is..: " + postFixStack.peek());
	}

}
