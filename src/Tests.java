import java.math.BigInteger;
import java.util.Arrays;
public class Tests
{
	public static void main(String[] args)
	{
		int tot=0;
		for (int i = 1; i <= 3000; ++i)
		{
			if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0)
				++tot;
		}
		System.out.println(tot);
	}
	public static long seq1(long n)
	{
		if (n == 1)
			return 1;
		return seq1(n - 1) + 5*n;
	}
	public static long seq2(long n)
	{
		return 5*((n*(n+1))/2) - 4;
	}
	
	public static long factorial(long n)
	{
		if (n <= 1)
			return 1;
		return n * factorial(n-1);
	}
	
	public static long choose(long n, long k)
	{
		if (k > n) return 0;
		return (factorial(n) / (factorial(n-k) * factorial(k)));
	}
	
	public static int romanToNumbers(String s)
	{
		int total = 0;
		int prevValue = 0;
		
		for (int i = s.length() - 1; i >= 0; --i)
		{
			char currentChar = s.charAt(i);
			int currentValue = romanCharToValue(currentChar);
			if (currentValue < prevValue)
				total -= currentValue;
			else
			{
				total += currentValue;
				prevValue = currentValue;
			}
		}
		
		return total;
	}
	
	public static int romanCharToValue(char romanChar)
	{
		switch(romanChar)
		{
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return 0;
		}
	}
	
    public static String longestCommonPrefix(String[] strs)
	{
	    if (strs.length == 0)
	        return "";
	    String firstWord = strs[0];
	    String currentLongestPrefix = firstWord;
	    for (int i = 1; i < strs.length; ++i)
	    {
            if (strs[i].length() == 0)
                return "";
            String shortest = strs[i];
            String longest = currentLongestPrefix;
            if (currentLongestPrefix.length() < strs[i].length())
            {
                shortest = currentLongestPrefix;
                longest  = strs[i];
            }
            inner_loop:
            for (int j = shortest.length() - 1; j >= 0; --j)
            {
                if (longest.substring(0, j + 1).equals(shortest.substring(0, j + 1)))
                {
                    currentLongestPrefix = shortest.substring(0, j + 1);
                    break inner_loop;
                }
                currentLongestPrefix = "";
            }
        }
        return currentLongestPrefix;  
    }
    
    public static int removeDuplicates(int[] nums)
    {
        int count = nums.length;
        for (int i = 0; i < nums.length - 1; ++i)
        {
        	if (nums[i] == Integer.MAX_VALUE)
        	{
        		Arrays.sort(nums);
        		return count;
        	}
            for (int j = i + 1; j < nums.length; ++j)
            {
                if (nums[i] == nums[j])
                {
                    count--;
                    nums[j] = Integer.MAX_VALUE;
                    continue;
                }
                else
                {
                    i = j - 1;
                    break;
                }
            }
        }
        Arrays.sort(nums);
        return count;
    }
    public static int strStr(String haystack, String needle) 
    {
        if (needle.length() == 0 || needle.length() > haystack.length())
            return -1;
        char start = needle.charAt(0);
        for (int i = 0; i < haystack.length(); ++i)
        {
        	//String tempstack = haystack.substring(i, i + needle.length());
            if (haystack.substring(i).length() >= needle.length() && haystack.charAt(i) == start && haystack.substring(i, i + needle.length()).equals(needle))
                return i;	
        }
        return -1;
    }
    public static int searchInsert(int[] nums, int target)
    {
        return searchInsertChecked(nums, target, 0, nums.length - 1);
    }
    private static int searchInsertChecked(int[] nums, int target, int min, int max) 
    {
        int indexOfTarget = -1;
        int midpoint = (min + max) / 2;
        if (target == nums[midpoint])
            return midpoint;
        boolean comp = target > midpoint;
        if (comp)
        {
            if (midpoint + 1 <= max)
                indexOfTarget = searchInsertChecked(nums, target, midpoint + 1, max);
        }
        else
        {
            if (min <= midpoint - 1)
                indexOfTarget = searchInsertChecked(nums, target, min, midpoint - 1);
        }
        return indexOfTarget;
    }
    public static String addBinary(String a, String b) 
    {
        String shorter = a;
        String longer = b;
        if (a.length() > b.length())
        {
            shorter = b;
            longer = a;
        }
        int fill = longer.length() - shorter.length();
        String stringZeroes = "0";
        for (int i = 1; i < fill; ++i)
            stringZeroes += "0";
        shorter = stringZeroes + shorter;
        String result = "";
        int addNext = 0;
        for (int i = longer.length() - 1; i >= 0; --i)
        {
            int alignSum = Character.getNumericValue(longer.charAt(i)) + Character.getNumericValue(shorter.charAt(i)) + addNext;
            addNext = 0;
            switch (alignSum)
            {
                case 0:
                    result += "0";
                case 1:
                    result += "1";
                default:
                    result += "0";
                    addNext = 1;
            }
        }
        StringBuilder reverser = new StringBuilder(result);
        result = reverser.reverse().toString();
        return result;
    }
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        
        return result;
    }
}
