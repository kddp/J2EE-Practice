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
		<h1 align="center" style="color: green;"><s:text name="homepage.header"/></h1>
		
		<h2 align="center" style="color: green;"><s:text name="loginview.header"/></h2>
			
			
			
			
			<center>
					<s:form action="login.action">
						<h3><s:text name="loginview.email"/><s:textfield name="bean.email"/></h3>
						<h3><s:text name="loginview.pass"/><s:textfield name="bean.pass"/></h3>
						<s:submit value="LOGIN" align="center"/>
					</s:form>
			</center>
		
			
			<center style="color: red;"><h2><s:actionerror/>
			<s:actionmessage/></h2></center>
			
			
		
</body>
</html>