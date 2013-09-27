package javaBasics;

import dataStructures.CustomLinkedList;

public class testLL
{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		/*LinkedList<Integer> e = new LinkedList<Integer>();
		
		Set free = new HashSet<>();
		free.add(10);
		free.add("Chivas");
		
		for(Iterator iterator=free.iterator();iterator.hasNext();)
		{
			System.out.println(iterator.next());
		}*/
		
		CustomLinkedList<Integer> cll = new CustomLinkedList<Integer>();
		
		for(int i=0;i<100;i++)
		{
			cll.addElement((int)Math.floor(Math.random()*1000));
		}
		
		for(int i=0;i<10;i++)
		{
			cll.remove((int)Math.floor(Math.random()*90));
		}
		
		System.out.println("Size is : " + cll.getSize());
		System.out.println("Values are: \n");
		
		for(int i=0;i<cll.getSize();i++)
		{
			System.out.println(i + "::" + cll.getAt(i));
		}
	}

}
