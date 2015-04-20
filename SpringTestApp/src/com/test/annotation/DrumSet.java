package com.test.annotation;

public class DrumSet implements Instrument
{

	public DrumSet() 
	{
		System.out.println("inside no-arg const of DrumSet");
	}
	public void play() 
	{
		System.out.println("DUMM....DUMM....DUMM.....");
	}

}
