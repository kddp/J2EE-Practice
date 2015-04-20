<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Register</h1>
		<form action="RegInt.jsp" method="post">
			Enter Name:<input type="text" name="uname" value="${param.uname}"><br/>
			Enter Email:<input type="text" name="email" value="${param.email}"><br/>
			Enter Password:<input type="Password" name="pass" ><br/>
			Repeat Password:<input type="Password" name="rpass"><br/>
			<input type="submit" />
		</form>
		
		
		<% 
			
			if (request.getAttribute("errorMssg")!=null)
			{
				out.println("<h1>Error</h1>");
				out.println(request.getAttribute("errorMssg"));			
			}	
					
		%>
</body>
</html>