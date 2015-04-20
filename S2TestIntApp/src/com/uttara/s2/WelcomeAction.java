package com.uttara.s2;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport{

	String msg;
	String uname;
	List<String> food = new ArrayList<String>();
	
	public List<String> getFood() {
		return food;
	}
	public void setFood(List<String> food) {
		this.food = food;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		System.out.println("inside setUname() "+uname);
		this.uname = uname;
	}
	@Override
	public void validate() {
		System.out.println("inside validate() of WA");
	}
	@Override
	public String execute() throws Exception {
		System.out.println("inside execute() of WA");
		food.add("ravaidly");
		food.add("masaladosa");
		food.add("upama");
		
		uname = "robin";
		return Action.SUCCESS;
	}
	
}
