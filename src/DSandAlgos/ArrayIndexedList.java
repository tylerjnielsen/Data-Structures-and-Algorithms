package DSandAlgos;

public class ArrayIndexedList<T> extends ArrayList<T> implements IIndexedList<T>
{

	@Override
	public void add(T element) throws IllegalArgumentException 
	{
		if (element == null) throw new IllegalArgumentException("element cannot be null");
		
		ensureCapacity();
		
		_list[_rear] = element;
		++_rear;
		++_modCount;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException 
	{
		if (element == null) throw new IllegalArgumentException("element cannot be null");
		
		if (index < 0 || index >= _rear) throw new IndexOutOfBoundsException();
		
		ensureCapacity();
		
		T[] temp = (T[]) new Object[_list.length];
		
		for (int i = 0; i < index; ++i)
		{
			temp[i] = _list[i];
		}
		temp[index] = element;
		for (int i = index+1; i <= size(); ++i)
		{
			temp[i] = _list[i-1];
		}
		
		_list = temp;
		
		++_modCount;
		++_rear;
		
	}

	@Override
	public void set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException 
	{
		if (element == null) throw new IllegalArgumentException("element cannot be null");
		
		if (index < 0 || index >= _rear) throw new IndexOutOfBoundsException();
		
		_list[index] = element;
		
		++_modCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removeAt(int index) throws IndexOutOfBoundsException 
	{
		if (index < 0 || index >= _rear) throw new IndexOutOfBoundsException();
		
		T[] temp = (T[]) new Object[_list.length - 1];
		
		T element = _list[index];
		
		for (int i = 0; i < index; ++i)
		{
			temp[i] = _list[i];
		}
		for (int i = index + 1; i < size(); ++i)
		{
			temp[i - 1] = _list[i];
		}
		
		_list = temp;
		
		++_modCount;
		--_rear;
		
		return element;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException 
	{
		if (index < 0 || index >= _rear) throw new IndexOutOfBoundsException();
		
		return _list[index];
	}

	@Override
	public int indexOf(T element) throws IllegalArgumentException 
	{
		if (element == null) throw new IllegalArgumentException("element cannot be null");
		
		for (int i = 0; i < size(); ++i)
		{
			if (element.equals(_list[i])) return i;
		}
		
		return -1;
	}
	
	public String toString()
	{
		String output = "[ ";
		
		for (int i = 0; i < size(); ++i)
		{
			output += _list[i] + " ";
		}
		
		return output + "]";
	}

}
