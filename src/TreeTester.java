import java.util.Iterator;

import DSandAlgos.*;
public class TreeTester {

	public static void main(String[] args) 
	{
		
		BinaryTreeNode<Integer>  node_1 = new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer>  node_2 = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer>  node_3 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer>  node_4 = new BinaryTreeNode<Integer>(4);
		BinaryTreeNode<Integer>  node_5 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer>  node_6 = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer>  node_7 = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer>  node_8 = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer>  node_9 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> node_10 = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> node_11 = new BinaryTreeNode<Integer>(11);
		BinaryTreeNode<Integer> node_12 = new BinaryTreeNode<Integer>(12);
		BinaryTreeNode<Integer> node_13 = new BinaryTreeNode<Integer>(13);
		BinaryTreeNode<Integer> node_14 = new BinaryTreeNode<Integer>(14);
		BinaryTreeNode<Integer> node_15 = new BinaryTreeNode<Integer>(15);
		
		LinkedBinaryTree<Integer, BinaryTreeNode<Integer>> intTree = new LinkedBinaryTree<>(node_8);
		
		node_8.setLeft(node_4);
		node_4.setLeft(node_2);
		node_2.setLeft(node_1);
		node_2.setRight(node_3);
		node_4.setRight(node_6);
		node_6.setLeft(node_5);
		node_6.setRight(node_7);
		node_8.setRight(node_12);
		node_12.setLeft(node_10);
		node_10.setLeft(node_9);
		node_10.setRight(node_11);
		node_12.setRight(node_14);
		node_14.setLeft(node_13);
		node_14.setRight(node_15);
		
		System.out.println(intTree);
		System.out.println("\nTree Height ..: " + intTree.getHeight());
		System.out.println("Tree Size ....: " + intTree.size());
		
		Iterator<Integer> it_pre = intTree.iteratorPreOrder();
		Iterator<Integer> it_post = intTree.iteratorPostOrder();
		Iterator<Integer> it_in = intTree.iterateInOrder();
		
		System.out.println("\nPre-order: ");
		while (it_pre.hasNext())
			System.out.print(it_pre.next() + " ");
		System.out.println();
		
		System.out.println("Post-order: ");
		while (it_post.hasNext())
			System.out.print(it_post.next() + " ");
		System.out.println();
		
		System.out.println("In-order: ");
		while (it_in.hasNext())
			System.out.print(it_in.next() + " ");
		System.out.println();
	}

}
