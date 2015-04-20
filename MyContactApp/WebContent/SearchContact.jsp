<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Search Contact</h1>
<% HttpSession s=request.getSession();
if(s!=null)
{
String email=(String)s.getAttribute("email");
out.println("welcome "+email);
}
%>
<form action="searchContact.do" method="post">
<br>
Enter the String:<input type="text" name="string"/><br>
<input type="submit">
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