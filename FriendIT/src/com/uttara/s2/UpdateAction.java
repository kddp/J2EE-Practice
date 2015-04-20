package com.uttara.s2;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements SessionAware
{
	RegBean editBean;
	Map<String,Object>session;

	public RegBean getEditBean() {
		return editBean;
	}

	public void setEditBean(RegBean editBean) {
		this.editBean = editBean;
	}
	
	@Override
	public String execute() throws Exception {
		Model m = new Model();
		String result = m.update(editBean);
		System.out.println("Result from update model()"+result);
		
		if (result.equals("success"))
		{
			addActionMessage("editaccount.success.mssg");
			return Action.SUCCESS;
		}
		else
			addActionError(getText("update.fail"));
		return "input";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;	
	}
}
