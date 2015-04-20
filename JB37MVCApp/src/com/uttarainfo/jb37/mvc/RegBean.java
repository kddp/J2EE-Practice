package com.uttarainfo.jb37.mvc;

public class RegBean {

	private String uname,email,pass,rpass;

	
	public RegBean() {
		// TODO Auto-generated constructor stub
		System.out.println("inside RegBean constructor");
	}
	
	
	public String validate()
	{
		
		System.out.println("inside Models register() ");
		String msg="";
		if(uname==null || uname.trim().equals(""))
		{
			System.out.println("uname is empty");
			msg = msg + " Yakappa, your thandethayi did not name you or what!!";
		}
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
		if(pass!=null && !pass.equals(rpass))		
		{
			msg = msg + " your own pass is not equal to your own pass. wht will u achieve in life! ";
		}
		if (msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;	
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
		System.out.println("inside setUname "+uname);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("inside setEmail "+email);
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRpass() {
		return rpass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	
	
	
	
}
