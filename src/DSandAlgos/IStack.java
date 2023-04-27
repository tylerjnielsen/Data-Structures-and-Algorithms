package DSandAlgos;

public interface IStack<T> extends ICollections
{
	public void push(T element) throws IllegalArgumentException;
	
	public T pop() throws EmptyCollectionException;
	
	public T peek() throws EmptyCollectionException;
}
