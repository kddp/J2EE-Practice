package com.uttara.s2;

import com.opensymphony.xwork2.ActionSupport;

public class SendEmailAction extends ActionSupport
{
	String listoffrnds;
	
	public String getListoffrnds() {
		return listoffrnds;
	}

	public void setListoffrnds(String listoffrnds) {
		this.listoffrnds = listoffrnds;
	}

	@Override
	public String execute() throws Exception 
	{
		Model m = new Model();
		System.out.println("Inside SendEmail Action execute()");
		System.out.println("Friend Email =>"+listoffrnds);
		String [] email = listoffrnds.split(",");
		String result = m.sendRequest(email);
		
		return result;
	}
	
}
