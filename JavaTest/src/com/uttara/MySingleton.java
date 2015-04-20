package com.uttara;

public class MySingleton 
{
	private MySingleton() 
	{
		
	}
	private static MySingleton  one = null;
	public static MySingleton getInstance()
	{
		if(one == null)
		{
			one = new MySingleton();
			return one;
		}
		else
			return one;
	 }
}
