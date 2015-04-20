package com.uttara.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestCount
 */
public class TestCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	int count=0;
    public TestCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession(true);
		
		String arg = "<html><body><h1>Welcome</h1><br/><b>Count is = ";
		
		if(s.getAttribute("count")!=null)
		{
			int val1 = (Integer)s.getAttribute("count");
			s.setAttribute("count", ++val1);
			arg =arg + val1+"</b></body></html>";
			out.print(arg);
		}
		else
		{
			s.setAttribute("count", 1);
			int val2 = (Integer)s.getAttribute("count");
			arg =arg + val2+"</b></body></html>";
			out.print(arg);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
