import java.util.Scanner;

import DSandAlgos.*;
public class KidneyDonation
{

	public static void main(String[] args) 
	{
		String selection = "";
		
		ArrayQueue<String> needed = new ArrayQueue<>();
		ArrayQueue<String> donated = new ArrayQueue<>();
		
		while (!selection.equals("3"))
		{
			selection = "";
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			while (!selection.equals("1") && !selection.equals("2") && !selection.equals("3"))
			{
				System.out.println("1.) Register kidney needed.\n2.) Register kidney donated.\n3.) Exit");
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
			else if (selection.equals("1"))
			{
				System.out.print("\nFor who? ");
				needed.enqueue(input.nextLine());
				System.out.println();
				if (!donated.isEmpty())
				{
					System.out.println(donated.dequeue() + "'s kidney was given to " + needed.dequeue() + "\n");
				}
			}
			else
			{
				System.out.print("\nBy who? ");
				donated.enqueue(input.nextLine());
				System.out.println();
				if (!needed.isEmpty())
				{
					System.out.println(donated.dequeue() + "'s kidney was given to " + needed.dequeue() + "\n");
				}
			}
		}

	}

}
