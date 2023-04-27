

public class BinaryConverter
{
	public static long BinaryConversion(int number)
	{
		final int testNumber = number;
		int adjustableNumber = testNumber;
		int base = 2;
		String converted = "";
		while (adjustableNumber != 0)
		{
			converted += (adjustableNumber % base);
			adjustableNumber /= base;
		}
		return Long.parseLong(reverse(converted));
	}

	private static String reverse(String s)
	{
		String output = "";
		for (int i = s.length() - 1; i >= 0; --i)
		{
			output += s.charAt(i);
		}
		return output;
	}
}
