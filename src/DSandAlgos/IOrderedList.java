package DSandAlgos;

public interface IOrderedList<T extends Comparable<T>> extends IList<T>
{
	public void add(T element) throws IllegalArgumentException;
}
