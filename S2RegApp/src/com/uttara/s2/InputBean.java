package com.uttara.s2;

public class InputBean {
	String email,uname;

	public InputBean() {
		System.out.println("inside IB constr");
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("inside setEmail() of IB "+email);
		this.email = email;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		System.out.println("inside setUname() of IB "+uname);
		this.uname = uname;
	}
	
}
