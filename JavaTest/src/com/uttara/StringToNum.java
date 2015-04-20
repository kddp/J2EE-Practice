package com.uttara;

public class StringToNum 
{
	public static int toNum(String str)
	{
		char[] charr = str.toCharArray();
		int sum=0;
		int zeroAscii = (int)'0';
		for(char c : charr)
		{
			int tempAscii = (int)c;
			sum = (sum*10)+(tempAscii-zeroAscii);
		}
		return sum;
	}
	
	public static void main(String [] args)
	{
		System.out.println(toNum("1258"));
		System.out.println(toNum("234"));
	}

}
