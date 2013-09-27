package algorithms;


/**
 * This class will use the greedy approach to find the maximum number of tasks
 * that can be performed by a single individual given the start and end times of
 * each task
 * 
 * Choose the next best looking task as the one to be performed with start time
 * greater than the current task's end time
 * 
 * @author GVARMA
 * @version 1.0
 */

public class activityAllocationGreedy
{
	int[] start={0,4,3,7,34,2,55,4};
	int[] end={6,5,33,51,35,3,56,10};

	public static void main(String[] args)
	{
		// sort both arrays according to finish time
		activityAllocationGreedy obj=new activityAllocationGreedy();
		obj.customSort();

		obj.allocateActivity();
	}

	public void customSort()
	{
		int temp;
		for(int i=0;i<end.length-1;i++)
		{
			for(int j=0;j<end.length-i;j++)
			{
				if(end[j]>end[j+1])
				{
					temp=end[j];
					end[j]=end[j+1];
					end[j+1]=temp;

					temp=start[j];
					start[j]=start[j+1];
					start[j+1]=temp;
				}
			}
		}
	}

	public void allocateActivity()
	{
		int maxCount=0;
		String[] result=new String[end.length];

		// can always do first activity
		maxCount++;
		result[0]=start[0]+"-"+end[0];

		// you will only need one pass; think about it why - there are two relationships at play here
		//  since the array is sorted, values are in increasing order; corresponding values in start are always greater than the 
		// corresponding values in the end array
		for(int i=1;i<end.length;i++)
		{
			if(start[i]> end[i-1])
			{
				maxCount++;
				result[i] = start[i]+ "-" + end[i];
			}
		}
		
		System.out.println("Max activites that can be performed is " + maxCount);
		System.out.println("Activity List: ");
		for(int i=0;i<result.length;i++)
		{
			System.out.println();
		}
	}
}
