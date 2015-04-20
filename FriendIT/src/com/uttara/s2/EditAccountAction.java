package com.uttara.s2;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class EditAccountAction extends ActionSupport implements SessionAware
{
	Map<String,Object> session;
	RegBean editBean;
	
	public RegBean getEditBean() {
		return editBean;
	}
	public void setRegBean(RegBean editBean) {
		this.editBean = editBean;
	}
	
	@Override
	public String execute() throws Exception 
	{
		Model m = new Model();
		System.out.println("going to get data...");
		
		OutputBean bean = (OutputBean) session.get("userDetails");
		
		editBean = m.editAccount(bean.getEmail(),bean.getPass());
		
		System.out.println("after getting data....");
		return Action.SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
	
}
