package javaBasics;

/*
 * Run as Integer Array or String array it will initialize as null
 * Run as int and it initialized to 0
 * Arrays of primitives are intrinsically cloneable - if arrays contain objects, they are shallow copied as expected
 */
public class ArraysClone implements Cloneable
{
	secondInheritedChild[] source=new secondInheritedChild[2];
	
	public static void main(String[] args)
	{
		ArraysClone ac = new ArraysClone();
		
		ac.source[0] = new secondInheritedChild();
		ac.source[1] = new secondInheritedChild();

		ac.clone();
		secondInheritedChild[] cloned = source.clone();
		
		for(int i=0;i<cloned.length;i++)
		{
			cloned[i].childArr[0] = "Sabu";
		}

		for(int i=0;i< source.length;i++)
		{
			for(int k=0;k< source[i].childArr.length;k++)
			{
				System.out.println(source[i].childArr[k]);
			}
		}
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		ArraysClone newAc = (ArraysClone) super.clone();
		newAc.source = new secondInheritedChild();
		
		return newAc;
	}
}
