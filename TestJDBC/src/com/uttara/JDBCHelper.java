package com.uttara;

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
		Connection connection = null;
		try
		{
			Class.forName(Constant.DRIVERNAME);
			connection = DriverManager.getConnection(Constant.URL,Constant.UID,Constant.PWD);
			System.out.println(connection);
			return connection;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
}

