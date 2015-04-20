package com.dablu.ranjeet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Mvc2Model {

		public String doRegistration(RegBean rb)
		{
			System.out.println("inside model do registration");
			String msg=rb.validate();
			System.out.println(msg);
			
			if(!msg.contains("success"))
			{
				return msg;
			}
			
			Connection c=null;
			PreparedStatement ps_ins=null;
			PreparedStatement ps_sel=null;
			ResultSet rs=null;
			System.out.println("inside model");
			try {
				c = JDBCHelper.getConnection();
				String name=rb.getName();
				String email=rb.getEmail();
				String pword=rb.getPword();
				String rpword=rb.getRpword();
				System.out.println("database server started");
				ps_sel=c.prepareStatement("Select email from registration");
					Set<String> hs=new HashSet<String>();
					rs=ps_sel.executeQuery();
					while(rs.next())
					{
						String email1=rs.getString("email");
						hs.add(email1);
					}
					System.out.println(hs);
					if(hs.contains(email))
					{
						return "email is already taken by someone try another one ";
					}
				 ps_ins=c.prepareStatement("insert into registration (name,email,pword,rpword)values(?,?,?,?)");
					ps_ins.setString(1, name);
					ps_ins.setString(2, email);
					ps_ins.setString(3, pword);
					ps_ins.setString(4, rpword);
					ps_ins.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 catch (Exception e) {
					System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
					e.printStackTrace();
			 	}
			finally{
				try{
					JDBCHelper.close(ps_ins);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(rs);
					JDBCHelper.close(c);
					}
					catch(Exception e){
						e.printStackTrace();
					}
			     }
			return msg;
			
			}

		public String doLogin(LoginBean lb) {
			String msg=lb.validate();
			if(!msg.contains("success"))
			{
				return msg;
			}
			
			Connection c=null;
			PreparedStatement ps_sel=null;
			ResultSet s=null;
			System.out.println("inside model dologin");
			try {
				c = JDBCHelper.getConnection();
				String email=lb.getEmail();
				String pword=lb.getPword();
				System.out.println("database server started");
				ps_sel=c.prepareStatement("Select pword from registration where email=?");
				ps_sel.setString(1, email);
				s=ps_sel.executeQuery();	
				String pword1=null;
				while(s.next())
				{
					pword1=s.getString("pword");
					System.out.println(pword1);
				}
				if(!pword.equals(pword1))
				{
					return "password is wrong please enter the correct password ";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 catch (Exception e) {
				System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
				e.printStackTrace();
		 	}
			finally{
				try{
					JDBCHelper.close(s);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(c);
					}
					catch(Exception e){
						e.printStackTrace();
					}
			     }
		return msg;
		}
		public String doEdit(EditBean eb, String em1) {
			String em=em1;
			System.out.println(em);
			System.out.println("inside model do update");
			String msg=eb.validate();
			System.out.println(msg);
			
			if(!msg.equals("success"))
			{
			 return msg;
			}
			Connection c=null;
			PreparedStatement ps_sel=null;
			ResultSet rs=null;
			System.out.println("inside model");
			try {
				c = JDBCHelper.getConnection();
				String name=eb.getName();
				String pword=eb.getPword();
				String rpword=eb.getRpword();
				System.out.println("database server started");
				ps_sel=c.prepareStatement("update registration set name=?,pword=?,rpword=? where email=?");
					ps_sel.setString(1, name);
					ps_sel.setString(2, pword);
					ps_sel.setString(3, rpword);
					ps_sel.setString(4, em);
					ps_sel.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 catch (Exception e) {
					System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
					e.printStackTrace();
			 	}
			finally{
				try{
					JDBCHelper.close(rs);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(c);
					}
					catch(Exception e){
						e.printStackTrace();
					}
			     }
			return msg;
		}

		
		public EditBean getUserDetails(String email) {
			Connection con = null;
			PreparedStatement ps_sel = null;
			ResultSet rs = null;
			EditBean bean  = null;
			try
			{
				con = JDBCHelper.getConnection();
				ps_sel = con.prepareStatement("select * from registration where email = ?");
				ps_sel.setString(1, email);
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();
				
				
				if(rs.next())
				{
					bean = new EditBean();
					bean.setName(rs.getString("name"));
					bean.setPword(rs.getString("pword"));
					bean.setRpword(rs.getString("rpword"));
					System.out.println(bean.getName());
					System.out.println(bean.getPword());
					System.out.println(bean.getRpword());
					
				}
				return bean;
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Oops something bad happened "+e.getMessage());
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}		
		
		}

		public String editContact(AddContactBean ab) {
			String msg=ab.validate();
			if(!msg.contains("success"))
			{
				return msg;
			}
			
			Connection c=null;
			PreparedStatement ps_ins=null;
			PreparedStatement ps_ins1=null;
			PreparedStatement ps_ins2=null;
			PreparedStatement ps_ins3=null;
			PreparedStatement ps_sel=null;
			ResultSet rs=null;
			Integer s=null;
			System.out.println("inside model");
			try {
				c = JDBCHelper.getConnection();
				String name=ab.getName();
				String email=ab.getEmail();
				String phone=ab.getPhone();
				String tag=ab.getTag();
				String dob=ab.getDob();
				String sex=ab.getSex();
				System.out.println("database server started");
				 ps_ins=c.prepareStatement("insert into contact (name,dob,sex)values(?,?,?)");
					ps_ins.setString(1, name);
					ps_ins.setString(2, dob);
					ps_ins.setString(3, sex);
					ps_ins.execute();
					ps_sel=c.prepareStatement("Select sl_no from contact where name=? and dob=? and sex=?");
					ps_sel.setString(1, name);
					ps_sel.setString(2, dob);
					ps_sel.setString(3, sex);
					ps_sel.execute();
					rs = ps_sel.getResultSet();	
					if(rs.next())
					{
						s=(rs.getInt("sl_no"));
						System.out.println(s);
					}
					ps_ins1=c.prepareStatement("insert into contact_email(contact_email_sl_no,email)values(?,?)");
					String [] sarr=email.split(",");
					System.out.println(sarr);
					for (String string : sarr) {
						ps_ins1.setInt(1, s);
						ps_ins1.setString(2, string);
						ps_ins1.execute();
					}
					ps_ins2=c.prepareStatement("insert into contact_phone(contact_phone_sl_no,phone)values(?,?)");
					String [] sarr1=phone.split(",");
					System.out.println(sarr1);
					for (String string : sarr1) {
						ps_ins2.setInt(1, s);
						ps_ins2.setString(2, string);
						ps_ins2.execute();
					}
					ps_ins3=c.prepareStatement("insert into contact_tag(contact_tag_sl_no,tag)values(?,?)");
					String [] sarr2=tag.split(",");
					System.out.println(sarr2);
					for (String string : sarr2) {
						ps_ins3.setInt(1, s);
						ps_ins3.setString(2, string);
						ps_ins3.execute();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 catch (Exception e) {
					System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
					e.printStackTrace();
			 	}
			finally{
				try{
					JDBCHelper.close(ps_ins);
					JDBCHelper.close(ps_ins1);
					JDBCHelper.close(ps_ins2);
					JDBCHelper.close(ps_ins3);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(rs);
					JDBCHelper.close(c);
					}
					catch(Exception e){
						e.printStackTrace();
					}
			     }
			return msg;
			
		}

		public ArrayList doSearch(String string) {
			Connection con = null;
			PreparedStatement ps_sel = null;
			ResultSet rs = null;
			AddContactBean bean  = null;
			ArrayList al=new ArrayList();
			ArrayList al1=new ArrayList();
			try
			{
				con = JDBCHelper.getConnection();
				ps_sel = con.prepareStatement("select  distinct sl_no as sl_no, name as name,dob,sex, phone as phonenumber,email as email,tag as tag from contact,contact_phone,contact_email,contact_tag where sl_no =contact_phone_sl_no and sl_no=contact_email_sl_no and sl_no= contact_tag_sl_no");
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				while(rs.next())
				{
					bean = new AddContactBean();
					bean.setName(rs.getString("name"));
					bean.setDob(rs.getString("dob"));
					bean.setSex(rs.getString("sex"));
					bean.setEmail(rs.getString("email"));
					bean.setPhone(rs.getString("phone"));
					bean.setTag(rs.getString("tag"));
					al.add(bean);
				}
				System.out.println(al);
				for (Object object : al) {
					AddContactBean b=(AddContactBean)object;
					if(b.getName().contains(string)||b.getEmail().contains(string)||b.getDob().contains(string)|| b.getPhone().contains(string)|| b.getTag().contains(string)||b.getSex().contains(string))
					{
						al1.add(b);
					}
				}
				System.out.println(al1);
				return al1;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Oops something bad happened "+e.getMessage());
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}				
		}

		public ArrayList doList() {
			Connection con = null;
			PreparedStatement ps_sel = null;
			ResultSet rs = null;
			AddContactBean bean  = null;
			ArrayList al=new ArrayList();
			try
			{
				con = JDBCHelper.getConnection();
				ps_sel = con.prepareStatement("select  distinct sl_no as sl_no, name as name,dob,sex, phone as phonenumber,email as email,tag as tag from contact,contact_phone,contact_email,contact_tag where sl_no =contact_phone_sl_no and sl_no=contact_email_sl_no and sl_no= contact_tag_sl_no");
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				while(rs.next())
				{
					bean = new AddContactBean();
					bean.setName(rs.getString("name"));
					bean.setDob(rs.getString("dob"));
					bean.setSex(rs.getString("sex"));
					bean.setEmail(rs.getString("email"));
					bean.setPhone(rs.getString("phone"));
					bean.setTag(rs.getString("tag"));
					al.add(bean);
				}
				return al;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Oops something bad happened "+e.getMessage());
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}				
		}

		public AddContactBean doSearchForEdit(String string) {
			Connection con = null;
			PreparedStatement ps_sel = null;
			PreparedStatement ps_sel1 = null;
			ResultSet rs = null;
			PreparedStatement ps_sel2 = null;
			PreparedStatement ps_sel3 = null;
			PreparedStatement ps_sel4 = null;
			AddContactBean bean  = null;
			ArrayList al=new ArrayList();
			ArrayList al1=new ArrayList();
			ArrayList al2=new ArrayList();
			ArrayList al3=new ArrayList();
			Integer sl_no=null;
			try
			{
				con = JDBCHelper.getConnection();
				ps_sel1=con.prepareStatement("Select sl_no from contact where name=?");
				ps_sel1.setString(1, string);
				ps_sel1.execute();
				rs = ps_sel1.getResultSet();	
				while(rs.next())
				{
					sl_no=rs.getInt("sl_no");
					System.out.println(sl_no);	
				}
				ps_sel2=con.prepareStatement("Select email from contact_email where contact_email_sl_no=?");
				ps_sel2.setInt(1, sl_no);
				ps_sel2.execute();
				rs = ps_sel2.getResultSet();	
				while(rs.next())
				{
					al1.add(rs.getString("email"));
					System.out.println(al1);
				}
				ps_sel3=con.prepareStatement("Select phone from contact_phone where contact_phone_sl_no=?");
				ps_sel3.setInt(1, sl_no);
				ps_sel3.execute();
				rs = ps_sel3.getResultSet();	
				while(rs.next())
				{
					al2.add(rs.getString("phone"));
					System.out.println(al2);
				}
				ps_sel4=con.prepareStatement("Select tag from contact_tag where contact_tag_sl_no=?");
				ps_sel4.setInt(1, sl_no);
				ps_sel4.execute();
				rs = ps_sel4.getResultSet();	
				while(rs.next())
				{
					al3.add(rs.getString("tag"));
					System.out.println(al3);
				}
				ps_sel = con.prepareStatement("select * from contact where sl_no=?");
				ps_sel.setInt(1, sl_no);
				ps_sel.execute();
				rs = ps_sel.getResultSet();
				while(rs.next())
				{
					bean = new AddContactBean();
					bean.setName(rs.getString("name"));
					bean.setDob(rs.getString("dob"));
					bean.setSex(rs.getString("sex"));
				}
				bean.setEmail(al1.toString());
				bean.setPhone(al2.toString());
				bean.setTag(al3.toString());
				return bean;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Oops something bad happened "+e.getMessage());
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}				
		}

		public String updatetab(AddContactBean ab) {
			System.out.println("ya in table update");
			String msg=ab.validate();
			if(!msg.contains("success"))
			{
				return msg;
			}
			
			Connection c=null;
			PreparedStatement ps_ins=null;
			PreparedStatement ps_ins1=null;
			PreparedStatement ps_ins2=null;
			PreparedStatement ps_ins3=null;
			PreparedStatement ps_sel=null;
			ResultSet rs=null;
			Integer sl_no=null;
			System.out.println("inside model");
			try {
				c = JDBCHelper.getConnection();
				String name1=ab.getName();
				System.out.println(name1);
				String email=ab.getEmail();
				String phone=ab.getPhone();
				String tag=ab.getTag();
				String dob=ab.getDob();
				String sex=ab.getSex();
				System.out.println("database server started");
				ps_sel=c.prepareStatement("Select sl_no from contact where name=?");
				ps_sel.setString(1, name1);
				ps_sel.execute();
				rs = ps_sel.getResultSet();	
				while(rs.next())
				{
					sl_no=rs.getInt("sl_no");
					System.out.println(sl_no);	
				}
				 ps_ins=c.prepareStatement("update contact set dob=?,sex=? where name=?");
					ps_ins.setString(1, dob);
					ps_ins.setString(2, sex);
					ps_ins.setString(3, name1);
					ps_ins.execute();
					
					ps_ins1=c.prepareStatement("update contact_email set email=? where contact_email_sl_no=?");
					String [] sarr=email.split(",");
					System.out.println(sarr);
					for (String string : sarr) {
						
						ps_ins1.setString(1, string);
						ps_ins1.setInt(2, sl_no);
						ps_ins1.execute();
					}
					ps_ins2=c.prepareStatement("update contact_phone set phone=? where contact_phone_sl_no=?");
					String [] sarr1=phone.split(",");
					System.out.println(sarr1);
					for (String string : sarr1) {
						ps_ins2.setString(1, string);
						ps_ins2.setInt(2, sl_no);
						ps_ins2.execute();
					}
					ps_ins3=c.prepareStatement("update contact_tag set tag=? where contact_tag_sl_no=?");
					String [] sarr2=tag.split(",");
					System.out.println(sarr2);
					for (String string : sarr2) {
						ps_ins3.setInt(2, sl_no);
						ps_ins3.setString(1, string);
						ps_ins3.execute();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 catch (Exception e) {
					System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
					e.printStackTrace();
			 	}
			finally{
				try{
					JDBCHelper.close(ps_ins);
					JDBCHelper.close(ps_ins1);
					JDBCHelper.close(ps_ins2);
					JDBCHelper.close(ps_ins3);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(rs);
					JDBCHelper.close(c);
					}
					catch(Exception e){
						e.printStackTrace();
					}
			     }
			return msg;
			
		}

		public void doDelete(String name2) {
			Connection c=null;
			PreparedStatement ps_ins=null;
			PreparedStatement ps_ins1=null;
			PreparedStatement ps_ins2=null;
			PreparedStatement ps_ins3=null;
			PreparedStatement ps_sel=null;
			ResultSet rs=null;
			Integer sl_no=null;
			System.out.println("inside model");
			try {
				c = JDBCHelper.getConnection();
				System.out.println("database server started");
				ps_sel=c.prepareStatement("Select sl_no from contact where name=?");
				ps_sel.setString(1, name2);
				ps_sel.execute();
				rs = ps_sel.getResultSet();	
				while(rs.next())
				{
					sl_no=rs.getInt("sl_no");
					System.out.println(sl_no);	
				} 
					ps_ins1=c.prepareStatement("delete from contact_tag  where Contact_tag_sl_no=?");
						ps_ins1.setInt(1, sl_no);
						ps_ins1.execute();
					ps_ins2=c.prepareStatement("delete from contact_phone where contact_phone_sl_no=?");
						
						ps_ins2.setInt(1, sl_no);
						ps_ins2.execute();
					ps_ins3=c.prepareStatement("delete from contact_email where contact_email_sl_no=?");
						ps_ins3.setInt(1, sl_no);
						ps_ins3.execute();
					ps_ins=c.prepareStatement("delete from contact where sl_no=?");
					ps_ins.setInt(1, sl_no);
					ps_ins.execute();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 catch (Exception e) {
					System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
					e.printStackTrace();
			 	}
			finally{
				try{
					JDBCHelper.close(ps_ins);
					JDBCHelper.close(ps_ins1);
					JDBCHelper.close(ps_ins2);
					JDBCHelper.close(ps_ins3);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(rs);
					JDBCHelper.close(c);
					}
					catch(Exception e){
						e.printStackTrace();
					}
			     }
		}

		public ArrayList doListByName() 
		{
			
			Connection c=null;
			PreparedStatement ps_ins=null;
			PreparedStatement ps_ins1=null;
			PreparedStatement ps_ins2=null;
			PreparedStatement ps_sel1=null;
			PreparedStatement ps_sel=null;
			PreparedStatement ps_sel2=null;
			PreparedStatement ps_sel3=null;
			PreparedStatement ps_sel4=null;
			PreparedStatement ps_sel5=null;
			ResultSet rs=null;
			Integer sl_no=null;
			TreeSet ts=new TreeSet();
			ArrayList al=new ArrayList();
			ArrayList al1=new ArrayList();
			ArrayList al2=new ArrayList();
			ArrayList al3=new ArrayList();
			AddContactBean bean=new AddContactBean();
			ArrayList albean=new ArrayList();
			System.out.println("inside model");
			try {
				c = JDBCHelper.getConnection();
				System.out.println("database server started");
				ps_sel=c.prepareStatement("Select name from contact");
				ps_sel.execute();
				rs = ps_sel.getResultSet();	
				while(rs.next())
				{
					ts.add(rs.getString("name"));	
				} 
				System.out.println(ts);
				ps_sel1=c.prepareStatement("Select sl_no from contact where name=?");
				for (Object o : ts) {
					String s=(String)o;
					ps_sel1.setString(1, s);
					ps_sel1.execute();
					rs = ps_sel1.getResultSet();	
					while(rs.next())
					{
						sl_no=rs.getInt("sl_no");
						al.add(sl_no);
					} 	
				}
				System.out.println(al);
				ps_sel2=c.prepareStatement("Select email from contact_email where contact_email_sl_no=?");
				ps_sel3=c.prepareStatement("Select phone from contact_phone where contact_phone_sl_no=?");
				ps_sel4=c.prepareStatement("Select tag from contact_tag where contact_tag_sl_no=?");
				ps_sel5=c.prepareStatement("Select * from contact where sl_no=?");
				for (Object o : al) {
					int s=(Integer)o;
					ps_sel2.setInt(1, s);
					ps_sel2.execute();
					rs = ps_sel2.getResultSet();	
					while(rs.next())
					{
						al1.add(rs.getString("email"));
					} 	
					System.out.println(al1.toString());
					ps_sel3.setInt(1, s);
					ps_sel3.execute();
					rs = ps_sel3.getResultSet();	
					while(rs.next())
					{
						al2.add(rs.getString("phone"));
					} 	
				System.out.println(al2.toString());
					ps_sel4.setInt(1, s);
					ps_sel4.execute();
					rs = ps_sel4.getResultSet();	
					while(rs.next())
					{
						al3.add(rs.getString("tag"));
					} 
					System.out.println(al3.toString());	
				ps_sel5.setInt(1, s);
				ps_sel5.execute();
				rs = ps_sel5.getResultSet();
				while(rs.next())
				{
					bean = new AddContactBean();
					bean.setName(rs.getString("name"));
					System.out.println(bean.getName());
					bean.setDob(rs.getString("dob"));
					bean.setSex(rs.getString("sex"));
				}
				bean.setEmail(al1.toString());
				System.out.println(bean.getEmail());
				bean.setPhone(al2.toString());
				System.out.println(bean.getPhone());
				bean.setTag(al3.toString());
				System.out.println(bean.getTag());
				albean.add(bean);
				al1.clear();
				al2.clear();
				al3.clear();
				
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 catch (Exception e) {
					System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
					e.printStackTrace();
			 	}
			finally{
				try{
					JDBCHelper.close(ps_ins);
					JDBCHelper.close(ps_ins1);
					JDBCHelper.close(ps_ins2);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(rs);
					JDBCHelper.close(c);
					}
					catch(Exception e){
						e.printStackTrace();
					}
			     }
			return albean;
			
		}
		}
	

