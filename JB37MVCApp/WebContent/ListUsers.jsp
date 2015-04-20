<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.uttarainfo.jb37.mvc.*, java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>List of Registered Users</h1>

	<a href="logout.do">Click to Logout</a>
	<div>
	<%
		List<RegBean> l = (List<RegBean>) request.getAttribute("usersList");
		for(RegBean rb:l)
		{
			out.println("<div>Name : "+rb.getUname());	
			out.println("Email : "+rb.getEmail()+ "</div>");	
		}
	%>
	</div>

</body>
</html>