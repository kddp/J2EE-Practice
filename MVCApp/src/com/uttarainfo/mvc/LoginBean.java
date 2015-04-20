package com.uttarainfo.mvc;

public class LoginBean 
{
			private String email,pass;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}
		
		public String validate()
		{
			String msg="";

			if(email==null || email.trim().equals(""))
			{
				msg = msg + "Email Cannot be Empty!!!!<br/>";
			}
			if(pass==null || pass.trim().equals(""))
			{
				msg = msg + "Please Enter your Password!!!";
			}		
			if(msg.equals(""))
				return Constants.SUCCESS;
			else
				return msg;
		}
		
	}
