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
	<h1>Success</h1>
	<b><s:property value="bean.uname"/></b><br/>
	<b><s:property value="bean.email"/></b><br/>
	<b><s:property value="bean.age"/></b>
	
	<h2>Data From Session</h2>
	
	<b><s:property value="#session.userDetails.uname"/></b><br/>
	<b><s:property value="#session.userDetails.email"/></b><br/>
	<b><s:property value="#session.userDetails.age"/></b>
		
		
		
</body>
</html>