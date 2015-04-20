package com.uttara;

public class TestMySingleton 
{
	public static void main(String[] args)
	{
		MySingleton one = MySingleton.getInstance();
		MySingleton two = MySingleton.getInstance();
		MySingleton three = MySingleton.getInstance();
		if(one == two)
			System.out.println("same");
		if(one == three)
			System.out.println("same1");
	}

}
