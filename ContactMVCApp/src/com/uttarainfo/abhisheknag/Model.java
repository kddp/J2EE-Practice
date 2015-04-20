package com.uttarainfo.abhisheknag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Model 
{

	public String register(RegBean rb) 
	{
		String result = rb.validate();
		System.out.println(result);
		if(!result.equals(Constants.SUCCESS))
			return result;
		else
		{
			PreparedStatement ps = null;
			PreparedStatement ps1 =null;
			Connection con = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				 if (con==null)
				 {
					 return "Oops Cannot connect to DB!!! ";
				 }
				 System.out.println("after connection with DB");
				 ps1 = con.prepareStatement("Select email from reg_users");
				 System.out.println("after select statement");
				 rs=ps1.executeQuery();
				if(rs.next())
				 {
					return "Email is already registered...Please enter another email... ";
				 }
				
				ps = con.prepareStatement("insert into reg_users(name,email,pwd)values(?,?,?)");
				System.out.println("Uname = "+rb.getUname()+" Email = "+rb.getEmail()+" Password = "+rb.getPass());
				ps.setString(1, rb.getUname());
				ps.setString(2, rb.getEmail());
				ps.setString(3, rb.getPass());
				ps.execute();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return"Oops Something went wrong "+e.getMessage();
				
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps);
				JDBCHelper.close(con);
			}
		}
		return result;
	}

	public String authenticate(LoginBean lb)
	{
			
		String result = lb.validate();
		if(!result.equals(Constants.SUCCESS))
		{
			return result;		
		}
		else
		{
			PreparedStatement ps = null;
			Connection con = null;
			ResultSet rs = null;
			try
			{
				con = JDBCHelper.getConnection();
				 if (con==null)
				 {
					 return "Oops Cannot connect to DB!!! ";
				 }
					 
				ps = con.prepareStatement("select * from reg_users where email = ? and pwd=?");
				ps.setString(1,lb.getEmail());
				ps.setString(2, lb.getPass());
				ps.execute();
				
				rs= ps.getResultSet();
				if(rs.next())
				{
					return Constants.SUCCESS;
				}
				else
				{
					return "Oops!!!Your Credintial did not Matched";
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return"Oops Something went wrong"+e.getMessage();
				
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps);
				JDBCHelper.close(con);
			}
		}
	}

	public List<RegBean> getUser() 
	{
		List<RegBean> l = new ArrayList<RegBean>();
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		RegBean rb =null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con == null)
			{
				return null;
			}
			else
			{
				ps = con.prepareStatement("select * from reg_users");
				ps.execute();
				
				rs = ps.getResultSet();
				while(rs.next())
				{
					rb = new RegBean();
					rb.setUname(rs.getString("name"));
					rb.setEmail(rs.getString("email"));
					l.add(rb);
				}
				return l;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps);
			JDBCHelper.close(con);
		}
	
	}

	public RegBean getDetails(String email) 
	{
		
			Connection con =null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			RegBean rb =null;
			try
			{
				con = JDBCHelper.getConnection();
				if(con == null)
				{
					return null;
				}
				else
				{
					ps = con.prepareStatement("select * from reg_users where email=?");
					ps.setString(1, email);
					ps.execute();
					
					rs = ps.getResultSet();
					while(rs.next())
					{
						rb = new RegBean();
						rb.setUname(rs.getString("name"));
						rb.setEmail(rs.getString("email"));
						rb.setPass(rs.getString("pwd"));
						
					}
					return rb;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps);
				JDBCHelper.close(con);
			}
		
		}

		public String update(UpdateBean ub)
		{
			String result = ub.validate();
			if(result.equals(Constants.SUCCESS))
			{
				Connection con =null;
				PreparedStatement ps = null;


				try
				{
					con = JDBCHelper.getConnection();
					if(con == null)
					{
						return null;
					}
					else
					{
						ps = con.prepareStatement("update reg_users set name=?,pwd=? where email=?");
						ps.setString(1, ub.getUname());
						ps.setString(2, ub.getPass());
						ps.setString(3, ub.getEmail());
						ps.execute();
						
						
						return Constants.SUCCESS;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return null;
				}
				finally
				{
					JDBCHelper.close(ps);
					JDBCHelper.close(con);
				}
			
			}
			else
			{
				return result;
			}
		}

		public String editContact(AddContactBean ab) 
		{
			String msg=ab.validate();
			if(!msg.contains(Constants.SUCCESS))
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
			try 
			{
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
			finally
			{
				try
				{
					JDBCHelper.close(ps_ins);
					JDBCHelper.close(ps_ins1);
					JDBCHelper.close(ps_ins2);
					JDBCHelper.close(ps_ins3);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(rs);
					JDBCHelper.close(c);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
			     }
			return msg;
		}

		public ArrayList doListByName() 
		{
			Connection con = null;
			
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
			try 
			{
				con = JDBCHelper.getConnection();
				{
					if(con==null)
					{
						throw new SQLException("Oops!!! Cannot Connect to DB...Plz Contact Admin!!!");
					}
				}
				System.out.println("database server started");
				ps_sel = con.prepareStatement("Select name from contact");
				ps_sel.execute();
				rs = ps_sel.getResultSet();	
				while(rs.next())
				{
					ts.add(rs.getString("name"));	
				} 
				System.out.println(ts);
				ps_sel1 = con.prepareStatement("Select sl_no from contact where name=?");
				for (Object o : ts) 
				{
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
				ps_sel2 = con.prepareStatement("Select email from contact_email where contact_email_sl_no=?");
				ps_sel3 = con.prepareStatement("Select phone from contact_phone where contact_phone_sl_no=?");
				ps_sel4 = con.prepareStatement("Select tag from contact_tag where contact_tag_sl_no=?");
				ps_sel5 = con.prepareStatement("Select * from contact where sl_no=?");
				for (Object o : al) 
				{
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
			} 
			catch (Exception e) 
			{
				System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
				e.printStackTrace();
			}
			finally
			{
					JDBCHelper.close(ps_ins);
					JDBCHelper.close(ps_ins1);
					JDBCHelper.close(ps_ins2);
					JDBCHelper.close(ps_sel);
					JDBCHelper.close(rs);
					JDBCHelper.close(con);
			}
			return albean;
			
		}

		public ArrayList doSearch(String string) 
		{
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
		
}	
