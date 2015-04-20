<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Welcome to the World of Struts2!!!</h1>
		<s:form action="openSuccessView.action">
			Name:<s:textfield name="beno.uname"/>
			Email:<s:textfield name="beno.email"/>
			Age:<s:textfield name="beno.age"/>
				<s:submit/>
		</s:form>
</body>
</html>