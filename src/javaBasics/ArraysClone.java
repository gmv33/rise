package javaBasics;

/*
 * Run as Integer Array or String array it will initialize as null
 * Run as int and it initialized to 0
 * Arrays of primitives are intrinsically cloneable - if arrays contain objects, they are shallow copied as expected
 */
public class ArraysClone implements Cloneable
{
	secondInheritedChild[] source=new secondInheritedChild[2];
	
	public static void main(String[] args) throws CloneNotSupportedException
	{
		ArraysClone ac = new ArraysClone();
		
		ac.source[0] = new secondInheritedChild();
		ac.source[1] = new secondInheritedChild();

		ArraysClone cloned = (ArraysClone)ac.clone(ac);
		
		for(int i=0;i<cloned.source.length;i++)
		{
			cloned.source[i].childArr[0] = "Sabu";
		}
		
		for(int i=0;i<ac.source.length;i++)
		{
			System.out.println(ac.source[0].childArr[0]);
		}
	}
	
	public Object clone(ArraysClone ac) throws CloneNotSupportedException
	{
		ArraysClone newAc = (ArraysClone) super.clone();
		/*
		 * What does it mean by intrinsically cloneable? that just means they support cloning internally.
		 * But you will always need to recreate objects still when you call clone functions like the below
		 */
		newAc.source = ac.source.clone();
		
		// newAc.source = new secondInheritedChild[2];
		
		newAc.source[0] = new secondInheritedChild();
		newAc.source[1] = new secondInheritedChild();
		
		return newAc;
	}
}
