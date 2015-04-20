<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<h1>Add Contacts</h1>
			<%
			if(request.getAttribute("email")!=null)
			{
				out.println("Welcome "+(String)request.getAttribute("email"));
				out.println("</br>");
			}
			%>
				<form action="AddContactInt.jsp">
				<br>
				Enter the contact name:<input type="text" name="name"/><br>
				Enter the email:<input type="text" name="email"/><br>
				Enter the phone:<input type="text" name="phone"/><br>
				Enter the tag:<input type="text" name="tag"/><br>
				Enter the dob:<input type="text" name="dob"/><br>
				Choose the Gender:
				<input type="radio" name="sex" value="male">male
				<input type="radio" name="sex" value="female">female<br>
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