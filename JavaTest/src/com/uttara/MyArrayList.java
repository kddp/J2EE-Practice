package com.uttara;

public class MyArrayList 
{
	private Object [] arr = new Object[10];
	private int count ;
	
	public boolean add(Object obj)
	{
		if(count<arr.length)
		{
			arr[count++] = obj;
		}
		else
		{
			int a = 0;
			Object [] temp = new Object [2*arr.length];
			for(Object o : arr)
				temp[a++] = o;
			arr = temp;
			arr[count++] = obj;
		}
		return true;
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<count++;i++)
			sb.append(arr[i]+" ");
		return sb.toString();
	}

}
