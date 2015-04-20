package com.uttara.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MvcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside do get method");
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside do post method");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside process method");
		String uri=request.getRequestURI();
		System.out.println(uri);
		if(uri.contains("/openRegisterView"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/openLoginView"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/Register"))
		{
			RegBean rb=(RegBean) request.getAttribute("reg");
			System.out.println(rb.getName());
			MvcModel mm=new MvcModel();
			String msg=mm.doRegistration(rb);
			if(!msg.equals("success"))
			{
				System.out.println("unsuccess");
				request.setAttribute("error msg", msg);
				RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			}
			else{
			System.out.println("Success");
			String msg1=msg+" Registration";
			String link="<a href='HomePage.html'>click to go homePage</a>";
			request.setAttribute("suc msg", msg1);
			request.setAttribute("link",link);
			RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
			}
		}
		if(uri.contains("/Login"))
		{
			LoginBean lb=(LoginBean) request.getAttribute("reg");
			System.out.println(lb.getEmail());
			MvcModel mm=new MvcModel();
			String msg=mm.doLogin(lb);
			if(!msg.equals("success"))
			{
				request.setAttribute("error msg", msg);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			else{
				HttpSession s=request.getSession(true);
				s.setAttribute("email", lb.getEmail());
				s.setAttribute("password", lb.getPword());
			RequestDispatcher rd=request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
			}
		}
		if(uri.contains("/openEditAccView"))
		{
			HttpSession s = request.getSession(false);
			if(s!=null)
			{
				String email = (String) s.getAttribute("email");
				MvcModel mm=new MvcModel();
				EditBean eb =  (EditBean)mm.getUserDetails(email);
				request.setAttribute("userDetails", eb);
				RequestDispatcher rd=request.getRequestDispatcher("Edit.jsp");
				rd.forward(request, response);
			}
			else
			{
				String msg="your session is invalid try again to login";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
		}
		if(uri.contains("/Logout"))
		{
			HttpSession s=request.getSession();
			if(s!=null)
			{
			s.removeAttribute("email id");
			s.removeAttribute("password");
			s.invalidate();
			}
			RequestDispatcher rd=request.getRequestDispatcher("Logout.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/Edit"))
		{
			HttpSession s=request.getSession();
			String e=(String)s.getAttribute("email");
			EditBean eb=(EditBean) request.getAttribute("reg");
			MvcModel mm=new MvcModel();
			String msg=mm.doEdit(eb, e);
			if(msg.equals("success"))
			{
				String msg1=msg+" edition";
				String link="<a href='Menu.jsp'>go to menu</a>";
				request.setAttribute("suc msg", msg1);
				request.setAttribute("link",link);
				RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
			}
			else{
				String email = (String) s.getAttribute("email");
				mm=new MvcModel();
				eb =  (EditBean)mm.getUserDetails(email);
				request.setAttribute("error msg", msg);
				request.setAttribute("userDetails", eb);
				RequestDispatcher rd=request.getRequestDispatcher("Edit.jsp");
				rd.forward(request, response);
			}
		}
		if(uri.contains("/openEditContactView"))
		{
			HttpSession s=request.getSession(false);
			if(s!=null)
			{
			String email=(String)s.getAttribute("email");
			request.setAttribute("email", email);
			RequestDispatcher rd=request.getRequestDispatcher("AddContact.jsp");
			rd.forward(request, response);
			}
			else{
				String msg="your session is invalid try again to login";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
	
		if(uri.contains("/AddContact"))
		{
			HttpSession s = request.getSession(false);
			if(s!=null)
			{
				String email=(String)s.getAttribute("email");
				AddContactBean ab=(AddContactBean) request.getAttribute("addcontact");
				MvcModel mm=new MvcModel();
				String msg=mm.editContact(ab);
				if(!msg.equals("success"))
				{
					request.setAttribute("email", email);
					System.out.println(msg);
					request.setAttribute("error msg", msg);
					RequestDispatcher rd=request.getRequestDispatcher("AddContact.jsp");
					rd.forward(request, response);
				}
				else{
					String msg1=msg+" contact Added";
					request.setAttribute("suc msg", msg1);
					String link="<a href='Menu.jsp'>go to menu</a>";
					request.setAttribute("link",link);
					request.setAttribute("email", email);
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response);
				}
				
			}
			else
			{
				String msg="your session is invalid try again to login";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
		}
		if(uri.contains("/openSearchContactView"))
		{
			HttpSession s=request.getSession(false);
			if(s!=null)
			{
			String email=(String)s.getAttribute("email");
			request.setAttribute("email", email);
			RequestDispatcher rd=request.getRequestDispatcher("SearchContact.jsp");
			rd.forward(request, response);
			}
			else{
				String msg="your session is invalid try again to login";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
		if(uri.contains("/openListContactView"))
		{
			HttpSession s=request.getSession(false);
			if(s!=null)
			{
			String email=(String)s.getAttribute("email");
			request.setAttribute("email", email);
			RequestDispatcher rd=request.getRequestDispatcher("ListContact.jsp");
			rd.forward(request, response);
			}
			else{
				String msg="your session is invalid try again to login";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
		if(uri.contains("/openEditionContactView"))
		{
			HttpSession s=request.getSession(false);
			if(s!=null)
			{
				String email=(String)s.getAttribute("email");
			request.setAttribute("email", email);
			RequestDispatcher rd=request.getRequestDispatcher("EditContact.jsp");
			rd.forward(request, response);
			}
			else{
				String msg="your session is invalid try again to login";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.forward(request, response);
			}
		}
		if(uri.contains("/searchContact"))
		{
			AddContactBean ab=(AddContactBean) request.getAttribute("addcontact");
			ArrayList al=new ArrayList();
			String string=request.getParameter("string");
			if(string==null || string.trim().equals(""))
			{
				String msg="string should not be null";
				request.setAttribute("error msg", msg);
				RequestDispatcher rd=request.getRequestDispatcher("SearchContact.jsp");
				rd.forward(request, response);
			}
			else
			{
			MvcModel mm=new MvcModel();
			System.out.println("before dosearch call");
			al=mm.doSearch(string);
			System.out.println(al);
			request.setAttribute("addbean", ab);
			request.setAttribute("searchdetains",al);
			RequestDispatcher rd=request.getRequestDispatcher("ListSearch.jsp");
			rd.forward(request, response);
			}
		}
		if(uri.contains("/editList"))
		{
			AddContactBean ab=(AddContactBean) request.getAttribute("addcontact");
			ArrayList al=new ArrayList();
			String string=request.getParameter("name");
			HttpSession s=request.getSession();
			s.setAttribute("uname", string);
			if(string==null || string.trim().equals(""))
			{
				String msg="name should not be null";
				request.setAttribute("error msg", msg);
				RequestDispatcher rd=request.getRequestDispatcher("EditContact.jsp");
				rd.forward(request, response);
			}
			else
			{
			MvcModel mm=new MvcModel();
			System.out.println("before dosearch call");
			ab=mm.doSearchForEdit(string);
			System.out.println(al);
			System.out.println(ab.getEmail());
			System.out.println(ab.getName());
			System.out.println(ab.getDob());
			request.setAttribute("addbean", ab);
			request.setAttribute("searchdetains",al);
			RequestDispatcher rd=request.getRequestDispatcher("EditOut.jsp");
			rd.forward(request, response);
			}
		}
		if(uri.contains("/updateList"))
		{
			HttpSession s=request.getSession(false);
			if(s!=null)
			{
			String link="<a href='Menu.jsp'>go to menu</a>";
			String email=(String)s.getAttribute("email");
			request.setAttribute("link", link);
			request.setAttribute("email", email);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateContact.jsp");
			rd.forward(request, response);
			}
			else{
				String msg="your session is invalid try again to login";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.forward(request, response);
			}
		}
		if(uri.contains("/updateTable"))
		{
			HttpSession s=request.getSession(false);
			AddContactBean ab=new AddContactBean();
			s.getAttribute("bean");
			String name=(String)request.getParameter("name");;
			String email=(String)request.getParameter("email");
			String phone=(String)request.getParameter("phone");
			String dob=(String)request.getParameter("dob");
			String tag=(String)request.getParameter("tag");
			String sex=(String)request.getParameter("sex");
			System.out.println(name);
			ab.setName(name);
			ab.setEmail(email);
			ab.setDob(dob);
			ab.setPhone(phone);
			ab.setSex(sex);
			ab.setTag(tag);
			MvcModel mm=new MvcModel();
			System.out.println("before");
			String msg=mm.updatetab(ab);
			if(!msg.equals("success"))
			{
				request.setAttribute("email", email);
				System.out.println(msg);
				request.setAttribute("error msg", msg);
				RequestDispatcher rd=request.getRequestDispatcher("UpdateContact.jsp");
				rd.forward(request, response);
			}
			else{
				String msg1=msg+" contact updated";
				request.setAttribute("suc msg", msg1);
				String link="<a href='Menu.jsp'>go to menu</a>";
				request.setAttribute("link",link);
				request.setAttribute("email", email);
				RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
			}
		}
		if(uri.contains("/deleteList"))
		{
			HttpSession s=request.getSession(false);
			if(s!=null)
			{
			AddContactBean ab=new AddContactBean();
			String name2=(String)s.getAttribute("uname");
			System.out.println(name2);
			MvcModel mm=new MvcModel();
			mm.doDelete(name2);
			String msg="Deleted Successfully";
			String link="<a href='Menu.jsp'>go to menu</a>";
			String email=(String)s.getAttribute("email");
			request.setAttribute("link", link);
			request.setAttribute("suc msg", msg);
			request.setAttribute("email", email);
			RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
			rd.forward(request, response);
			}
			else{
				String msg="<b>Your Session Is Invalid Try Again To Login</b>";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.forward(request, response);
			}
		}
		if(uri.contains("/listContactByName"))
		{
			HttpSession s=request.getSession(false);
			AddContactBean ab=new AddContactBean();
			ArrayList albean=new ArrayList();
			if(s!=null)
			{
				MvcModel mm=new MvcModel();
				albean=(ArrayList)mm.doListByName();
				request.setAttribute("beanal", albean);
				String link="<a href='Menu.jsp'>go to menu</a>";
				String email=(String)s.getAttribute("email");
				request.setAttribute("link", link);
				request.setAttribute("email", email);
				RequestDispatcher rd=request.getRequestDispatcher("SortedList.jsp");
				rd.forward(request, response);
			
			}
			else{
				String msg="<b>Your Session Is Invalid Try Again To Login</b>";
				request.setAttribute("error msg",msg);
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.forward(request, response);
			}
		}
	}
}