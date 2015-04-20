package com.dablu.ranjeet;

public class RegBean {
private String name,email,pword,rpword;
	public RegBean()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRpword() {
		return rpword;
	}
	public void setRpword(String rpword) {
		this.rpword = rpword;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pword == null) ? 0 : pword.hashCode());
		result = prime * result + ((rpword == null) ? 0 : rpword.hashCode());
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
		RegBean other = (RegBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pword == null) {
			if (other.pword != null)
				return false;
		} else if (!pword.equals(other.pword))
			return false;
		if (rpword == null) {
			if (other.rpword != null)
				return false;
		} else if (!rpword.equals(other.rpword))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RegBean [name=" + name + ", email=" + email + ", pword="
				+ pword + ", rpword=" + rpword + "]";
	}
	public String validate()
	{
		String msg="";
		if(name==null || name.trim().equals(""))
		{
			msg="name should not be null </br> ";
		}
		if(email==null || !email.contains("@"))
		{
			msg+="email should have @ symbol </br>";
		}
		if(pword==null ||pword.trim().equals("") )
		{
			msg+="password should not be null </br> ";
		}
		if(rpword==null || rpword.trim().equals(""))
		{
			msg+="repeat password should not be null </br> ";
		}
		else
		if(!(pword.equals(rpword)))
		{
			msg+="repeat password didnot match </br> ";
		}
		if(!msg.equals(""))
		{
			return msg;
		}
		else
		{
			return "success";
		}
	}
	
}
