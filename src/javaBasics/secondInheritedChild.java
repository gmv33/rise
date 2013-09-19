package javaBasics;

public class secondInheritedChild extends childClassOfProtectedMethodSuperClass implements Cloneable
{
	public String[] childArr = new String[4];
	
	public secondInheritedChild()
	{
		for(int i=0;i<4;i++)
		{
			childArr[i] = "Geet";
		}
	}
	
	public static void main(String[] args)
	{
		secondInheritedChild me = new secondInheritedChild();
		me.accessMe();
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
