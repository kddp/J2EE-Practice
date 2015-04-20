package com.uttara.s2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class InputAction extends ActionSupport {
	
	InputBean bean;
	String msg;
	
	public InputAction() {
		System.out.println("inside IA constr");
	}
	
	public InputBean getBean() {
		return bean;
	}
	public void setBean(InputBean bean) {
		System.out.println("setBean() of WA");
		this.bean = bean;
	}
	public String getMsg() {
		System.out.println("getMsg() of WA");
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public void validate() {
		System.out.println("validate() of IA");
	}
	@Override
	public String execute() throws Exception {
		System.out.println("inside execute of IA");
		return Action.SUCCESS;
	}
	
	
}





