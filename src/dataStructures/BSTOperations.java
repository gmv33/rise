package dataStructures;

/**
 * This class will do the following - 1. Insert operation 2. Remove 3. In Order
 * Traversal 4. Pre Order Traversal 5. Post Order Traversal
 * 
 * @author GVARMA
 * @version 1.0
 */

/*
 * BST can be analyzed as an array. if n is root; 2n+1 is the left child 2n + 2
 * is the right child (n-1)/2 is the parent node
 */
public class BSTOperations
{
	public enum traversals {
		PRE_ORDER, IN_ORDER, POST_ORDER
	}

	BSTNode root=null;

	public boolean insertNode(int data)
	{
		BSTNode newNode=new BSTNode(data);
		if(root==null)
		{
			root=newNode;
		}
		else
		{
			BSTNode temp=root;
			while(temp!=null)
			{
				if(data<temp.data)
				{
					if(temp.left!=null)
						temp=temp.left;
					else
					{
						temp.left=newNode;
						newNode.parent=temp;
						break;
					}
				}
				else
				{
					if(temp.right!=null)
						temp=temp.right;
					else
					{
						temp.right=newNode;
						newNode.parent=temp;
						break;
					}
				}
			}
		}
		return true;
	}

	public boolean removeNode(int data)
	{
		BSTNode temp=root;

		while(temp!=null)
		{
			if(temp.data==data)
			{
				if(temp.left==null&&temp.right==null)
				{
					if(temp.parent!=null)
					{
						// leaf node
						if(temp.parent.left==temp)
						{
							// node is parent's left child
							temp.parent.left=null;
						}
						else
						{
							// node is parent's right child
							temp.parent.right=null;
						}
					}
					else
					{
						root=null;
					}
				}
				else if(temp.left==null)
				{
					// only right child exists
					if(temp.parent!=null)
					{
						if(temp.parent.left==temp)
						{
							temp.parent.left=temp.right;
						}
						else
						{
							temp.parent.right=temp.right;
						}
					}
					else
					{
						temp.right.parent=null;
						root=temp.right;
					}
				}
				else if(temp.right==null)
				{
					if(temp.parent!=null)
					{
						// only left child exists
						if(temp.parent.left==temp)
						{
							temp.parent.left=temp.left;
						}
						else
						{
							temp.parent.right=temp.left;
						}
					}
					else
					{
						temp.left.parent=null;
						root=temp.left;
					}
				}
				else
				{

					// both children exist
					BSTNode min=temp.right;
					while(min.left!=null)
						min=min.left;

					if(min.parent.left==min)
					{
						if(min.right==null)
							min.parent.left=null;
						else
							min.parent.left=min.right;
					}
					else
					{
						if(min.right==null)
							min.parent.right=null;
						else
							min.parent.right=min.right;
					}
					min.parent=temp.parent;

					if(temp.parent!=null)
					{
						if(temp.parent.left==temp)
						{
							temp.parent.left=min;
						}
						else
						{
							temp.parent.right=min;
						}
					}
					else
					{
						root=min;
					}
					if(temp.left!=null)
						temp.left.parent=min;

					if(temp.right!=null)
						temp.right.parent=min;

					temp.left=null;
					temp.right=null;
				}
				break;
			}
			else
			{
				if(temp.data>data)
				{
					temp=temp.left;
				}
				else
				{
					temp=temp.right;
				}
			}
		}

		return true;
	}

	public void printTree(BSTOperations.traversals type)
	{
		switch(type)
		{
			case IN_ORDER:
				printInOrder(this.root);
				break;
			case POST_ORDER:
				printPostOrder(this.root);
				break;
			case PRE_ORDER:
				printPreOrder(this.root);
				break;
			default:
				System.out.println("Requested Format not recognized");
				break;
		}
	}

	public void printInOrder(BSTNode node)
	{
		if(node==null)
			return;
		printInOrder(node.left);
		System.out.print(node.data+",");
		printInOrder(node.right);
	}

	public void printPreOrder(BSTNode node)
	{
		if(node==null)
			return;
		System.out.print(node.data+",");
		printInOrder(node.left);
		printInOrder(node.right);
	}

	public void printPostOrder(BSTNode node)
	{
		if(node==null)
			return;
		printInOrder(node.left);
		printInOrder(node.right);
		System.out.print(node.data+",");
	}
}
