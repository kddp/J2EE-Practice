<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Contact</h1>
<% HttpSession s=request.getSession();
if(s!=null)
{
String email1=(String)s.getAttribute("email");
out.println("welcome "+email1);
out.println("</br>");
out.println("</br>");
}
%>
<form action="editList.do" method="post">
Enter the name:<input type="text" name="name"/></br>
<input type="submit"/>
</form>

<%
String msg=(String)request.getAttribute("error msg");
if(msg!=null)
{
	out.println(msg);
}
out.println("</br>");
out.println("<a href='Menu.jsp'>go to menu</a>");
%>

</body>
</html>