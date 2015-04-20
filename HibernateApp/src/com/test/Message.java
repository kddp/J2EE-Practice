package com.test;

import java.util.Date;

public class Message
{
	private String text;
	private Date dateOfCr;
	private long id;

	public Message() 
	{
		System.out.println("Inside Message() no-arg const");
	}
	
	public Message(String s,Date d)
	{
		System.out.println("Inside Message() arg const");
		text = s;
		dateOfCr = d;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDateOfCr() {
		return dateOfCr;
	}
	public void setDateOfCr(Date dateOfCr) {
		this.dateOfCr = dateOfCr;
	}
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOfCr == null) ? 0 : dateOfCr.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Message other = (Message) obj;
		if (dateOfCr == null) {
			if (other.dateOfCr != null)
				return false;
		} else if (!dateOfCr.equals(other.dateOfCr))
			return false;
		if (id != other.id)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	
}
