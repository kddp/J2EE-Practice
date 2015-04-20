package com.uttarainfo.jb37.mvc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {

	
	public static void close(ResultSet rs)
	{
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
	public static void close(Statement stmt)
	{
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(Connection con)
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static Connection getConnection()
	{

		 Connection con = null;
		  try 
		  {
			 
			  Class.forName(Constants.DRIVERNAME);
		      con = DriverManager.getConnection(Constants.URL, Constants.UID, Constants.PWD);		
		      return con;
		  }
		  catch (Exception e) {
			  e.printStackTrace();
			  return null;
		  }
		  
	}
}
