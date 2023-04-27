package DSandAlgos;

public class BinaryTreeNode<T>
{
	protected T 					_element        ;
	protected BinaryTreeNode<T> 	_left 	  = null;
	protected BinaryTreeNode<T> 	_right	  = null;
	
	public BinaryTreeNode(T element)
	{
		_element = element;
	}
	public T getElement() 			  {return _element;}
	public void setElement(T element) {_element = element;}
	
	public BinaryTreeNode<T> getRight() 					  {return _right;}
	public void 			 setRight(BinaryTreeNode<T> node) {_right = node;}
	public BinaryTreeNode<T> getLeft() 						  {return _left ;}
	public void 			 setLeft (BinaryTreeNode<T> node) { _left = node;}
	
	public int numChildren()
	{
		int children = 0;
		if (_left != null)
			children += 1 + _left.numChildren();
		if (_right != null)
			children += 1 + _right.numChildren();
		return children;
	}
}
