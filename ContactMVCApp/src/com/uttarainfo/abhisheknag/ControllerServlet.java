package com.uttarainfo.abhisheknag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
       System.out.println("inside Const ControllerServlet ");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doGet() of ControllerServlet");
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost() of ControllerServlet");
		process(request,response);
	}

	
	 protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("inside process() of ControllerServlet");
		
			String uri = request.getRequestURI();
			System.out.println("URI = "+uri);
			RequestDispatcher rd = null;
			HttpSession session = null;
			Model m =new Model();
			
			
			if(uri.contains("searchContact"))
			{
				AddContactBean ab=(AddContactBean)request.getAttribute("addcontact");
				ArrayList al = new ArrayList();
				String string = request.getParameter("string");
				if(string==null || string.trim().equals(""))
				{
					String msg="String should not be null";
					request.setAttribute("errorMssg", msg);
					rd=request.getRequestDispatcher("SearchContact.jsp");
					rd.forward(request, response);
				}
				else
				{
				m = new Model();
				System.out.println("before dosearch call");
				al = m.doSearch(string);
				System.out.println(al);
				request.setAttribute("addBean", ab);
				request.setAttribute("searchDetails",al);
				rd=request.getRequestDispatcher("SearchList.jsp");
				rd.forward(request, response);
				}
			}
			
			if(uri.contains("openSearchContactView"))
			{
				session = request.getSession(false);
				if(session!=null)
				{
					LoginBean lb = (LoginBean)session.getAttribute("user");
					String email= lb.getEmail();
					request.setAttribute("email", email);
					rd=request.getRequestDispatcher("SearchContact.jsp");
					rd.forward(request, response);
				}
				else
				{
					String msg="Your session is expired...Plz Login and try again....";
					request.setAttribute("errorMssg",msg);
					rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}	
			}
			
			if(uri.contains("/listContactByName"))
			{
				session = request.getSession(false);
				AddContactBean ab = new AddContactBean();
				ArrayList al = new ArrayList();
				if(session != null)
				{
					m = new Model();
					al = (ArrayList)m.doListByName();
					request.setAttribute("BeanAl", al);
					String link="<a href='Menu.jsp'>Click Goto Menu</a>";
					LoginBean lb = (LoginBean)session.getAttribute("user");
					String email=lb.getEmail();
					request.setAttribute("link", link);
					request.setAttribute("email", email);
					rd=request.getRequestDispatcher("ListContactSorted.jsp");
					rd.forward(request, response);
				
				}
				else
				{
					String msg="Your session is expired...Plz login and try again...";
					request.setAttribute("errorMssg",msg);
					rd=request.getRequestDispatcher("HomePage.jsp");
					rd.forward(request, response);
				}
			}
			
			if (uri.contains("openListContactView"))
			{
				session = request.getSession(false);
				if(session!=null)
				{
					LoginBean lb = (LoginBean)session.getAttribute("user");
					String email= lb.getEmail();
					request.setAttribute("email", email);
					rd=request.getRequestDispatcher("ListContact.jsp");
					rd.forward(request, response);
				}
				else
				{
					String msg="Your session is expired...Plz Login and try again....";
					request.setAttribute("errorMssg",msg);
					rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}	
				
			}
			
			if(uri.contains("addContact"))
			{
					HttpSession s = request.getSession(false);
					if(s!=null)
					{
						LoginBean lb = (LoginBean) s.getAttribute("user");
						String email= lb.getEmail();
						AddContactBean ab=(AddContactBean) request.getAttribute("addcontact");
						m=new Model();
						String msg = m.editContact(ab);
						if(!msg.equals(Constants.SUCCESS))
						{
							request.setAttribute("email", email);
							System.out.println(msg);
							request.setAttribute("errorMssg", msg);
							rd=request.getRequestDispatcher("AddContact.jsp");
							rd.forward(request, response);
						}
						else
						{
							String msg1=msg+" Your contact Added Successfully!!!!";
							request.setAttribute("successMsg", msg1);
							String link="<a href='Menu.jsp'>Click to goto Menu</a>";
							request.setAttribute("link",link);
							request.setAttribute("email", email);
							rd=request.getRequestDispatcher("Success.jsp");
							rd.forward(request, response);
						}
						
					}
					else
					{
						String msg="your session is invalid try again to login";
						request.setAttribute("error msg",msg);
						rd=request.getRequestDispatcher("Login.jsp");
						rd.forward(request, response);
					}				
			}
			
			if(uri.contains("openAddContactView"))
			{
				HttpSession s=request.getSession(false);
				if(s!=null)
				{
				LoginBean lb = (LoginBean)s.getAttribute("user");
				String email=lb.getEmail();
				request.setAttribute("email", email);
				rd=request.getRequestDispatcher("AddContact.jsp");
				rd.forward(request, response);
				}
				else
				{
					String msg="Oops!!! Your Session has expired...Plz Login again and continue.....";
					request.setAttribute("errorMsg",msg);
					rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				
			}
			
			if(uri.contains("/openLoginView"))
			{
				rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);					
			}
				
			if(uri.contains("update"))
			{
				UpdateBean ub = (UpdateBean)request.getAttribute("upd");
				System.out.println(ub.getUname() + "  "+ub.getEmail()+"  "+ub.getPass());
				String result = m.update(ub);
				
				if(result.equals(Constants.SUCCESS))
				{
					request.setAttribute("successMsg", "You have successfully updated your account!!!!");
					rd = 	request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMssg",result);
					rd = 	request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
			}
			
			
			if(uri.contains("/openEditAccountView"))
			{
				session = request.getSession(false);
				if(session == null)
				{
					rd = request.getRequestDispatcher("Error.jsp");
					request.setAttribute("errorMssg", "Your Session has expired...Plz login again to edit...");
					rd.forward(request, response);
				}
				else
				{
					LoginBean lb = (LoginBean)session.getAttribute("user");
					String email = lb.getEmail();
					System.out.println(email);
					RegBean rb = m.getDetails(email);
					request.setAttribute("userDetail", rb);
					rd = request.getRequestDispatcher("EditAcc.jsp");
					rd.forward(request, response);
				}
			}
			if(uri.contains("/getUser"))
			{
				session = request.getSession(false);
				System.out.println("Session => "+session);
				if(session==null)
				{
					rd = request.getRequestDispatcher("Error.jsp");
					request.setAttribute("errorMssg","Your Session has Expired...Plz login to View!!!");
					rd.forward(request, response);
				}
				else
				{
						List<RegBean> l = m.getUser();
						for(RegBean rb : l)
						{
							System.out.println(rb.getUname());
							System.out.println(rb.getEmail());
						}
						rd = request.getRequestDispatcher("ListUser.jsp");
						request.setAttribute("userlist",l);
						rd.forward(request, response);
				}
			}
			
			if(uri.contains("/logout"))
			{
				session = request.getSession(false);
				if(session==null)
				{
					request.setAttribute("errorMssg", "You Session Has Expired...Plz Login to Continue!!!");
					rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				else
				{
					session.removeAttribute("user");
					session.invalidate();
				}
				response.sendRedirect("HomePage.html");
			}
			
			
			if(uri.contains("/authenticate"))
			{
				LoginBean lb = (LoginBean)request.getAttribute("user");
				String result = m.authenticate(lb);
				if(result.equals(Constants.SUCCESS))
				{
					session = request.getSession(true); 
					session.setAttribute("user", lb); 
					rd = request.getRequestDispatcher("Menu.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMsg", result);
					rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}		
			}
			if(uri.contains("/openRegisterView"))
			{
				rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);			
			}
			
			if(uri.contains("/register"))
			{
				
				RegBean rb = (RegBean)request.getAttribute("reg");
				String result = m.register(rb);
				
				if(result.equals(Constants.SUCCESS))
				{
					request.setAttribute("successMsg", "You have successfully Registered!!!!");
					rd = 	request.getRequestDispatcher("Success.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("errorMssg",result);
					rd = 	request.getRequestDispatcher("Register.jsp");
					rd.forward(request, response);
				}
			}
		}
}
