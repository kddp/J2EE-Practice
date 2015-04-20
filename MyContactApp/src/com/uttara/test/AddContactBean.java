package com.uttara.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddContactBean {
	
	
	private String name,email,phone,dob,tag,sex;
	public AddContactBean()
	{
		super();
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		AddContactBean other = (AddContactBean) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
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
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AddContactBean [name=" + name + ", email=" + email + ", phone="
				+ phone + ", dob=" + dob + ", tag=" + tag + ", sex=" + sex + "]";
	}
	public String validate()
	{
		String msg="";
		if(name==null || name.trim().equals(""))
		{
			msg="name should not be null </br>";
		}
		if(email==null || !vailidateemail(email))
		{
			msg+="email should have @ symbol and can have comma seperated email id</br>";
		}
		if(phone==null || phone.trim().equals("")|| !validateInt(phone))
		{
			msg+="phone number should not be null, it should have digit only and could have coma seperated ph </br>";
		}
		if(dob==null || dob.trim().equals("")|| !validateDate(dob))
		{
			msg+="dob should not be null and it should be in(dd/MM/YYYY) format</br> ";
		}
		if(tag==null || tag.trim().equals(""))
		{
			msg+="tag should not be null and it could be comma separated </br>";
		}
		if(sex==null || sex.trim().equals(""))
		{
			msg+="sex should not be null </br>";
		}
		if(msg.equals(""))
		{
			return "success";
		}
		else{
			return msg;
		}
	}
	private boolean vailidateemail(String email2) {
		ArrayList al1=new ArrayList();
		String [] sarr=email2.split(",");
		al1.add(sarr);
	    int num1=0;
	    try{
	    	for (String string : sarr) 
	    	{
				if(!string.contains("@"))
		        {
		        	num1++;
		        }
	    	}
	    }
	    catch(Exception e)
	    {
	    	return false;
	    }
	    if(num1==0)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	}
	public boolean validateDate(String date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	        sdf.parse(date);
	        return true;
	    }
	    catch(ParseException ex) {
	        return false;
	    }
	}
	    public boolean validateInt(String s) {
	    	ArrayList al=new ArrayList();
	    	String [] sarr=s.split(",");
	    	al.add(sarr);
	        int num1=0;
	        try{
	        	for (String string : sarr) 
	        	{
					if(num1==Integer.parseInt(string))
			        {
			        	num1++;        	
			        }
	        	}
	        }
	        catch(Exception e)
	        {
	        	return false;
	        }
	        if(num1==0)
	        {
	        	return true;
	        }
	        else
	        {
	        	return false;
	        }
	    }
	

}
