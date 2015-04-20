package com.dablu.ranjeet;

public class LoginBean {
	String email,pword;

	public LoginBean() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pword == null) ? 0 : pword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean other = (LoginBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pword == null) {
			if (other.pword != null)
				return false;
		} else if (!pword.equals(other.pword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", pword=" + pword + "]";
	}
	public String validate()
	{
	String msg="";
	if(email==null || email.trim().equals(""))
	{
		msg="email should not be null </br> ";
	}
	if(pword==null || pword.trim().equals(""))
	{
		msg+="password should not be null.";
	}
		if(msg.equals(""))
		{
			return "success";
		}
		else{
			return msg;
		}
	}

}
