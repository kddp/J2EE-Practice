package com.uttara.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutput
{
	
	public static void main(String[] args) 
	{
		try 
		{
			String s = "This is a test String to be tested ffkf ddkfjdslgsd vdobjdfobjfdojbd"
					+ "sdfisfsdff fkdlfksf lklkdfsdmf sfdsf";
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C://out.doc"));
			out.writeObject(s);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
