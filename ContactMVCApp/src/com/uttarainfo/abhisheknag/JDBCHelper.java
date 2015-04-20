package com.uttarainfo.abhisheknag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCHelper 
{	
	public static void close(ResultSet rs)
	{
		try
		{
			if(rs!=null)
				rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void close(Connection con)
	{
		try
		{
			if(con!=null)
				con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public static void close(Statement s)
	{
		try
		{
			if(s!=null)
				s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName(Constants.DRIVERNAME);
			con = DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PWD);
			System.out.println(con);
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
}

