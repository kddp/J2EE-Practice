package com.uttara.s2;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements SessionAware, RequestAware, ApplicationAware
{
	private String uname;
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		System.out.println("inside setUname() "+uname);
		this.uname = uname;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	private Map<String,Object> session;
	private Map<String,Object> req,ctx;
	
	public TestAction() {
		System.out.println("inside TestAction no-arg constr");
	}
	
	@Override
	public void validate() {
		System.out.println("inside validate() of TA");
	}
	@Override
	public String execute() throws Exception {
		System.out.println("inside execute of TA");
//		System.out.println("access to attr "+session+" "+req+" "+ctx);
		return Action.SUCCESS;
	}

	public void setSession(Map<String, Object> m) {
		System.out.println("inside setSession() of TA ");
		session = m;
		
	}

	public void setApplication(Map<String, Object> arg0) {
		ctx = arg0;
		System.out.println("in setApp() ");
		
	}

	public void setRequest(Map<String, Object> arg0) {
		req = arg0;
		System.out.println("in setReq ");
		
	}
}





