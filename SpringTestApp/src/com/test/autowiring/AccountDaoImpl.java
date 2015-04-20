package com.test.autowiring;

public class AccountDaoImpl
{
	public AccountDaoImpl() 
	{
		private DataSource dataSource;
		System.out.println("inside AccountDaoImpl no-arg constr");
	}
	
}
