<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><s:text name="header"/></h1>
		<s:form action="successView" enctype="multipart/form-data">
			
			<s:text name="input.name"/><s:textfield name="bean.uname"/>
			<s:text name="input.email"/><s:textfield name="bean.email"/>
			<s:text name="input.age"/><s:textfield name="bean.age"/>
			
			<s:submit/>
		</s:form>
		<s:actionerror/>
		
</body>
</html>