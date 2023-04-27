import java.util.Scanner; import java.util.StringTokenizer;

import DSandAlgos.*;
public class SentenceWordReverser
{

	public static void main(String[] args) 
	{
		ArrayStack<Character> letterStack = new ArrayStack<Character>();
		LinkedStack<String> wordStack = new LinkedStack<String>();
		
		System.out.print("Enter a sentence..............................: ");
		
		Scanner input = new Scanner(System.in);
		
		String sentence = input.nextLine();
		
		input.close();
		
		StringTokenizer st = new StringTokenizer(sentence);
		
		String reversedLetters = "";
		String reversedWords = "";
		
		while (st.hasMoreElements())
		{
			String token = st.nextToken();
			
			wordStack.push(token);
			
			for (int i = 0; i < token.length(); ++i)
			{
				letterStack.push(token.charAt(i));
			}
			while (!letterStack.isEmpty())
			{
				reversedLetters += letterStack.pop();
			}
			reversedLetters += " ";
		}
		
		while (!wordStack.isEmpty())
		{
			reversedWords += wordStack.pop() + " ";
		}
		
		System.out.println("Words in the same order, with letters reversed: " + reversedLetters);
		System.out.println("Words reversed, with letters in the same order: " + reversedWords);

	}

}
