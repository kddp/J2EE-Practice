package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerformance 
{
	public static void main(String[] args) throws PerformanceException 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("performance.xml");
		Performer p1 = (Performer)context.getBean("performer1");
		System.out.println("----------------------------------");
		
		p1.perform();
	
		System.out.println("----------------------------------");
		
		Performer p2 = (Performer)context.getBean("performer2");
		p2.perform();
	}
}
