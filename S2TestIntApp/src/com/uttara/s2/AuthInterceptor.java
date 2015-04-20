package com.uttara.s2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthInterceptor implements Interceptor {

	public void destroy() {
		System.out.println("inside destroy() of AI");

	}

	public void init() {
		System.out.println("inside init() of AI");

	}

	public String intercept(ActionInvocation ai) throws Exception {
		
		//pre-processing
		System.out.println("inside AI -> pre-process");
		String result = ai.invoke();
		//post-processing
		System.out.println("inside AI -> post-processing");
		
		return result;
		
	}

}








