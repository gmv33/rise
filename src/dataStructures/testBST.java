package dataStructures;

import dataStructures.BSTOperations.traversals;

public class testBST
{
	public static void main(String[] args)
	{
		BSTOperations bst = new BSTOperations();
		int[] bookkeeping = new int[100];
		
		int randomNumber;
		int randomIndex;
		
		for(int i=0;i<100;i++)
		{
			randomNumber = (int)Math.floor(Math.random()*100);
			bst.insertNode(randomNumber);
			bookkeeping[i] = randomNumber;
		}
		
		for(int i=0;i<10;i++)
		{
			randomIndex = (int)Math.floor(Math.random()*(100-i));
			randomNumber = bookkeeping[randomIndex];
			bookkeeping[randomIndex] = bookkeeping[bookkeeping.length-i-1];
			bookkeeping[bookkeeping.length-i-1] = randomNumber;
			bst.removeNode(randomNumber);
		}
		
		System.out.println("Contents of the BST In_Order are: ");
		bst.printTree(traversals.IN_ORDER);
		
		System.out.println("Contents of the BST Pre_Order are: ");
		bst.printTree(traversals.PRE_ORDER);
		
		System.out.println("Contents of the BST Post_Order are: ");
		bst.printTree(traversals.POST_ORDER);
		
	}
}
