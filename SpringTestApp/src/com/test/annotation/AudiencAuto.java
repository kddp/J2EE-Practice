package com.test.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AudiencAuto 
{
	@Pointcut("execution(* com.test.annotation.Performer.perform(..))")
	public void viewPerfomance(){}
	
	@Before("viewPerfomance()")
	public void takeSeat()
	{
		System.out.println("The Audiens are taking sets......");
	}
	
	@Before("viewPerfomance()")
	public void turnOffCellPhone()
	{
		System.out.println("The Audiens are turning off their Cell phones......");
	}
	
	@After("viewPerfomance()")
	public void turnOnCellPhone()
	{
		System.out.println("The Audiens are turning on their Cell phones......");
	}
	
	
	@After("viewPerfomance()")
	public void applaud()
	{
		System.out.println("CLAP....CLAP....CLAP....");
	}
	
	@Around("viewPerfomance()")
	public void timeTracker(ProceedingJoinPoint point)
	{
		try
		{
				double d1 = System.currentTimeMillis();
				point.proceed();
				double d2 = System.currentTimeMillis();
				System.out.println("time for the Performance is =>"+(d2-d1));
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			System.out.println("BOO....BOOO....We want oour money back..!!!");
		}
	}
	
	
}
