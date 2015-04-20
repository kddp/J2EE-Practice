package com.uttara;

import java.util.Comparator;

public class LengthComparator implements Comparator
{

	@Override
	public int compare(Object arg0, Object arg1) 
	{
		if(arg0 instanceof String && arg1 instanceof String)
		{
			String s1 = (String)arg0;
			String s2 = (String)arg1;
			
			return (s1.length()-s2.length());
		}
		else
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
		
		
	}
	

}
