package com.uttara.s2;

import java.io.File;
import java.util.Date;

public class OutputBean 
{
	private String email,pass,rpass, fname,lname, gender, moreAbtMe;
	private File pic;
	private Date dob;
	private Date cr_dt;
	
	public Date getCr_dt() {
		return cr_dt;
	}
	public void setCr_dt(Date cr_dt) {
		this.cr_dt = cr_dt;
	}
	public String getMoreAbtMe() {
		return moreAbtMe;
	}
	public void setMoreAbtMe(String moreAbtMe) {
		this.moreAbtMe = moreAbtMe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		System.out.println("inside setEmail() "+email);
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		System.out.println("inside setPass() "+pass);
		this.pass = pass;
	}
	public String getRpass() {
		return rpass;
	}
	public void setRpass(String rpass) {
		this.rpass = rpass;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		System.out.println("inside setPic() "+pic);
		this.pic = pic;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
