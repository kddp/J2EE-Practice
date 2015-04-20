package com.uttara;

public class TestNum {

	public static void main(String[] args) 
	{
		nonDec("", 0);
	}
	public static void nonDec(String temp,int i)
	{
		temp=temp+i;
		if(temp.length()==4)
		{
			System.out.println(temp);
			return;
		}
		else
		{
			for(int j=i;j<=9;j++)
				nonDec(temp,j);	
		}

	}
}
