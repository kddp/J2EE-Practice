package com.uttarainfo.jb37.mvc;

public class LoginBean {

	private String email, pass;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String validate()
	{
		String msg="";

		if(email==null || email.trim().equals(""))
		{
			System.out.println("email is empty");
			msg = msg + "email, email kodri mister!";
		}
		if(pass==null || pass.trim().equals(""))
		{
			System.out.println("pass is empty");
			msg = msg + "yenna password?";
		}		
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}
	
}
