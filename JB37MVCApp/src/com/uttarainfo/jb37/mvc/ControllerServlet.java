package com.uttarainfo.jb37.mvc;

import java.io.IOException;
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
        System.out.println("inside construc of CS");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doGet of CS");
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of CS");
		process(request,response);
	}
	
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside process of CS");
		
		String uri = request.getRequestURI();
		
		System.out.println("uri = "+uri);
		RequestDispatcher rd = null;
		
		Model m = new Model();
		
		if(uri.contains("/getUsers"))
		{
			System.out.println("inside if uri contains getUsers");
			
			//first verify if user has logged in, only then allow him to fetch users...
			
			HttpSession session = request.getSession();
			if(session==null)
			{
				request.setAttribute("errorMsg", "Boss you have not logged in. Log in first.");
				rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);				
			}
			else
			{
				LoginBean lb = (LoginBean) request.getAttribute("user");
				if(lb==null)
				{
					request.setAttribute("errorMsg", "Boss you have not logged in. Log in first.");
					rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);						
				}
				else
				{
					List<RegBean> l = m.getUsers();
					request.setAttribute("usersList",l);
					rd = request.getRequestDispatcher("ListUsers.jsp");
					rd.forward(request, response);					
				}
				
			}

		} 
		
		if(uri.contains("/openRegisterView"))
		{
			System.out.println("inside if uri contains openregister");
			rd = request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/openLoginView"))
		{
			System.out.println("inside if uri contains openlogin");
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);			
		}
		
		if(uri.contains("/register"))
		{
			System.out.println("inside if uri contains register");
			

	/*		
			String uname = request.getParameter("uname");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String rpass = request.getParameter("rpass");
		*/
			RegBean rb = (RegBean) request.getAttribute("reg");
		//	System.out.println("user inputs = "+uname+" "+email+" "+pass+" "+rpass);
			System.out.println("invoking models register method from CS");
			String result = m.register(rb);
			System.out.println("result of models register = "+result);
			
			if(result.equals(Constants.SUCCESS))
			{
				System.out.println("inside if result success");
				rd = request.getRequestDispatcher("Success.html");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("inside if result failure");			
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
				

			}
			
		}
		if(uri.contains("/logout"))
		{
			System.out.println("inside if uri contains logout");
			HttpSession session = request.getSession(); // getting already created session, if it exists
			if(session==null)
			{
				request.setAttribute("errorMsg", "Boss you have not logged in. Log in first to logout.");
				rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);				
			}
			else
			{
				session.invalidate(); // deleting session for client
				response.sendRedirect("HomePage.html");
			}
		}
		if(uri.contains("/authenticate"))
		{ 
			System.out.println("inside if uri contains authenticate");
			

		
			LoginBean lb = (LoginBean) request.getAttribute("log");
	
	//		System.out.println("user inputs = "+email+" "+pass);
			System.out.println("invoking models authenticate method from CS");
			String result = m.authenticate(lb);
			System.out.println("result of models authenticate = "+result);
			 
			if(result.equals(Constants.SUCCESS))
			{
				System.out.println("inside if result success");
				
				HttpSession session = request.getSession(true); // getting session for client
				lb.setPass(""); // clearing out the password
				session.setAttribute("user", lb); //saving user in session
				rd = request.getRequestDispatcher("Success.html");
				rd.forward(request, response);
			}
			else
			{
				System.out.println("inside if result failure");			
				request.setAttribute("errorMsg", result);
				rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				

			}			
		}		
		
		
	}


}
