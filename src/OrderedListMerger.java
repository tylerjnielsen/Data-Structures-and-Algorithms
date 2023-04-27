import java.util.Random;
import java.util.Scanner;

import DSandAlgos.*;
public class OrderedListMerger
{

	public static void main(String[] args) 
	{
		LinkedOrderedList<String> listOne = new LinkedOrderedList<>();
		LinkedOrderedList<String> listTwo = new LinkedOrderedList<>();
		
		String addition = "";
		
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.print("Enter a name (leave blank to proceed to merge phase): ");
			addition = input.nextLine();
			
			if (addition.equals("")) break;
			
			if (rand.nextBoolean())
			{
				listOne.add(addition);
			}
			else
			{
				listTwo.add(addition);
			}
		}
		while(!addition.equals(""));
		
		String output = "";
		
		while (!listOne.isEmpty() && !listTwo.isEmpty())
		{
			String oneRemove = "";
			String twoRemove = "";
			
			for (String name : listOne)
			{
				oneRemove = name;
				break;
			}
			for (String name : listTwo)
			{
				twoRemove = name;
				break;
			}
			if (oneRemove.compareTo(twoRemove) <= 0) output += listOne.remove(oneRemove) + " ";
			else output += listTwo.remove(twoRemove) + " ";
		}
		
		LinkedOrderedList<String> copy;
		
		if (listOne.size() > listTwo.size()) copy = listOne;
		else copy = listTwo;
		
		for (String name : copy)
		{
			output += name + " ";
		}
		
		System.out.println(output);	
		input.close();

	}

}
