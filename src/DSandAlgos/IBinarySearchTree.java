package DSandAlgos;

public interface IBinarySearchTree<T extends Comparable<T>> extends IBinaryTree<T>
{
	public void addElement(T element) throws IllegalArgumentException;
	
	public T removeElement(T targetElement) throws IllegalArgumentException;
	
	public void removeAllOccurrences(T targetElement) throws IllegalArgumentException;
}
