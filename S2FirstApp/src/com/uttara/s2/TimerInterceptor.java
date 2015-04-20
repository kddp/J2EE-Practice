package com.uttara.s2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TimerInterceptor implements Interceptor {

	@Override
	public void destroy() 
	{
		System.out.println("inside timerInterceptor destroy()");

	}

	@Override
	public void init() 
	{
		System.out.println("inside init() of timerInterceptor");

	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception 
	{
		System.out.println("inside intercept() of timerInterceptor");
		System.out.println("pre-process");
		String result = ai.invoke();
		System.out.println("post-process");
		return result;
	}

}
