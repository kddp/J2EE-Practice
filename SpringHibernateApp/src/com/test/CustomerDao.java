package com.test;

public interface CustomerDao
{
	public void save(Customer e);
	public void update(Customer e);
	public void delete(int cno);
	public Customer get(int cno);
}
