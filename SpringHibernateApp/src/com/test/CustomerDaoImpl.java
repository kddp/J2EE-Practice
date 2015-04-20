package com.test;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("customerdao")
public class CustomerDaoImpl implements CustomerDao
{
	private HibernateTemplate hibernateTemplete;
	@Override
	public void save(Customer e)
	{
		hibernateTemplete.save(e);		
	}

	@Override
	public void update(Customer e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int cno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer get(int cno) {
		// TODO Auto-generated method stub
		return null;
	}

}
