package com.uttara.s2;

public class Model {

	GetDetailBean beno;
	

	public GetDetailBean getDetail() 
	{
		System.out.println("inside model");
			beno.setEmail("nag@abhishek.com");
			beno.setAge(25);
			beno.setUname("Abhishek Nag");
		return beno;
	}

}
