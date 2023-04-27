package DSandAlgos;

public interface IList<T> extends ICollections, Iterable<T>
{
	public T remove(T element) throws IllegalArgumentException;
	
	public boolean contains(T element) throws IllegalArgumentException;
}
