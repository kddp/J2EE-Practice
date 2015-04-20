package com.test.spring;

public class Guitar implements Instrument 
{
	public Guitar() 
	{
		System.out.println("inside no-arg constr of Guitar");
	}
	@Override
	public void play()
	{
		System.out.println("Guitar playing....Strum...strum...strum....");
	}
	@Override
	public String toString() {
		return "Guitar";
	}
	
}
