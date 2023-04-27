package DSandAlgos;

public class LinkedBinarySearchTree<T extends Comparable<T>>
	extends LinkedBinaryTree<T, BinaryTreeNode<T>>
	implements IBinarySearchTree<T>
{
	
	public LinkedBinarySearchTree()
	{
		super();
	}
	
	public LinkedBinarySearchTree(T element)
	{
		super(new BinaryTreeNode<>(element));
	}
	
	@Override
	public void addElement(T element) throws IllegalArgumentException
	{
		if (element == null)
			throw new IllegalArgumentException("element cannot be null");
		
		if (isEmpty())
			_root = new BinaryTreeNode<>(element);
		else
			addElement(element, _root);
	}
	
	private void addElement(T element, BinaryTreeNode<T> node)
	{
		if (element.compareTo(node.getElement()) < 0)
		{
			if (node.getLeft() == null)
				node.setLeft(new BinaryTreeNode<>(element));
			else
				addElement(element, node.getLeft());
		}
		else
		{
			if (node.getRight() == null)
				node.setRight(new BinaryTreeNode<>(element));
			else
				addElement(element, node.getRight());
		}
	}
	
	@Override
	public T removeElement(T targetElement) throws IllegalArgumentException
	{
		if (targetElement == null)
			throw new IllegalArgumentException("element cannot be null");
		
		T result = null;
		
		if (targetElement.equals(_root.getElement()))
		{
			result = _root.getElement();
			BinaryTreeNode<T> temp = findReplacement(_root);
			
			if (temp == null)
				_root = null;
			else
			{
				_root.setElement(temp.getElement());
				_root.setRight(temp.getRight());
				_root.setLeft(temp.getLeft());
			}
		}
		else
		{
			BinaryTreeNode<T> parent = _root;
			if (targetElement.compareTo(_root.getElement()) < 0)
				result = removeElement(targetElement, _root.getLeft(), parent);
			else
				result = removeElement(targetElement, _root.getRight(), parent);
		}
		
		return result;
	}
	
	private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent)
	{
		if (node == null)
			return null;
		
		T result = null;
		
		if (targetElement.equals(node.getElement()))
		{
			result = node.getElement();
			BinaryTreeNode<T> temp = findReplacement(node);
			if (parent.getRight() == node)
				parent.setRight(temp);
			else
				parent.setLeft(temp);
		}
		else
		{
			parent = node;
			if (targetElement.compareTo(node.getElement()) < 0)
				result = removeElement(targetElement, node.getLeft(), parent);
			else
				result = removeElement(targetElement, node.getRight(), parent);
		}
		
		return result;
	}
	
	private BinaryTreeNode<T> findReplacement(BinaryTreeNode<T> node)
	{
		BinaryTreeNode<T> result = null;
		
		if (node.getLeft() == null && node.getRight() == null)
		{
			result = null;
		}
		else if (node.getLeft() != null && node.getRight() == null)
		{
			result = node.getLeft();
		}
		else if (node.getLeft() == null && node.getRight() != null)
		{
			result = node.getRight();
		}
		else
		{
			BinaryTreeNode<T> parent = node;
			BinaryTreeNode<T> current = node.getRight();
			while (current.getLeft() != null)
			{
				parent = current;
				current = current.getLeft();
			}
			current.setLeft(node.getLeft());
			if (node.getRight() != current)
			{
				parent.setLeft(current.getRight());
				current.setRight(node.getRight());
			}
			result = current;
		}
		
		return result;
	}
	
	@Override
	public T find(T targetElement) throws IllegalArgumentException
	{
		if (targetElement == null)
			throw new IllegalArgumentException("element cannot be null");
		
		BinaryTreeNode<T> current = findNode(targetElement, _root);
		
		if (current == null)
			return null;
		
		return current.getElement();
	}
	
	private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next)
	{
		if (next == null)
			return null;
		
		int compareResult = targetElement.compareTo(next.getElement());
		
		if (compareResult == 0)
			return next;
		else if (compareResult < 0)
			return findNode(targetElement, next.getLeft());
		else
			return findNode(targetElement, next.getRight());
	}

	@Override
	public void removeAllOccurrences(T targetElement) throws IllegalArgumentException
	{
		if (targetElement == null)
			throw new IllegalArgumentException("target element cannot be null");
		while(contains(targetElement))
			removeElement(targetElement);
	}
	
}
