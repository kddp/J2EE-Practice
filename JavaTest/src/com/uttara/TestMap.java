package com.uttara;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class TestMap 
{
	public static void main(String[] args) throws IOException 
	{
		String line = null;
		String path = "C:/1.txt";
		int count = 0;
		BufferedReader br = new BufferedReader(new FileReader(path));
		Map<String,Integer> mp = new TreeMap<String,Integer>();
		while((line=br.readLine())!=null)
		{
			String [] str = line.split(" ");
			for(String s : str)
				mp.put(s, count++);
		}
		System.out.println(mp);
		System.out.println(mp.get("nag"));
		System.out.println(mp.keySet());
		System.out.println(mp.size());
		System.out.println(mp.values());
		System.out.println(mp.containsKey("nag"));
		System.out.println(mp.containsValue(6));
	}

}
