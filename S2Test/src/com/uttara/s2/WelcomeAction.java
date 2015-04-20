package com.uttara.s2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport
{
	String uname;
	String email;
	int age;
	
	
	
	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String execute() throws Exception {
		
		
		
		return Action.SUCCESS;
	}
	
}
