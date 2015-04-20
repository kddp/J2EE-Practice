package com.uttara.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class FileReaderTest
{
	public static void main(String[] args)
	{
		String path = "C:/1.txt";
		BufferedReader br = null;
		String line = null;
		Map<String,Integer> m = new HashMap<String,Integer>();
		try
		{
			br = new BufferedReader(new FileReader(path));
			while((line=br.readLine())!=null)
			{
				//System.out.println("Readed Line => "+line);
				String [] words = line.split(" ");
				for(String word : words)
				{
					if(m.get(word)!=null)
					{
						m.put(word, m.get(word)+1);
					}
					else
					{
						m.put(word, 1);
					}
				}
			}
			System.out.println("Elements in the Collection are => "+m);

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br!=null)
				try 
			{
					br.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
		}
	}
}
