package sorting;

public class insertionSort
{
	public static void main(String[] args)
	{
		insertionSort is=new insertionSort();

		int[] unsorted=new int[1000000];

		for(int i=0;i<unsorted.length;i++)
		{
			unsorted[i]=(int)(Math.random()*100000);
		}

		long start=System.currentTimeMillis();
		int[] sorted=is.sortIt(unsorted);
		long end=System.currentTimeMillis();

		long timespan=end-start;

		/*System.out.println("Sorted list of numbers is: \n");
		for(int i=0;i<sorted.length;i++)
		{
			System.out.println(sorted[i]);
		}*/

		System.out.println("Time required to sort "+sorted.length+" numbers is "+timespan+" milliseconds ("+(float)timespan/1000f+" seconds).");
	}

	public int[] sortIt(int[] sorted)
	{
		int placeholder;
		int j;
		for(int i=1;i<sorted.length;i++)
		{
			placeholder = sorted[i];
			for(j=i-1;j>=0;j--)
			{
				if(placeholder<sorted[j])
				{
					sorted[j+1]=sorted[j];
				}
				else
					break;
			}
			sorted[j+1] = placeholder;
		}
		return sorted;
	}
}
