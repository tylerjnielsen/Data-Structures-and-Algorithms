import DSandAlgos.*;
public class ListTester
{

	public static void main(String[] args) 
	{
		ArrayIndexedList<Integer> lil = new ArrayIndexedList<>();
		
		for (String len = ""; len.length() < 5000; len += "a")
		{
			lil.add(2);
		}
		System.out.println(lil);
	}

}
