package com.uttara.s2;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware,ServletResponseAware,ServletRequestAware
{
	LoginBean bean;
	PostBean postBean;
	Map<String,Object> session;
	HttpServletResponse response;
	HttpServletRequest request;
	String result;
	
	

	public PostBean getPostBean() {
		return postBean;
	}

	public void setPostBean(PostBean postBean) {
		this.postBean = postBean;
	}

	public LoginBean getBean() {
		return bean;
	}

	public void setBean(LoginBean bean) {
		this.bean = bean;
	}
	
	@Override
	public void validate() 
	{
		System.out.println("inside validate of LoginAction");	
		System.out.println(" Checking Session =>"+session);
		
		if(session.isEmpty())
		{
			Model m = new Model();	
			
			result = m.authenticate(bean);
			System.out.println("Result from authenticate() =>"+result);
				
			if(result.equals("missmatch.email.pass"))
			{
				addActionError(getText("missmatch.email.pass"));
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
		System.out.println("Exiting validate()");
	}
	
	
	@Override
	public String execute() throws Exception
	{
			System.out.println("inside execute() of LoginAction");
			
			Model m = new Model();
			
		/*	if(session.isEmpty())
			{*/
				System.out.println("inside execute() when session is empty");
				String email = bean.getEmail();
				String pass = bean.getPass();
				
				OutputBean outBean = m.getDetails(email,pass);			
		
				ArrayList<PostBean> p = m.getPost(email,pass);
				
				session.put("userDetails", outBean);
				session.put("posts", p);
				
				return Action.SUCCESS;
		/*	}
			else
			{
				System.out.println("inside execute() session is not empty");
				OutputBean outBea = (OutputBean) session.get("userDetails");
				
				String email = outBea.getEmail();
				String pass = outBea.getPass();
				session.clear();
				System.out.println("Checking Session after Clearing =>"+session);
				OutputBean outBean = m.getDetails(email,pass);			
				ArrayList<PostBean> p = m.getPost(email,pass);
			
				session.put("userDetails", outBean);
				session.put("posts", p);
				
				return Action.SUCCESS;
			}*/
				
		}

	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		session = arg0;
	}	
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;	
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
}
