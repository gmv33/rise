package recursion_DP;

import java.util.HashMap;

/**
 * Finds the minimum number of tries to find the floor that breaks the egg.
 * 
 * @author gv186004 If there are k floors and n eggs then - i) either the egg
 *         breaks from floor x; in that case problem reduces to x-1 floors and
 *         n-1 eggs ii) or the egg doesn't break and the puzzle reduces to k-x
 *         floors with n eggs remaining
 * 
 *         DOES NOT WORK WITH CACHE. FIX IT LATER.
 * 
 */
public class EggDrop
{

	public HashMap<String,Integer> cache=new HashMap<String,Integer>();

	public static void main(String[] args)
	{
		int eggs=2;
		int floors=10;

		EggDrop ed=new EggDrop();
		System.out.println(ed.processPuzzle(floors,eggs));
	}

	protected int processPuzzle(int f,int e)
	{

		if(f==0||f==1)
			return f;
		if(e==1)
		{
			return f;
		}
		int attemptsReqdBrk,attemptsReqdDBrk,res;
		int min=Integer.MAX_VALUE;

		if(e>1)
		{
			for(int i=1;i<=f;i++)
			{
				// egg breaks
				if(!cache.containsKey(f+","+e))
				{
					attemptsReqdBrk=1+processPuzzle(i-1,e-1);
					cache.put(f+","+e,attemptsReqdBrk);
				}
				else
					attemptsReqdBrk=cache.get(f+","+e);
				// egg does not break
				if(!cache.containsKey(f+","+e))
				{
					attemptsReqdDBrk=1+processPuzzle(f-i,e);
					cache.put(f+","+e,attemptsReqdDBrk);
				}
				else
					attemptsReqdDBrk=cache.get(f+","+e);
				res=max(attemptsReqdBrk,attemptsReqdDBrk);
				if(res<min)
				{
					min=res;
				}
			}
		}
		return min;
	}

	public int max(int a,int b)
	{
		return a>b?a:b;
	}
}
