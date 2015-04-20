package com.uttara.s2;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware
{
	Map<String,Object> session;
	PostBean myPost;
	
	public PostBean getMyPost() {
		return myPost;
	}

	public void setMyPost(PostBean myPost) {
		this.myPost = myPost;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("inside execute of Logout action!!!");
		Model m = new Model();
		
		String result = m.logout(session);
		
		System.out.println("Result from m.logout()!!!"+result);
		System.out.println("Aftre removing from session"+session);
		 addActionMessage(getText("session.over.mssg"));
		return result ;
	}
		
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}		
	
	
	public String getFriends() 
	{
		System.out.println("inside getFriends");
		Model m = new Model();
		
		OutputBean bean = (OutputBean) session.get("userDetails");
		System.out.println("Email =>"+bean.getEmail()+" Pass =>"+bean.getPass());
		
		ArrayList<OutputBean> al = m.getFriends(bean.getEmail(),bean.getPass());
		session.put("listFriends", al);
		
		return Action.SUCCESS;
		
	}
}
