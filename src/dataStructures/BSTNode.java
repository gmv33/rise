package dataStructures;

public class BSTNode
{
	int data;
	BSTNode left;
	BSTNode right;
	BSTNode parent;
	
	public BSTNode()
	{
		this.left = this.right = this.parent = null;
	}
	
	public BSTNode(int data)
	{
		this.data = data;
		this.left = this.right = this.parent = null;
	}
	
	public BSTNode(BSTNode node)
	{
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
		this.parent = node.parent;
	}
}
