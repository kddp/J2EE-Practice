package com.uttara.s2;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport implements SessionAware
{
	LoginBean bean;
	Map<String,Object> session;
	
	public Map<String, Object> getSession() {
		return session;
	}

	public LoginBean getBean() {
		return bean;
	}

	public void setBean(LoginBean bean) {
		this.bean = bean;
	}

	
	public String execute()
	{
		System.out.println("Name =>"+bean.uname+" Email=>"+bean.email+" Age =>"+bean.age);
		session.put("userDetails", bean);
		
		return Action.SUCCESS;
	}

	public void validate() 
	{
		
		if(bean.getEmail().equals("a@a.com"))
			addActionError(getText("error.email"));
	}

	@Override
	public void setSession(Map<String, Object> obj) 
	{
		session = obj;
	}

	
}
