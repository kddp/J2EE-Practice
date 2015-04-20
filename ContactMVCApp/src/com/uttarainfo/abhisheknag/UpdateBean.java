package com.uttarainfo.abhisheknag;

public class UpdateBean 
{
	String uname,pass,email;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		
		if(res.equals(""))
			return Constants.SUCCESS;
		else
			return res;
	}

}
