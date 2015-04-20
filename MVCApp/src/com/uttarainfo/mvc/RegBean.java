package com.uttarainfo.mvc;

public class RegBean {
	String uname,email,pass,rpass;
	
	public RegBean()
	{
		System.out.println("inside no-arg const of RegBean");
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

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

	public String getRpass() {
		return rpass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	
	public String validate()
	{
		String res="";
				
		if(uname==null || uname.trim().equals(""))
		{
			res = res +"Name cannot be null<br/>";
		}	
		if(email==null || email.trim().equals(""))
		{
			res = res +"Email cannot be null<br/>";
		}
			
		if(pass==null || pass.trim().equals(""))
		{
			res = res + "Password cannot be null<br/>";
		}	
		if(pass!=null && !pass.equals(rpass))
		{
			res = res + "Pass!=rpass...<br/>";
		}
		if(res.equals(""))
			return Constants.SUCCESS;
		else
			return res;
	}

}
