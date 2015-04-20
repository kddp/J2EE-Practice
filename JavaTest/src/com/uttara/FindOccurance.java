package com.uttara;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class FindOccurance
{
	public static Map<String,Integer> findNoOfOccur(String path1, String path2)
	{
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		Map<String,Integer> mp = new HashMap<String,Integer>();
		try
		{
			br1 = new BufferedReader(new FileReader(path1));
			br2 = new BufferedReader(new FileReader(path2));
			String line = null;
			while((line=br1.readLine())!=null)
			{
				String [] arr = line.split(" ");
				for(String str : arr)
					if(mp.get(str)!=null)
						mp.put(str,mp.get(str)+1);
					else
						mp.put(str, 1);
			}
			while((line=br2.readLine())!=null)
			{
				String [] arr = line.split(" ");
				for(String str : arr)
					if(mp.get(str)!=null)
						mp.put(str, mp.get(str)+1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				if(br1!=null)
					br1.close();
				if(br2!=null)
					br2.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return mp;
		
	}
	public static void main(String [] args)
	{
		String path1 = "C:/1.txt";
		String path2 = "C:/2.txt";
		System.out.println(findNoOfOccur(path1,path2));
	}
}
