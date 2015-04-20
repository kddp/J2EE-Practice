package com.uttara.s2;

public class ContactBean {
	String name;
	String city;
	public ContactBean() {
		// TODO Auto-generated constructor stub
	}
	public ContactBean(String n,String c)
	{
		name = n;
		city = c;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
