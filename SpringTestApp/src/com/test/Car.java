package com.test;

public class Car implements Vehicle {
	String name;
	@Override
	public void drive() {
		System.out.println("I am a car driving.....having name "+name);

	}
	
	public Car() {
		System.out.println("inside no-arg const of Car");
	}
	
	public Car(String name) {
		System.out.println("inside arg const of Car");
		this.name = name;
	}
	
	public void initMethod()
	{
		System.out.println("this is init method...");
	}
	
	public void destroyMethod()
	{
		System.out.println("this is destroy method.....");
	}
}
