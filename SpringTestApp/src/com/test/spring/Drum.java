package com.test.spring;

public class Drum implements Instrument
{
	public Drum()
	{
		System.out.println("inside no-arg constr of drum");
	}
	
	public void play()
	{
		System.out.println("drum....playing...dum...dum....dummm");
	}
}
