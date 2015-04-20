package com.uttara.test;

import java.util.*;

class TestPermutation 
{
	static
	{
		
		System.out.println("inside static block");
	}
	{
		System.out.println("inside instance block");
	}
	int n;
	
	public static void findPermutation(String first,String last)
	{
		if(last.length()<=1)
		{
			System.out.println(first+last);
		}
		else
		{
			for (int i = 0; i < last.length(); i++) 
			{
				String word = last.substring(0,i)+last.substring(i+1);
				findPermutation(first+last.charAt(i), word);
			}
		}
	}
	
	public static void findHcfLcm(int num1,int num2)
	{
		int h = 1;
		int p = num1*num2;
		for (int i = 2; i < p; i++) 
		{
			if((num1%i==0)&&(num2%i==0))
			{
				h = i;
			}
		}
		int l = p/h;
		
		System.out.println("HCF => "+h+" LCM => "+l);		
	}
	
	public static void printPrime(int num)
	{
		for (int i = 1; i < num; i++) 
		{
			boolean isPrime = true;
			for (int j = 2; j < i; j++)
			{
					if(i%j==0)
					{
						isPrime=false;
						break;
					}
			}
			if(isPrime)
			{
				System.out.print(i+" ");
			}
			
		}		
	}
	
	public static void main(String[ ] args)
    { 
		LengthComprator l = new LengthComprator();
		Set<String> al = new LinkedHashSet<String>();
		al.add("abcdef");
		al.add("ab");
		al.add("abcdefghi");
		al.add("abcd");
		al.add("bcde");
		System.out.println(al);
		
    } 
	
}
