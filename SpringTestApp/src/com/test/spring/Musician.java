package com.test.spring;


public class Musician 
{
	String name;
	private Instrument inst;
	
	public Musician()
	{
		System.out.println("inside no-arg constr of Musician");
	}
	
	public Musician(String name)
	{
		this.name = name;
	}
	
	public void playInstrument()
	{
		System.out.println("I am Musician Playing "+inst+".....having name =>"+name);
	}

	public Instrument getInst() {
		return inst;
	}

	public void setInst(Instrument inst) {
		this.inst = inst;
	}
	
}
