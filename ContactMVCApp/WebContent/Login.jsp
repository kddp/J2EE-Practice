<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Welcome!!!</h1>
		<form action="LoginInt.jsp" method="post">
			Enter Email:<input type="text" name="email" value="${param.email}"><br/>
			Enter Password:<input type="Password" name="pass" ><br/>
			<input type="submit" />
		</form>
		<% 
			if(request.getAttribute("errorMsg")!=null)
			{
				out.println("<h1>Error</h1>");
				out.println(request.getAttribute("errorMsg"));
			}
		%>
		
</body>
</html>