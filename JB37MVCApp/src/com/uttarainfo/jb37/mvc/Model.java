package com.uttarainfo.jb37.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Model {

	public String register(RegBean rb)
	{
		
		String uname = rb.getUname();
		String email = rb.getEmail();
		String pass = rb.getPass();
		String rpass = rb.getRpass();

		String msg = rb.validate();
		
		if(!msg.equals(Constants.SUCCESS))
		{
			System.out.println("user input validation has failed. msg = "+msg);
			return msg;
		}
		else
		{
			System.out.println("user input validation has succeeded..proceeding with business validations..");

			PreparedStatement ps = null;
			Connection con = null;
			ResultSet rs = null;
			String sql=null;
			
			  try {
				  con = JDBCHelper.getConnection();
				  if (con==null)
					  return "Erroru boss db erroru ";
				  
			      con.setAutoCommit(false);
			      sql = "select * from customer where email = ?";
			      ps = con.prepareStatement(sql);
			      ps.setString(1, email);
			      
			      ps.execute();
			      
			      rs = ps.getResultSet();
			      
			      if(rs.next())
			      {
			    	  System.out.println("duplicate email id");
			    	  return "Dabba duplicate fellow. Ushhaarrr...enter unique email id";
			      }
			      else
			      {
			    	  System.out.println("not a duplicate fellow. business validations successful");
			    	  
			    	  sql = "insert into customer(name,email,pass) values(?,?,?)";
			    	  
			    	  ps = con.prepareStatement(sql);
			    	  ps.setString(1, uname);
			    	  ps.setString(2, email);
			    	  ps.setString(3, pass);
			    	  ps.execute();
			    	  con.commit();
					  return Constants.SUCCESS;
			      }
			  		
			  }
			  catch (Exception e) {
				  if (con!=null)
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			      System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			      e.printStackTrace();
			      return "Problemo problem "+e.getMessage();
			  }
			  finally
			  {
				  JDBCHelper.close(rs);
				  JDBCHelper.close(ps);
				  JDBCHelper.close(con);
			  }
		}
	}

	public String authenticate(LoginBean lb) {
		// TODO Auto-generated method stub
		System.out.println("inside Models authenticate() ");
		
		String msg = lb.validate();
		
		if(!msg.equals(Constants.SUCCESS))
		{
			System.out.println("user input validation has failed. msg = "+msg);
			return msg;
		}
		else
		{
			System.out.println("user input validation has succeeded..proceeding with business validations..");
			

			PreparedStatement ps = null;
			Connection con = null;
			ResultSet rs = null;
			String sql=null;
			
			  try {
				  con = JDBCHelper.getConnection();
				  if (con==null)
					  return "Erroru boss db erroru ";
				  
			      con.setAutoCommit(false);
			      sql = "select * from customer where email = ? and pass=?";
			      ps = con.prepareStatement(sql);
			      ps.setString(1, lb.getEmail());
			      ps.setString(2, lb.getPass());
			      ps.execute();
			      
			      rs = ps.getResultSet();
			      
			      if(rs.next())
			      {
			    	  System.out.println("valid fellow");
			    	  return Constants.SUCCESS;
			      }
			      else
			      {
			    	  System.out.println("incorrect credentials");
					  return "Lo appa, your credentials are not correct. try again.";
			      }
			  		
			  }
			  catch (Exception e) {
				  if (con!=null)
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			      System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			      e.printStackTrace();
			      return "Problemo problem "+e.getMessage();
			  }
			  finally
			  {
				  JDBCHelper.close(rs);
				  JDBCHelper.close(ps);
				  JDBCHelper.close(con);
			  }
		}
		}
	
		public List<RegBean> getUsers()
		{
			System.out.println("inside Models authenticate() ");

				PreparedStatement ps = null;
				Connection con = null;
				ResultSet rs = null;
				String sql=null;
				RegBean rb = null;
				List<RegBean> al = new ArrayList<RegBean>();
				
				  try {
					  con = JDBCHelper.getConnection();
					  if (con==null)
						  return null;
					  
				      sql = "select * from customer";
				      ps = con.prepareStatement(sql);

				      ps.execute();
				      
				      rs = ps.getResultSet();
				      
				      while(rs.next())
				      {
				    	  rb = new RegBean();
				    	  rb.setEmail(rs.getString("email"));
				    	  rb.setPass("");
				    	  rb.setUname(rs.getString("name"));
				    	  al.add(rb);
				      }
				      return al;
				  }
				  catch (Exception e) {
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
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


