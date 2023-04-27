import java.util.LinkedList;
public class RadixSort {

	public static void main(String[] args) 
	{
		Integer[] list = {7843, 4568, 8765, 6543, 7865, 4532, 9987,
				3241, 6589, 6622, 1211, 7777};
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] digitQueues = (LinkedList<Integer>[])new LinkedList[10];
		
		for (int i = 0; i < digitQueues.length; ++i)
			digitQueues[i] = new LinkedList<Integer>();
		
		for (int i = 0; i < 4; ++i)
		{
			for (int j = 0; j < list.length ; ++j)
			{
				String temp = String.valueOf(list[j]);
				int digit = Character.digit(temp.charAt(3 - i), 10);
				digitQueues[digit].add(list[j]);
			}
			
			int num = 0;
			for (int j = 0; j < digitQueues.length; ++j)
			{
				while (!(digitQueues[j].isEmpty()))
				{
					list[num] = digitQueues[j].remove();
					++num;
				}
			}
		}
		
		for (int i = 0; i < list.length; ++i)
		{
			System.out.println(list[i]);
		}
	}

}
