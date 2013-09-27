package sorting;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * 
 * @author GVARMA Always read first two values, switch if first is larger than
 *         the second. Each iteration brings the largest to the last position.
 *         2nd iteration won't check for the last value which was already set in
 *         the first iteration and so on.
 * 
 *         The sorted list is::
 * 
 *         Time required to sort 1000000 integers is: 1406441 milliseconds
 *         (1406.441 seconds).
 * 
 * 
 */

public class bubbleSort
{
	public static void main(String[] args)
	{
		bubbleSort bs=new bubbleSort();

		int[] unsorted=new int[1000000];
		for(int i=0;i<unsorted.length;i++)
		{
			unsorted[i]=(int)(Math.random()*100000);
		}

		long start=System.currentTimeMillis();
		int[] sorted=bs.bubbleIt(unsorted);
		long end=System.currentTimeMillis();

		long timespan=end-start;

		System.out.println("The sorted list is:: \n");
		/*
		 * for(int i=0;i<sorted.length;i++) { System.out.println(sorted[i]); }
		 */

		System.out.println("Time required to sort "+unsorted.length+" integers is: "+timespan+" milliseconds ("+(float)timespan/1000f+" seconds).");
	}

	public int[] bubbleIt(int[] unsorted)
	{
		int[] sorted=unsorted;
		int placeholder;
		for(int i=sorted.length-1;i>0;i--)
		{
			for(int j=0;j<i;j++)
			{
				if(sorted[j]>sorted[j+1])
				{
					placeholder=sorted[j];
					sorted[j]=sorted[j+1];
					sorted[j+1]=placeholder;
				}
			}
		}
		return sorted;
	}
}