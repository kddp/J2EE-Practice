<%@page import="com.dablu.ranjeet.RegBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Account</h1>
<%
HttpSession s=request.getSession();
String email=(String)s.getAttribute("email");
out.println("Welcome "+email);
com.dablu.ranjeet.EditBean rb = (com.dablu.ranjeet.EditBean) request.getAttribute("userDetails");
String name = rb.getName();
String pword = rb.getPword();
String rpword=rb.getRpword();
//String email1 = rb.getEmail();
%>
<form action="EditInt.jsp" method="post">
<br>
Enter the name:<input type="text" name="name" value="<%=name %>"/><br>
Enter the password:<input type="password" name="pword" value="<%=pword %>"/><br>
Re-Enter the password:<input type="password" name="rpword" value="<%=rpword %>"/><br>
<input type="submit"/>
</form>
<%
String msg=(String)request.getAttribute("error msg");
if(msg!=null)
{
	out.println(msg);
}
%>
</body>
</html>