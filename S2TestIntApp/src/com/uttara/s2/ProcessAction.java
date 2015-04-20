package com.uttara.s2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ProcessAction extends ActionSupport {

	File pic;
	String uname;
	boolean male;
	String content;
	String breaky;
	
	public String getBreaky() {
		return breaky;
	}
	public void setBreaky(String breaky) {
		this.breaky = breaky;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String execute() throws Exception {
		
		System.out.println("inside execute() of PA");
		System.out.println(pic.getAbsolutePath()+" "+pic.lastModified()+" "+pic.length());
		System.out.println("uname "+uname+ " gender "+male+" "+breaky);
		
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(pic));
			String line;
			while((line = br.readLine())!=null)
				content = content + line;
				
			return Action.SUCCESS;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return Action.ERROR;
		}
		
		
	}
	
}







