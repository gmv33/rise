package dataStructures;

public class CustomLinkedList<T>
{

	/**
	 * This is the Linked List Data Structure to store Generic data
	 * @param args
	 */
	private LLNode<T> head;
	private LLNode<T> tail;
	private int size;
	
	public CustomLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean addElement(T data)
	{
		LLNode<T> newNode = new LLNode<T>(data);
		if(size==0)
		{
			newNode.next = newNode.previous = null;
			head = tail = newNode;
			size++;
		}
		else
		{
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;
			size++;
		}
		
		return true;
	}
	
	public boolean remove(int index)
	{
		if(index<0 || index > size -1)
			return false;
		
		LLNode<T> delNode = head;
		for(int i=0; i<index; i++)
			delNode = delNode.next;
		
		delNode.previous.next = delNode.next;
		delNode.next.previous = delNode.previous;
		
		delNode.next = delNode.previous = null;
		delNode.data = null;
		
		size--;
		return true;
	}
	
	public T getAt(int index)
	{
		if(index<0 || index > size -1)
			return null;
		
		LLNode<T> retNode = head;
		
		for(int i=0;i<index;i++)
			retNode = retNode.next;
		
		final T data = retNode.data;
		return data;
	}
	
	public int getSize()
	{
		return size;
	}
}
