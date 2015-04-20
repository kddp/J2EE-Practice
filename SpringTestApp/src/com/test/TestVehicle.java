package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class TestVehicle 
{
	public static void main(String[] args) 
	{
		//String path = "C:\\JavaJeeWorkSpace\\SpringTestApp\\src\\vehicle.xml";
		//BeanFactory context = new XmlBeanFactory(new FileSystemResource(path));
		ApplicationContext context = new ClassPathXmlApplicationContext("vehicle.xml");
		
		Vehicle car1 = (Vehicle)context.getBean("car1");
		Vehicle car2 = (Vehicle)context.getBean("car2");
		System.out.println("---------------------");
		car1.drive();
		System.out.println("---------------------");
		car2.drive();
	}

}
