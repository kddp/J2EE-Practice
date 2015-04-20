package com.uttara.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.HashMap;

public class TestObjectOutput
{
	public static void m\u0061in(String[] args) 
	{
		/*try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C://out.txt"));
			String text = (String)in.readObject();
			System.out.println("Text from File => "+text);
		}
		catch(Exception e)
		{
			System.out.println("Oops Something went Bad");
			e.printStackTrace();
		}*/	
		/*if ("string".toUpperCase() == "STRING") {
			System.out.println("Equal");
			} else {
			System.out.println("Not Equal");
			}
			System.out.println("string".toUpperCase());*/
			
		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = new StringBuilder("abc");
		String s = "abc";
		System.out.println(sb1==sb2);
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.equals(s));
		}
	}
