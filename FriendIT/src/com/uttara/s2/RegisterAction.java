package com.uttara.s2;

import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	RegBean bean;
	String msg;
	
	public RegisterAction() {
		System.out.println("inside no-arg constr of RA");
	}
	
	public RegBean getBean() {
		return bean;
	}
	public void setBean(RegBean bean) {
		System.out.println("inside setBean() of RA");
		this.bean = bean;
	}
	public String getMsg() {
		System.out.println("inside getMsg() of RA");
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void validate() {
		System.out.println("inside validate()");
		
		Model m = new Model();
		
		String result = m.validateEmail(bean.getEmail());
		
		if(result.equals("registerview.email.duplicate"))
		{
			addFieldError("bean.email", getText("registerview.email.duplicate"));
		}
		
		if(result.equals("db.connection.problem"))
		{
			addActionError(getText("db.connection.problem"));
		}
		
		if(result.equals("db.problem"))
		{
			addActionError(getText("db.problem"));
		}		
	}
	
	@Override
	public String execute() throws Exception 
	{
		System.out.println("inside execute() of RA");
		// invoke method register of model and pass bean
		// as param. accept string as result. if success, return 
		// Action.SUCCESS else addActionError(<return>) and then return 
		// Action.INPUT
		Model m = new Model();
		
		String result = m.register(bean);
		
		if(result.equals(Action.SUCCESS))
		{
			return Action.SUCCESS;
		}
		else
		{
			return Action.INPUT;
		}		
	}	
}







