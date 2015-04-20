package com.uttara.s2;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;

import com.opensymphony.xwork2.Action;
import com.uttara.s2.JDBCHelper;

public class Model {


	public String validateEmail(String email) 
	{
		System.out.println("inside validateEmail() of Model");
		
		Connection con = null; 
		PreparedStatement ps_sel = null; 
		PreparedStatement ps_ins=null;
		ResultSet rs = null;
		
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
			{
				return "db.connection.problem";
			}
			else
			{
				con.setAutoCommit(false);
				ps_sel = con.prepareStatement("select * from users where email = ?");
				ps_sel.setString(1, email);
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();
				
				if(rs.next())
				{
					return "registerview.email.duplicate";
				}	
				else
					return "success";
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "db.problem";
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_ins);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}
	}

	public String register(RegBean bean) 
	{
		System.out.println("inside register() of Model");
		
		Connection con = null; 
		PreparedStatement ps_ins1 = null;
		PreparedStatement ps_ins2 = null;
		PreparedStatement ps_ins3 = null;
		PreparedStatement ps_sel = null;
		ResultSet rs =null;
		Integer n = null;
		try
		{
			Date dt = new Date();
			DateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String myDate = formate.format(dt);
			String myDOB = formate.format(bean.getDob());
				
			/*File imgfile = new File(bean.getPic().getAbsolutePath());
			FileInputStream fin = new FileInputStream(imgfile);*/
			
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(bean.getPic())) ;
						
			con = JDBCHelper.getConnection();

			if(con==null)
			{
				return "db.connection.problem";
			}
			else
			{
				ps_ins1 = con.prepareStatement("insert into users (email,pass)values(?,?)");
				ps_ins1.setString(1, bean.getEmail());
				ps_ins1.setString(2, bean.getPass());
				ps_ins1.execute();
				
				ps_sel = con.prepareStatement("Select sl_no from users where email=? and pass=?");
				ps_sel.setString(1, bean.getEmail());
				ps_sel.setString(2, bean.getPass());
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();	
				if(rs.next())
				{
					n = (rs.getInt("sl_no"));
					     System.out.println("inserting into coloumn number =>"+n);
				}
				ps_ins2 = con.prepareStatement("insert into userdetails(user_sl,fname,lname,gender,dob,cr_dt)values(?,?,?,?,?,?)");
				ps_ins2.setInt(1, n);
				ps_ins2.setString(2, bean.getFname());
				ps_ins2.setString(3, bean.getLname());
				ps_ins2.setString(4, bean.getGender());
				ps_ins2.setString(5, myDOB);
				ps_ins2.setString(6, myDate);
				ps_ins2.execute();
				 
				ps_ins3 = con.prepareStatement("insert into profile(user_sl,moreme,pic)values(?,?,?)");
				ps_ins3.setInt(1, n);
				ps_ins3.setString(2, bean.getMoreAbtMe());
				ps_ins3.setBinaryStream(3, bin);
				ps_ins3.execute();
				
				con.commit();
				return Action.SUCCESS;
			}
		}
		catch(SQLException | FileNotFoundException e)
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			return "db.problem";
		}
		finally
		{
			JDBCHelper.close(ps_ins1);
			JDBCHelper.close(ps_ins2);
			JDBCHelper.close(ps_ins3);
			JDBCHelper.close(con);
		}
	}

	public String authenticate(LoginBean bean) 
	{
		System.out.println("inside authenticate() of Model");
		
		Connection con = null; 
		PreparedStatement ps_sel = null; 
		ResultSet rs = null;
		
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
			{
				return "db.connection.problem";
			}
			else
			{
				ps_sel = con.prepareStatement("select * from users where email=? and pass=?");
				
				ps_sel.setString(1, bean.getEmail());
				ps_sel.setString(2, bean.getPass());
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();
				
				if(rs.next())
				{
					return Action.SUCCESS;
				}	
				else
					return "missmatch.email.pass";
					
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "db.problem";
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}
	}

	public OutputBean getDetails(String email,String pass)
	{
		System.out.println("inside getDetails of Model");
		
		Connection con = null; 
		PreparedStatement ps_sel1 = null; 
		ResultSet rs = null;
		ResultSet rs1 = null;
		OutputBean outBean = new OutputBean();
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
			{
				throw new SQLException();
			}
			else
			{
				ps_sel1 = con.prepareStatement("select * from users u,userdetails ud,profile p where u.sl_no=ud.user_sl and u.sl_no=p.user_sl and email=?");				
				ps_sel1.setString(1, email);
				
				ps_sel1.execute();
				
				rs = ps_sel1.getResultSet();				
				if(rs.next())
				{
										
					Blob blob = rs.getBlob("Pic");
					int blobLength = (int) blob.length();
	               
	                System.out.println("Length of blob in bytes =>"+blobLength);
	                
	                File file = new File("image.jpg");
	                
	                byte[] blobAsBytes = blob.getBytes(1, blobLength);
	                
	                System.out.println("Getting data from blob"+blobAsBytes);
	            
	                System.out.println("File path = "+file.getAbsolutePath());
	                
	                BufferedImage image = ImageIO.read( new ByteArrayInputStream( blobAsBytes ) ); 
	                ImageIO.write(image, "JPEG", file);		
					
					outBean.setFname(rs.getString("FNAME"));
					outBean.setLname(rs.getString("LNAME"));
					outBean.setDob(rs.getDate("DOB"));
					outBean.setGender(rs.getString("GENDER"));
					outBean.setMoreAbtMe(rs.getString("MOREME"));
					outBean.setPic(file);
					outBean.setCr_dt(rs.getDate("CR_DT"));
					outBean.setEmail(rs.getString("EMAIL"));
					outBean.setPass(rs.getString("PASS"));
					
					System.out.println("inside while() of retriving data =>"+rs.getString("FNAME")+" "+rs.getString("LNAME"));
				}	
				return outBean;		
			}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
			//return "db.problem";
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(rs1);
			JDBCHelper.close(ps_sel1);
			JDBCHelper.close(con);
		}
		return null;
	}

	public String logout(Map<String, Object> session) {
		
		OutputBean b = (OutputBean)session.get("userDetails");
		System.out.println(b.getEmail()+b.getFname());
		System.out.println("before removing from session....=>"+session);
		
		session.remove("userDetails");
		session.remove("posts");

		System.out.println("after removing from session.... =>"+session);
		return "success";
	}

	public String checkSession(Map<String, Object> session) {
		Boolean b = session.isEmpty();
		if(b==true)
			return "isLogout";
		return Action.SUCCESS;
		
	}

	public RegBean editAccount(String email, String pass) 
	{
		System.out.println("inside getDetails of Model");
		
		Connection con = null; 
		PreparedStatement ps_sel = null; 
		ResultSet rs = null;
		RegBean outBean = new RegBean();
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
			{
				throw new SQLException();
			}
			else
			{
				ps_sel = con.prepareStatement("select * from users u,userdetails ud,profile p where u.sl_no=ud.user_sl and u.sl_no=p.user_sl and email=?");
				
				ps_sel.setString(1, email);
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();				
				while(rs.next())
				{
					Blob blob = rs.getBlob("Pic");
					int blobLength = (int) blob.length();
	               
	                System.out.println("Length of blob in bytes =>"+blobLength);
	                File file = new File("C:/image.JPG");
	                byte[] blobAsBytes = blob.getBytes(1, blobLength);
	                System.out.println("Getting data from blob"+blobAsBytes);
	                BufferedImage image = ImageIO.read( new ByteArrayInputStream( blobAsBytes ) ); 
	                ImageIO.write(image, "JPEG", file);	
								        
					outBean.setFname(rs.getString("FNAME"));
					outBean.setLname(rs.getString("LNAME"));
					outBean.setDob(rs.getDate("DOB"));
					outBean.setGender(rs.getString("GENDER"));
					outBean.setMoreAbtMe(rs.getString("MOREME"));
					outBean.setPic(file);
					outBean.setRpass(rs.getString("PASS"));
					outBean.setEmail(rs.getString("EMAIL"));
					outBean.setPass(rs.getString("PASS"));
					System.out.println("inside while() of retriving data =>"+rs.getString("FNAME")+" "+rs.getString("LNAME"));
			
				}	
				return outBean;		
			}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
			//return "db.problem";
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
		}
		return null;
	}

	public String update(RegBean editBean) 
	{
		System.out.println("inside register() of Model");
		
		Connection con = null; 
		PreparedStatement ps_ins1 = null;
		PreparedStatement ps_ins2 = null;
		PreparedStatement ps_ins3 = null;
		PreparedStatement ps_sel = null;
		ResultSet rs =null;
		Integer n = null;
		try
		{
			DateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String myDOB = formate.format(editBean.getDob());
				
			
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(editBean.getPic())) ;
						
			con = JDBCHelper.getConnection();

			if(con==null)
			{
				return "db.connection.problem";
			}
			else
			{
				ps_ins1 = con.prepareStatement("update users set pass=? where email=?");
				ps_ins1.setString(1, editBean.getPass());
				ps_ins1.setString(2, editBean.getEmail());
				ps_ins1.execute();
				
				ps_sel = con.prepareStatement("Select sl_no from users where email=?");
				ps_sel.setString(1, editBean.getEmail());
				ps_sel.execute();
				
				rs = ps_sel.getResultSet();	
				if(rs.next())
				{
					n = (rs.getInt("sl_no"));
					     System.out.println("updateing into coloumn number =>"+n);
				}
				ps_ins2 = con.prepareStatement("update userdetails set fname=?,lname=?,gender=?,dob=? where user_sl=?");
				ps_ins2.setString(1, editBean.getFname());
				ps_ins2.setString(2, editBean.getLname());
				ps_ins2.setString(3, editBean.getGender());
				ps_ins2.setString(4, myDOB);
				ps_ins2.setInt(5, n);
				ps_ins2.execute();
				 
				ps_ins3 = con.prepareStatement("update profile set moreme=?,pic=? where user_sl=? ");
				ps_ins3.setString(1,editBean.getMoreAbtMe());
				ps_ins3.setBlob(2, bin);
				ps_ins3.setInt(3, n);
				ps_ins3.execute();
				
				con.commit();
				return Action.SUCCESS;
			}
		}
		catch(SQLException | FileNotFoundException e)
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			return "db.problem";
		}
		finally
		{
			JDBCHelper.close(ps_ins1);
			JDBCHelper.close(ps_ins2);
			JDBCHelper.close(ps_ins3);
			JDBCHelper.close(con);
		}
	}

	public ArrayList<PostBean> getPost(String email,String pass) 
	{
		System.out.println("inside getPost() of Model");
		Connection con = null; 
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Integer n = null;
		PostBean b;
		ArrayList<PostBean> al = new ArrayList<PostBean>();
		
		try
		{					
			con = JDBCHelper.getConnection();

			if(con==null)
			{
				throw new SQLException();
			}
			else
			{
				ps1 = con.prepareStatement("select sl_no from users where email=? and pass=?");
				ps1.setString(1, email);
				ps1.setString(2, pass);
				ps1.execute();
				
				rs1 = ps1.getResultSet();
				if(rs1.next())
				{
					n = rs1.getInt("sl_no");
				}
				System.out.println("Value of N inside getPost is =>"+n);
				
				ps2 = con.prepareStatement("select * from post where to_user_sl=? order by cr_dt desc");
				ps2.setInt(1, n);
				ps2.execute();
				
				rs2 = ps2.getResultSet();
			
				System.out.println("Going inside while ");
				
				while(rs2.next())
				{
					System.out.println("Inside while()");
					
					b = new PostBean();
					
					int num = rs2.getInt("FROM_USER_SL");
				
					ps1 = con.prepareStatement("select fname,lname from userDetails where user_sl=?");
					ps1.setInt(1, num);
					ps1.execute();
					
					
					rs1 = ps1.getResultSet();
					String name = null;
					String lname = null;
					
					while(rs1.next())
					{
						name = rs1.getString("FNAME");
						lname = rs1.getString("LNAME");
						System.out.println("Name of the Sender of the post is =>"+name+" "+lname);
						b.setFrom(name+" "+lname);
					}
					
					b.setPost(rs2.getString("POST"));
					b.setD(rs2.getDate("CR_DT"));
					b.setT(rs2.getTime("CR_DT"));
					al.add(b);
				}

				System.out.println("Data inside List is =>"+al);
				
				return al;
			}
		}
		catch(SQLException  e)
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			JDBCHelper.close(ps1);
			JDBCHelper.close(ps2);
			JDBCHelper.close(rs1);
			JDBCHelper.close(rs2);
			JDBCHelper.close(con);
		}			
		return null;	
	}

	public ArrayList<PostBean> getMssgs(String email, String pass) 
	{
		System.out.println("inside getMssgs() of Model");
		Connection con = null; 
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Integer n = null;
		PostBean b;
		ArrayList<PostBean> al = new ArrayList<PostBean>();
		
		try
		{					
			con = JDBCHelper.getConnection();

			if(con==null)
			{
				throw new SQLException();
			}
			else
			{
				ps1 = con.prepareStatement("select sl_no from users where email=? and pass=?");
				ps1.setString(1, email);
					ps1.setString(2, pass);
				ps1.execute();
				
				rs1 = ps1.getResultSet();
				if(rs1.next())
				{
					n = rs1.getInt("sl_no");
				}
				System.out.println("Value of N inside getPost is =>"+n);
				
				ps2 = con.prepareStatement("select * from Message where to_user_sl=? order by cr_dt desc ");
				ps2.setInt(1, n);
				ps2.execute();
				
				rs2 = ps2.getResultSet();
			
				System.out.println("Going inside while ");
				while(rs2.next())
				{
					System.out.println("Inside while()");
					
					b = new PostBean();
					
					int num = rs2.getInt("FROM_USER_SL");
				
					ps1 = con.prepareStatement("select fname,lname from userDetails where user_sl=?");
					ps1.setInt(1, num);
					ps1.execute();
					
					
					rs1 = ps1.getResultSet();
					String name = null;
					String lname = null;
					
					while(rs1.next())
					{
						name = rs1.getString("FNAME");
						lname = rs1.getString("LNAME");
						System.out.println("Name of the Sender of the Mssage is =>"+name+" "+lname);
						b.setFrom(name+" "+lname);
					}
					
					b.setPost(rs2.getString("MSSG"));
					b.setD(rs2.getDate("CR_DT"));
					b.setT(rs2.getTime("CR_DT"));
					al.add(b);
				}

				System.out.println("Data inside List is =>"+al);
				
				return al;
			}
		}
		catch(SQLException  e)
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			JDBCHelper.close(ps1);
			JDBCHelper.close(ps2);
			JDBCHelper.close(rs1);
			JDBCHelper.close(rs2);
			JDBCHelper.close(con);
		}			
		return null;	
	}
	/*public ArrayList<PostBean> getFriends(String email, String pass) 
	{
		
	}*/

	public String postToMe(OutputBean bean, PostBean myPost) 
	{
		System.out.println("inside postToMe()");

		Connection con = null; 
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs1 = null;
		Integer n = null;
		PostBean b;
		Date dt;
		
		try
		{					
			con = JDBCHelper.getConnection();

			if(con==null)
			{
				throw new SQLException();
			}
			else
			{
				dt = new Date();
				System.out.println("Datetime At processing =>"+dt);
				
				DateFormat qw = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String a = qw.format(dt);
				System.out.println(a);
				
				
				con.setAutoCommit(false);
				ps1 = con.prepareStatement("select sl_no from users where email=? and pass=?");
				ps1.setString(1, bean.getEmail());
				ps1.setString(2,bean.getPass());
				ps1.execute();
				
				rs1 = ps1.getResultSet();
				if(rs1.next())
				{
					n = rs1.getInt("sl_no");
				}
				System.out.println("Value of N inside getPost is =>"+n);
				
				ps2 = con.prepareStatement("insert into post(from_user_sl,post,to_user_sl,cr_dt)values(?,?,?,?)");
				ps2.setInt(1, n);
				ps2.setString(2, myPost.getPost());
				ps2.setInt(3, n);
				ps2.setString(4,a);
				ps2.execute();
				con.commit();
				
				return Action.SUCCESS;
				
			}
		}
		catch(SQLException  e)
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			JDBCHelper.close(ps1);
			JDBCHelper.close(ps2);
			JDBCHelper.close(rs1);
			JDBCHelper.close(con);
		}			
		return null;
	}

	public OutputBean gotoFrndWall(String fname,String lname) 
	{
		System.out.println("inside getDetail of friend Model() to goto wall");
		
		Connection con = null; 
		PreparedStatement ps_sel1 = null; 
		PreparedStatement ps_sel2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int sl=0;
		
		OutputBean outBean = new OutputBean();
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
			{
				throw new SQLException();
			}
			else
			{
				ps_sel1 = con.prepareStatement("select user_sl from userdetails where fname=? and lname=?");
				ps_sel1.setString(1, fname);
				ps_sel1.setString(2, lname);
				ps_sel1.execute();
				
				rs1 = ps_sel1.getResultSet();
				
				if(rs1.next())
				{
					sl = rs1.getInt("USER_SL");
				}
				System.out.println("SL No of the friend is =>"+sl);
				
				ps_sel2 = con.prepareStatement("select * from users u,userdetails ud,profile p where u.sl_no=ud.user_sl and ud.user_sl=p.user_sl and user_sl=?");				
				ps_sel2.setInt(1, sl);
				ps_sel2.execute();
							
				rs2 = ps_sel2.getResultSet();				
				if(rs2.next())
				{
										
					Blob blob = rs2.getBlob("Pic");
					int blobLength = (int) blob.length();
	               
	                System.out.println("Length of blob in bytes =>"+blobLength);
	                
	                File file = new File("image.jpg");
	                
	                byte[] blobAsBytes = blob.getBytes(1, blobLength);
	                
	                System.out.println("Getting data from blob"+blobAsBytes);
	            
	                System.out.println("File path = "+file.getAbsolutePath());
	                
	                BufferedImage image = ImageIO.read( new ByteArrayInputStream( blobAsBytes ) ); 
	                ImageIO.write(image, "JPEG", file);		
					
					outBean.setFname(rs2.getString("FNAME"));
					outBean.setLname(rs2.getString("LNAME"));
					outBean.setDob(rs2.getDate("DOB"));
					outBean.setGender(rs2.getString("GENDER"));
					outBean.setMoreAbtMe(rs2.getString("MOREME"));
					outBean.setPic(file);
					outBean.setCr_dt(rs2.getDate("CR_DT"));	
					outBean.setEmail(rs2.getString("EMAIL"));
					outBean.setPass(rs2.getString("PASS"));
				}	
				return outBean;
			}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
			//return "db.problem";
		}
		finally
		{
			JDBCHelper.close(rs1);
			JDBCHelper.close(rs2);
			JDBCHelper.close(ps_sel1);
			JDBCHelper.close(ps_sel1);
			JDBCHelper.close(con);
		}
		return null;
	}

	public String postToFriend(String from, String to, PostBean post) 
	{
		System.out.println("inside postToMyFriend() of Model");
		System.out.println("MY EMAIL=>"+from);
		System.out.println("TO EMAIL=>"+to);
		System.out.println("POST =>"+post.getPost());
		
		Connection con = null; 
		PreparedStatement ps_sel1 = null; 
		PreparedStatement ps_sel2 = null;
		PreparedStatement ps_sel3 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int sender = 0;
		int reciever = 0;

		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
			{
				return "db.connection.problem";
			}
			else
			{
				ps_sel1 = con.prepareStatement("select sl_no from users where email=?");
				ps_sel1.setString(1, from);
				ps_sel1.execute();
				
				rs1 = ps_sel1.getResultSet();
				
				if(rs1.next())
				{
					sender = rs1.getInt("SL_NO");
				}
				System.out.println("SL No of the Sender =>"+sender);
				
				ps_sel2 = con.prepareStatement("select sl_no from users where email=?");				
				ps_sel2.setString(1, to);
				ps_sel2.execute();
							
				rs2 = ps_sel2.getResultSet();				
				if(rs2.next())
				{
					reciever = rs2.getInt("SL_NO");				
				}	
				System.out.println("SL No of the Reciver =>"+reciever);
				
				Date dt = new Date();
				System.out.println("Datetime At processing =>"+dt);
				
				DateFormat qw = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String a = qw.format(dt);
				
				con.setAutoCommit(false);
				ps_sel3 = con.prepareStatement("insert into post (from_user_sl,post,to_user_sl,cr_dt)values(?,?,?,?)");
				ps_sel3.setInt(1, sender);
				ps_sel3.setString(2, post.getPost());
				ps_sel3.setInt(3, reciever);
				ps_sel3.setString(4, a);
				ps_sel3.execute();
				con.commit();
				return Action.SUCCESS;
			}
		}
		catch(SQLException  e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "db.problem";
		}
		finally
		{
			JDBCHelper.close(rs1);
			JDBCHelper.close(rs2);
			JDBCHelper.close(ps_sel1);
			JDBCHelper.close(ps_sel2);
			JDBCHelper.close(ps_sel3);
			JDBCHelper.close(con);
		}
	}

	public ArrayList<OutputBean> getFriends(String email, String pass) 
	{
		System.out.println("inside getFriend() of Model");		
		Connection con = null; 
		OutputBean b ;
		ArrayList<OutputBean>al = new ArrayList<OutputBean>();
		PreparedStatement ps_sel1 = null; 
		PreparedStatement ps_sel2 = null;
		PreparedStatement ps_sel3 = null;
		int sl=0;
		ResultSet rs3 = null;
		ResultSet rs2 = null;
		ResultSet rs1 = null;
		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
			{
				return null;
			}
			else
			{
				ps_sel1 = con.prepareStatement("select sl_no from users where email=? and pass=?");
				ps_sel1.setString(1, email);
				ps_sel1.setString(2, pass);
				ps_sel1.execute();
				
				rs1 = ps_sel1.getResultSet();
				
				if(rs1.next())
				{
					sl = rs1.getInt("SL_NO");
				}
				System.out.println("SL NO of the Login User is =>"+sl);
			
				ps_sel2 = con.prepareStatement("select to_user_sl from friend where from_user_sl=?");
				ps_sel2.setInt(1, sl);
				ps_sel2.execute();
				
				rs2 = ps_sel2.getResultSet();
				while(rs2.next())
				{
					int n = rs2.getInt("to_user_sl");
					System.out.println("SL NO of the friend is =>"+n);
					
					ps_sel3 = con.prepareStatement("select  fname,lname from userDetails where user_sl=?");
					ps_sel3.setInt(1, n);
					ps_sel3.execute();
					
					rs3 = ps_sel3.getResultSet();
					if(rs3.next())
					{
						b = new OutputBean();
						//b.setFname(rs3.getString("FNAME"));
						//b.setLname(rs3.getString("LNAME"));
						String name = rs3.getString("FNAME")+" "+rs3.getString("LNAME");
						b.setFname(name);
						System.out.println("Name =>"+name);
						//System.out.println("FNAME ="+rs3.getString("FNAME")+" LNAME="+rs3.getString("LNAME"));
						al.add(b);
					}					
				}
				return al;
			}
		}
		catch(Exception  e)
		{
			e.printStackTrace();
			try 
			{
				return null;
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			JDBCHelper.close(rs1);
			JDBCHelper.close(ps_sel1);
			JDBCHelper.close(con);
		}
		return null;
	}

	public String mssgToFriend(String from, String to, PostBean post) 
	{
		System.out.println("inside MssgToMyFriend() of Model");
		System.out.println("MY EMAIL=>"+from);
		System.out.println("TO EMAIL=>"+to);
		System.out.println("POST =>"+post.getPost());
		
		Connection con = null; 
		PreparedStatement ps_sel1 = null; 
		PreparedStatement ps_sel2 = null;
		PreparedStatement ps_sel3 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		int sender = 0;
		int reciever = 0;

		try
		{
			con = JDBCHelper.getConnection();
			if(con==null)
			{
				return "db.connection.problem";
			}
			else
			{
				ps_sel1 = con.prepareStatement("select sl_no from users where email=?");
				ps_sel1.setString(1, from);
				ps_sel1.execute();
				
				rs1 = ps_sel1.getResultSet();
				
				if(rs1.next())
				{
					sender = rs1.getInt("SL_NO");
				}
				System.out.println("SL No of the Sender =>"+sender);
				
				ps_sel2 = con.prepareStatement("select sl_no from users where email=?");				
				ps_sel2.setString(1, to);
				ps_sel2.execute();
							
				rs2 = ps_sel2.getResultSet();				
				if(rs2.next())
				{
					reciever = rs2.getInt("SL_NO");				
				}	
				System.out.println("SL No of the Reciver =>"+reciever);
				
				Date dt = new Date();
				System.out.println("Datetime At processing =>"+dt);
				
				DateFormat qw = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String a = qw.format(dt);
				
				con.setAutoCommit(false);
				ps_sel3 = con.prepareStatement("insert into message (from_user_sl,mssg,to_user_sl,cr_dt)values(?,?,?,?)");
				ps_sel3.setInt(1, sender);
				ps_sel3.setString(2, post.getPost());
				ps_sel3.setInt(3, reciever);
				ps_sel3.setString(4, a);
				ps_sel3.execute();
				con.commit();
				return Action.SUCCESS;
			}
		}
		catch(SQLException  e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "db.problem";
		}
		finally
		{
			JDBCHelper.close(rs1);
			JDBCHelper.close(rs2);
			JDBCHelper.close(ps_sel1);
			JDBCHelper.close(ps_sel2);
			JDBCHelper.close(ps_sel3);
			JDBCHelper.close(con);
		}
	}


	public String sendRequest(String[] email) 
	{
		System.out.println("Inside model sendRequest()");
		for(String s : email)
		{
			System.out.println("Emails =>"+s);
		}
		
		
		return Action.SUCCESS;
	}
}
