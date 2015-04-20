package com.uttara;

import java.io.File;

public class DisplayContent
{
	public static void displayContent(File f)
	{
		if(f.isFile())
		{
			System.out.println(f.getName());
		}
		else
		{
			File [] farr = f.listFiles();
			for(File fin : farr)
			{
				displayContent(fin);
			}
		}
	}
	 public static void main(String [] args)
	 {
		 File f = new File("C:/abhi");
		 displayContent(f);
	 }
}
