package com.uttara.s2;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CityAction extends ActionSupport {

	List<String> cities = new ArrayList<String>();
	
	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	@Override
	public String execute() throws Exception {
		
		cities.add("Bengaluru");
		cities.add("mysuru");
		cities.add("tumkuru");
		
		return Action.SUCCESS;
	}
}
