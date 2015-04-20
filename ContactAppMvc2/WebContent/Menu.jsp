<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Menu</h1>
<% HttpSession s=request.getSession();
if(s!=null)
{
String email=(String)s.getAttribute("email");
out.println("welcome "+email);
}
%>
<br>
<br>
<a href="openEditAccView.do">Click to Edit Account</a><br>
<a href="openEditContactView.do">click to create contact</a><br>
<a href="openSearchContactView.do">click to search contact</a><br>
<a href="openListContactView.do">click to list contact</a><br>
<a href="openEditionContactView.do">click to edit contact</a><br>
<br>
<a href="Logout.do">Click to Logout</a>
</body>
</html>