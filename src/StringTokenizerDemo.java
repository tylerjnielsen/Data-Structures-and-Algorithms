

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerDemo 
{
	public static void main(String[] args) 
	{
		System.out.print("Enter something (with multiple spaces): ");
		Scanner kbd = new Scanner(System.in);
		String userResponse = kbd.nextLine();
		kbd.close();
		
		StringTokenizer st = new StringTokenizer(userResponse);
		
		while (st.hasMoreTokens())
		{
			String token = st.nextToken();
			System.out.println("Token: " + token);
		}

	}
}
