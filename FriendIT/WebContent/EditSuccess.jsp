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
		<h1 align="center"><s:text name="homepage.header"/></h1>
		<h2 align="center"><s:text name="homepage.mywall"/></h2>
		
		<h2><s:text name="loginhomepageview.header"/>
		<s:property value="#session.userDetails.fname"/></h2><div align="right"><b><a href="logout.action"><s:text name="logout"/></a></b><br/></div>
		
		<center><s:text name="editaccount.success.mssg"/></center>
		
		<center><b><a href="gotoWall.action"><s:text name="mywall.link"></s:text></a></b></center>

</body>
</html>