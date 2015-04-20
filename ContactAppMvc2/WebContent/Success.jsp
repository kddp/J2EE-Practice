<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Success</h1>
<%
 HttpSession s=request.getSession();
if(s!=null)
{
String email=(String)s.getAttribute("email");
out.println("welcome "+email);
out.println("<br>");
out.println("<br>");
}
if(request.getAttribute("suc msg")!=null);
{
	out.println((String)request.getAttribute("suc msg"));
	out.println("<br>");
}
if(request.getAttribute("link")!=null);
{
	out.println((String)request.getAttribute("link"));
}

%>
</body>
</html>