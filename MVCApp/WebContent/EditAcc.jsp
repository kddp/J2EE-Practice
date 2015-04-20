<%@page import="com.uttarainfo.mvc.RegBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EditAccount</title>
</head>
<body>
	<h1>Welcome to Edit Account</h1>
	<form action="EditInt.jsp" method="post">
			Email:<input type="text" name="email" value="${userDetail.email}" readonly="true"><br/>
			Re-Enter Name:<input type="text" name="uname" value="${userDetail.uname}"><br/>
			Re-Enter Password:<input type="Password" name="pass" value="${userDetail.email}"><br/>
			<input type="submit" />
		</form>
</body>
</html>