package com.uttara;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestApp {

	public static void main(String[] args) 
	{
		
		Connection con=null;
		PreparedStatement ps = null;
		try
		{			
			con = JDBCHelper.getConnection();
			
			if(con==null)
			{
				System.out.println("Oops Connection failed....Contact Admin");
				return;
			}
			
			ps = con.prepareStatement("insert into Friends(sl_no,name,email)values(?,?,?)");
			ps.setInt(1, 5);
			ps.setString(2,"Murti");
			ps.setString(3,"aman@gmail.com");
			ps.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		finally
		{
			JDBCHelper.close(ps);
			JDBCHelper.close(con);
		}

	}

}
