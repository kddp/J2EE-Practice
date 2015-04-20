package com.uttara.test;

import java.util.Comparator;

public class LengthComprator implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		if((o1 instanceof String)&&(o2 instanceof String))
		{
			String s1 = (String)o1;
			String s2 = (String)o2;
			if(s1.length()-s2.length()==0)
				return s1.compareTo(s2);
			else
				return (s2.length()-s1.length());
		}
		return 0;
		
	}
}
