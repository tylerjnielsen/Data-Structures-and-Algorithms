import java.util.Scanner;
import DSandAlgos.*;
public class IntersectionLaneSimulator
{

	public static void main(String[] args) 
	{		
		int simulationDuration;
		int greenDuration;
		int redDuration;
		int rateOfArrival;
		int rateOfPassing;
		
		while (true)
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			try
			{
				System.out.print("Enter the duration for the simulation.: ");
				simulationDuration = input.nextInt();
				System.out.print("Enter the duration of the green light.: ");
				greenDuration = input.nextInt();
				System.out.print("Enter the duration of the red light...: ");
				redDuration = input.nextInt();
				System.out.print("Enter the rate of cars arriving.......: ");
				rateOfArrival = input.nextInt();
				System.out.print("Enter the rate of cars passing through: ");
				rateOfPassing = input.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("Invalid response. Please try again.");
				continue;
			}
			if (simulationDuration < 1 || greenDuration < 1 || redDuration < 1 || rateOfArrival < 1 || rateOfPassing < 1)
			{
				System.out.println("Invalid response. Please try again.");
				continue;
			}
			break;
		}
		
		LinkedQueue<Integer> cars = new LinkedQueue<>();
		boolean isGreen = false;
		int secondsSinceChange = 0;
		for (int i = 0; i <= simulationDuration; ++i)
		{
			if (secondsSinceChange == greenDuration && i != 0 && isGreen)
			{
				isGreen = false;
				System.out.print("[      ");
				if (i < 10) System.out.print(" ");
				System.out.println(i+"] The light has turned from green to red.");
				secondsSinceChange = 0;
			}
			if (secondsSinceChange % rateOfPassing == 0 && i != 0 && !cars.isEmpty() && isGreen)
			{
				cars.dequeue();
				System.out.print("[      ");
				if (i < 10) System.out.print(" ");
				System.out.println(i+"] A car has passed through the intersection.");
			}
			if (secondsSinceChange == redDuration && i != 0 && !isGreen)
			{
				isGreen = true;
				System.out.print("[      ");
				if (i < 10) System.out.print(" ");
				System.out.println(i+"] The light has turned from red to green.");
				secondsSinceChange = 0;
			}
			if (i % rateOfArrival == 0 && i != 0)
			{
				cars.enqueue(cars.size()+1);
				System.out.print("[      ");
				if (i < 10) System.out.print(" ");
				System.out.println(i+"] A car has arrived.");
			}
			secondsSinceChange++;
		}
			
		System.out.println("[Finished] " + cars.size() + " cars are currently in the lane.");
		
	}

}
