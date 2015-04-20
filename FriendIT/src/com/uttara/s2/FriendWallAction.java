package com.uttara.s2;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FriendWallAction extends ActionSupport implements SessionAware
{
	OutputBean myfrnd;
	PostBean post;
	Map<String,Object> session;
	String name;
	

	public PostBean getPost() {
		return post;
	}

	public void setPost(PostBean post) {
		this.post = post;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OutputBean getMyfrnd() {
		return myfrnd;
	}

	public void setMyfrnd(OutputBean myfrnd) {
		this.myfrnd = myfrnd;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	@Override
	public String execute() throws Exception 
	{
		System.out.println("inside FriendsWallAction execute()");
		System.out.println("Name of the friend to goto profile (Value of name)=>"+name);
		String [] n = name.split(" ");
		String fname = n[0];
		String lname = n[1];
		System.out.println("Fname =>"+fname+" Lname =>"+lname);
		
		Model m = new Model();
		
		OutputBean frndDetails = m.gotoFrndWall(fname,lname);
		session.put("friendDetails", frndDetails);
		OutputBean frndDet = (OutputBean) session.get("friendDetails");
		
		String email = frndDet.getEmail(); 
		String pass = frndDet.getPass();
		System.out.println("Email and Password of the Friends =>"+email+" "+pass);
		
		ArrayList<PostBean> p = m.getPost(email,pass);
		System.out.println("Posts of your Friend=>"+p);
		session.put("frndpost", p);
		
		return Action.SUCCESS;
	}
}
