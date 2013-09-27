package dataStructures;

public class LLNode<T>
{

	/**
	 * Linked list node
	 * @param args
	 */
	
	public LLNode()
	{
		this.data = null;
		this.next = null;
		this.previous = null;
	}
	
	public LLNode<T> newInstance()
	{
		LLNode<T> newNode = new LLNode<T>();
		return newNode;
	}
	
	public LLNode(T data)
	{
		this.data = data;
		this.next = this.previous = null;
	}

	public LLNode(LLNode<T> node)
	{
		this.data = node.data;
		this.previous = node.previous;
		this.next = node.next;
	}
	T data;
	LLNode<T> next;
	LLNode<T> previous;
}
