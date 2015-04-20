package com.uttara.s2;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements SessionAware
{
	Map<String,Object> session;
	PostBean myPost;
	PostBean post;
	PostBean mssg;
	
		
	public PostBean getMssg() {
		return mssg;
	}

	public void setMssg(PostBean mssg) {
		this.mssg = mssg;
	}

	public PostBean getPost() {
		return post;
	}

	public void setPost(PostBean post) {
		this.post = post;
	}

	public PostBean getMyPost() {
		return myPost;
	}

	public void setMyPost(PostBean myPost) {
		this.myPost = myPost;
	}

	public void setSession(Map<String, Object> arg0) {
		session = arg0;	
	}
	
	@Override
	public String execute() throws Exception 
	{
		System.out.println("inside execute() of Postmywall");
		Model m = new Model();
		OutputBean bean = (OutputBean) session.get("userDetails");
		String result = m.postToMe(bean,myPost);
		
		return result;
	}

	public String postMyFriendWall() throws Exception
	{
		System.out.println("inside PostmyFriend");
		OutputBean my = (OutputBean) session.get("userDetails");
		OutputBean frnd = (OutputBean) session.get("friendDetails");
		Model m = new Model();
		
		String result = m.postToFriend(my.getEmail(),frnd.getEmail(),post);
		
		System.out.println("Result of executing Model posttomyFrnd()"+result);
		
		return Action.SUCCESS;
	}
	
	public String mssgMyFriendWall() throws Exception
	{
		System.out.println("inside MssgMyFriend");
		OutputBean my = (OutputBean) session.get("userDetails");
		OutputBean frnd = (OutputBean) session.get("friendDetails");
		Model m = new Model();
		
		String result = m.mssgToFriend(my.getEmail(),frnd.getEmail(),mssg);
		
		System.out.println("Result of executing Model posttomyFrnd()"+result);
	
		return Action.SUCCESS;
		
		
	}
}
