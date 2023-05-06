package DSandAlgos;
import java.util.Iterator;

public interface IBinaryTree<T> extends ICollection, Iterable<T>
{
	public T getRootElement();
	
	public boolean contains(T targetElement) throws IllegalArgumentException;
	
	public T find(T targetElement) throws IllegalArgumentException;
	
	public Iterator<T> iteratorInOrder();
	
	public Iterator<T> iteratorPreOrder();
	
	public Iterator<T> iteratorPostOrder();
}
