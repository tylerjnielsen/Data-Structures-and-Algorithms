import DSandAlgos.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class RepeatingKeyCipher
{
	public static void main(String[] args) 
	{
		String selection = "";
		
		while (!selection.equals("3"))
		{
			selection = "";
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3"))
			{
				System.out.println("1.) Encode a message.\n2.) Decode a message.\n3.) Exit");
				System.out.println("----------------------------");
				System.out.print("Select 1, 2, or 3: ");
				selection = input.nextLine();
				try
				{
					int selected = Integer.parseInt(selection);
					if (selected > 0 && selected < 4) break;
				}
				catch (Exception e)
				{
					System.out.println("\nInvalid selection. Please try again.\n");
					continue;
				}
				System.out.println("\nInvalid selection. Please try again.\n");
			}
			
			if (selection.equals("3"))
			{
				System.out.println("\nGoodbye!");
				System.exit(0);	
			}
			
			System.out.print("\nEnter the key: ");
			String key = input.nextLine();
			System.out.print("\nEnter the message: ");
			String message = input.nextLine();
			
			StringTokenizer st = new StringTokenizer(key);
			
			LinkedQueue<Integer> queue = new LinkedQueue<>();
			
			while (st.hasMoreElements())
			{
				queue.enqueue(Integer.parseInt(st.nextToken()));
			}
			
			String output = "";
			
			if (selection.equals("1"))
			{
				for (int i = 0; i < message.length() ; ++i)
				{
					int current = queue.dequeue();
					queue.enqueue(current);
					output += (char)(message.charAt(i) + current);
				}
			}
			else if (selection.equals("2"))
			{
				for (int i = 0; i < message.length(); ++i)
				{
					int current = queue.dequeue();
					queue.enqueue(current);
					output += (char)(message.charAt(i) - current);
				}
			}
			System.out.println("\n"+output+"\n");
		}
	}
}
