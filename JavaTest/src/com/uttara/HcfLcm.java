package com.uttara;

public class HcfLcm 
{
	public static void main(String[] args) 
	{
		int a = 250;
		int b = 100;
		int h = 1;
		int p = a * b;
		for(int i=2;i<p;i++)
		{
			if((a%i==0)&&(b%i==0))
			{
				h = i;
			}
		}
		int l = p/h;
		System.out.println("HCF => "+h+" LCM => "+l);

	}

}
