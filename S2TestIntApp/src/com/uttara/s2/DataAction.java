package com.uttara.s2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DataAction extends ActionSupport implements SessionAware {

	Map<String,Object> s;
	
	public void setSession(Map<String, Object> m) {
		s = m;
		
	}
	String name;
	int age;
	Date dt;
	List<String> names = new ArrayList<String>();
	List<ContactBean> contacts = new ArrayList<ContactBean>();
	
	public List<ContactBean> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactBean> contacts) {
		this.contacts = contacts;
	}

	public Map<String, Object> getS() {
		return s;
	}

	public void setS(Map<String, Object> s) {
		this.s = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	@Override
	public String execute() throws Exception {
		
		name = "Aravind K";
		names.add("ulti");
		names.add("superb");
		names.add("shabhash");
		names.add("chamak");
		
		age = 40;
		dt = new Date();
		
		ContactBean c1 = new ContactBean("Einstein", "Berlin");
		ContactBean c2 = new ContactBean("Tesla","Warsaw");
		ContactBean c3 = new ContactBean("Edison","London");
		
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		
		s.put("user", "mahauser");

		
		return Action.SUCCESS;
	}
	
	
	
}
