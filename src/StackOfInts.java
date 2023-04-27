import java.util.Arrays;

public class StackOfInts 
{
	
	private final static int DEFAULT_CAPACITY = 100;
	
	private Integer[] _stack;
	private int _top;
	
	public StackOfInts()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public StackOfInts(int initialCapacity)
	{
		_top = 0;
		_stack = new Integer[initialCapacity];
	}
	
	public void push(Integer element)
	{
		ensureCapacity();
		_stack[_top] = element;
		_top++;
		
	}
	
	public Integer pop()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Stack is empty!");
		}
		_top--;
		Integer result = _stack[_top];
		_stack[_top] = null;
		return result;
	}
	
	public Integer peek()
	{
		if (isEmpty())
		{
			throw new RuntimeException("Stack is empty!");
		}
		Integer result = _stack[_top - 1];
		return result;
	}
	
	private void ensureCapacity()
	{
		if (size() >= _stack.length)
		{
			_stack = Arrays.copyOf(_stack, _stack.length * 2);
		}
	}
	
	public int size()
	{
		return _top;
	}
	
	public boolean isEmpty()
	{
		return _top <= 0;
	}
	
	public String toString()
	{
		String output = "[";
		for(int i = 0; i < _top ; ++i)
		{
			output += " " + _stack[i].toString() + " ";
		}
		
		return output + "]";
		
	}
}
