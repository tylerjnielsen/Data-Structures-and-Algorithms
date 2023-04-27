package DSandAlgos;

public interface IQueue<T> extends ICollections
{
	
	public void enqueue(T element) throws IllegalArgumentException;
	
	public T dequeue() throws EmptyCollectionException;
	
	public T first() throws EmptyCollectionException;
	
	
	
}
