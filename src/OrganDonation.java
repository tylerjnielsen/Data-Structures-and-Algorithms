import java.util.Scanner;
import DSandAlgos.*;
public class OrganDonation
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		ArrayIndexedList<Human> needed = new ArrayIndexedList<>();
		ArrayIndexedList<Human> donated = new ArrayIndexedList<>();
		while (true)
		{
			System.out.println("1.) Register organ needed.\n2.) Register organ donated.\n3.) Exit");
			System.out.println("----------------------------");
			System.out.print("Select 1, 2 or 3: ");
			
			String selection = input.nextLine();
			
			if (selection.equals("1"))
			{
				System.out.print("\nFor who? ");
				String who = input.nextLine();
				System.out.print("\nWhat organ? ");
				String organ = input.nextLine();
				System.out.println();
				needed.add(new Human(who, organ));				
			}
			else if (selection.equals("2"))
			{
				System.out.print("\nBy who? ");
				String who = input.nextLine();
				System.out.print("\nWhat organ? ");
				String organ = input.nextLine();
				System.out.println();
				donated.add(new Human(who, organ));
			}
			else if (selection.equals("3"))
			{
				break;
			}
			else
			{
				System.out.println("\nInvalid selection. Please try again.\n");
				continue;
			}
			Human[] match = findMatch(needed, donated);
			if (match[0] != null && match[1] != null)
			{
				System.out.println(match[1].getName()+"'s " +match[1].getOrgan()+" was given to "+match[0].getName()+".\n");
				needed.remove(match[0]);
				donated.remove(match[1]);
			}
		}
		System.out.println("\nGoodbye!");
		input.close();
	}
	private static Human[] findMatch(ArrayIndexedList<Human> needed, ArrayIndexedList<Human> donated)
	{
		Human[] match = new Human[2];
		for (Human patient : needed)
		{
			for (Human donor : donated)
			{
				if (patient.getOrgan().equals(donor.getOrgan()))
				{
					match[0] = patient;
					match[1] = donor;
					return match;
				}
			}
		}
		return match;
	}
	private static class Human
	{
		String _name;
		String _organ;
		
		public Human(String name, String neededOrgan)
		{
			_name = name;
			_organ = neededOrgan;
		}
		public String getName()
		{
			return _name;
		}
		public String getOrgan()
		{
			return _organ;
		}
		public String toString()
		{
			return "("+_name+": "+_organ+")";
		}
	}
}
