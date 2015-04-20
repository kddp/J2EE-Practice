<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
  <%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1><s:text name="inputheader"/></h1>
	<s:form action="welcome">
		<s:text name="uname"/><s:textfield name="bean.uname"/>
		<s:text name="email"/><s:textfield name="bean.email"/>
		<s:submit/>
	</s:form>
	
</body>
</html>