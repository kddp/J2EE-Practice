package com.test.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/audienc2.xml")
public class Audienc2 
{
	@Autowired ApplicationContext context;
	
	@Test
	public void viewPerformance() throws Exception
	{
		Performer p = (Performer)context.getBean("instrumentalist");
		p.perform();
	}
}
