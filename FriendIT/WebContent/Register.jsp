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
<s:form action="register" method="post" enctype="multipart/form-data">
		
		<h1 align="center" style="color: green;"><s:text name="homepage.header"/></h1>
		<h1 align="center" style="color: blue;"><s:text name="registerpage.header"/></h1>
		
		<h2 style="color: green;"><s:text name="registerpage.accountinfo.header"/></h2>
		<s:text name="registerpage.email"/><s:textfield name="bean.email"/>
		<s:text name="registerpage.pass"/><s:textfield name="bean.pass"/>
		<s:text name="registerpage.rpass"/><s:textfield name="bean.rpass"/>
		
		<h2 style="color: green;"><s:text name="registerpage.persinfo.header"/></h2>
		
		<s:text name="registerpage.fname"/><s:textfield name="bean.fname"/>
		<s:text name="registerpage.lname"/><s:textfield name="bean.lname"/>
		<s:text name="registerpage.dob"/><s:textfield name ="bean.dob" />
		<s:text name="registerpage.gender"/><s:radio name="bean.gender" list="#{'M':'Male','F':'Female'}" value="'M'" />

		<h2 style="color: green;"><s:text name="registerpage.prof.header"/></h2>		

		<s:text name="registerpage.moreAbtMe"/><s:textfield name="bean.moreAbtMe"/>
		<s:text name="registerpage.pic"/><s:file name="bean.pic"/>
		<s:submit value="Register"/>
		
		<center style="color: red;"><s:actionerror/></center>
	
</s:form>
</body>
</html>