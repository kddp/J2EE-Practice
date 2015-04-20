package com.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestMessage 
{
	public static void main(String[] args) 
	{
		Message m1 = new Message("Hello Test!!!",new Date());
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();	
        s.save(m1);
		tx.commit();
		s.close();
		
	}
}
