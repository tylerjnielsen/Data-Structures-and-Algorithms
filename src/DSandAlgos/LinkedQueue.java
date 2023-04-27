package DSandAlgos;

public class LinkedQueue<T> implements IQueue<T> 
{
	private int _count;
	private ForwardLinkNode<T> _head; // could be called _front
	private ForwardLinkNode<T> _tail; // could be called _rear
	
	public LinkedQueue()
	{
		_count = 0;
		_head = null;
		_tail = null;
	}
	
	@Override
	public int size()
	{
		return _count;
	}

	@Override
	public boolean isEmpty()
	{
		return _count <= 0;
	}

	@Override
	public void enqueue(T element) throws IllegalArgumentException 
	{
		if (element == null) throw new IllegalArgumentException("element cannot be null");
		
		ForwardLinkNode<T> node = new ForwardLinkNode<>(element);
		
		if(isEmpty())
			_head = node;
		else
			_tail.setNext(node);
		
		_tail = node;
		
		++_count;
	}

	@Override
	public T dequeue() throws EmptyCollectionException
	{
		if (isEmpty()) throw new EmptyCollectionException();
		
		T result = _head.getElement();
		
		_head = _head.getNext();
		--_count;
		
		if(isEmpty()) _tail = null;
		
		return result;
	}

	@Override
	public T first() throws EmptyCollectionException 
	{
		if (isEmpty()) throw new EmptyCollectionException();
		
		return _head.getElement();
	}
	
	public String toString()
	{
		String output = "[ ";
		
		ForwardLinkNode<T> current = _head;
		
		while (current != null)
		{
			output += current.getElement() + " ";
			current = current.getNext();
 		}
		
		return output + "]";
		
	}

}
