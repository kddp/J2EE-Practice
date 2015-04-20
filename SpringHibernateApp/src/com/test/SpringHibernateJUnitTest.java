package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext_Hibernate.xml")
public class SpringHibernateJUnitTest 
{
	@Autowired
	ApplicationContext context;
	
	@Test
	public void testSpringHibernate()
	{
		CustomerDao custDao = (CustomerDao)context.getBean("customerdao");
		Customer c = new Customer();
		c.setCno(1);
		c.setCname("Abhishek");
		c.setAddress("JP Nagar");
		c.setPhone(1324567890);
		custDao.save(c);
		System.out.println("Customer added succesfully...........");
		
	}
}
