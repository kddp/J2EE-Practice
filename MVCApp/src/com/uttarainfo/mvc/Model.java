package com.uttarainfo.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Model {

	public String register(RegBean rb) 
	{
		String result = rb.validate();
		if(!result.equals(Constants.SUCCESS))
			return result;
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
				System.out.println("going to insert");	 
				ps = con.prepareStatement("insert into reg_users(name,email,pwd)values(?,?,?)");
				ps.setString(1, rb.getUname());
				ps.setString(2,rb.getEmail());
				ps.setString(3, rb.getPass());
				ps.execute();
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
	}
	
