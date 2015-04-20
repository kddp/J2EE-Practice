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
		<h1 align="center" style="color: orange;"><s:text name="successpage.header"/></h1>
		
		<h3 align="center"><s:text name="successview.mssg"/><br/></h3>
		
		<center><a href="openLoginView.action"><s:text name="succesview.link.login"/></a><br/></center>
		<center><a href="openWelcomeView.action"><s:text name="succesview.link.homepage"/></a></center>
</body>
</html>