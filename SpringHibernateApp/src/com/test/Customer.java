package com.test;

import java.io.Serializable;

public class Customer implements Serializable
{
	private String cname;
	private int cno;
	private String address;
	private long phone;
	
	public Customer()
	{
		System.out.println("inside no-arg constr of Customer");
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}
