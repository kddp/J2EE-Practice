package com.uttara.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public LifeCycleServlet() {
        super();
        System.out.println("inside no-arg construct of LifeCycle");
        // TODO Auto-generated constructor stub
    }
    @Override
    public void service(ServletRequest arg0, ServletResponse arg1)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("inside service() of LifeServlet");
    }
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("inside init() of LifeServlet");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside doGet() of LifeServlet");
	}
	
	@Override
	public void destroy() {
		System.out.println("inside destroy() of LifeServlet");
	}
	  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
