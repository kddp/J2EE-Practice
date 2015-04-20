package com.uttara.s2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetDetailAction extends ActionSupport
{
	Model model;

	@Override
	public String execute() throws Exception {
		
		System.out.println("inside SetBeanAction");
		System.out.println("Going to Setting data");
		
		 GetDetailBean beno = model.getDetail(); 
		
		System.out.println("Name =>"+beno.getUname()+" Email =>"+beno.getEmail()+" Age =>"+beno.getAge());
		
		return Action.SUCCESS;
	}
}
