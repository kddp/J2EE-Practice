<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.uttarainfo.mvc.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
		<h1>Menu</h1>
		<h2>Welcome!!!${user.email} </h2><br/>
		
							
		<a href="logout.do">Click to Logout</a><br/>
		<a href="openEditAccountView.do">Click to edit Account</a><br/>
		<a href="getUser.do">Click to View Registered Users</a>
</body>
</html>