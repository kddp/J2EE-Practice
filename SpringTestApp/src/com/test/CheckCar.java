package com.test;

import org.aspectj.lang.ProceedingJoinPoint;

public class CheckCar 
{
	public void check(ProceedingJoinPoint joinpoint)
	{
		try
		{
			double start = System.currentTimeMillis();
			joinpoint.proceed();
			double end = System.currentTimeMillis();
			System.out.println("Time to Check => "+(end-start));			
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			System.out.println("Oops something problem is their in your vehicle.....");
		}
	}
}
