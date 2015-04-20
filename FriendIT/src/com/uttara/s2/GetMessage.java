package com.uttara.s2;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetMessage extends ActionSupport implements SessionAware
{
	Map<String,Object> session;
	LoginBean bean;
	PostBean mssg;
	
	
	
	public LoginBean getBean() {
		return bean;
	}

	public void setBean(LoginBean bean) {
		this.bean = bean;
	}

	public PostBean getMssg() {
		return mssg;
	}

	public void setMssg(PostBean mssg) {
		this.mssg = mssg;
	}

	@Override
	public String execute() throws Exception
	{
		Model m = new Model();
		OutputBean b = (OutputBean) session.get("userDetails");
		ArrayList<PostBean> p = m.getMssgs(b.getEmail(),b.getPass());
		session.put("mssgs", p);
		
		return Action.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;	
	}
}
