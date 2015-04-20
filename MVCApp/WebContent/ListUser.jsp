<%@page import="com.uttarainfo.mvc.RegBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*,com.*"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListUser</title>
</head>
<body>
		<h1>Welcome!!!</h1>
		<h2>View Registered Users</h2>
		
		<b>
			<% 
				if(request.getAttribute("userlist")!=null)
				{
					List<RegBean> l = (List<RegBean>)request.getAttribute("userlist");
					for(RegBean rb : l)
					{
						out.print(rb.getUname()+" ");
						out.print(rb.getEmail()+"<br/>");
					}
				}
			
			
			%>
		</b>
	
		


</body>
</html>