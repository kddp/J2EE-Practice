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
		<h1 align="center"><s:text name="editaccountview.header"/></h1>
		
		<center><a href="gotoWall.action"><button style="color: red">GO BACK</button></a></center>
		
		<s:form action="update.action" method="post" enctype="multipart/form-data">
					
			<h2 style="color: green;"><s:text name="editaccount.accountinfo.header"/></h2>
			<s:text name="registerpage.email"/><s:textfield name="editBean.email" readonly="true"/>
			<s:text name="registerpage.pass"/><s:textfield name="editBean.pass"/>
			<s:text name="registerpage.rpass"/><s:textfield name="editBean.rpass"/>
			
			<h2 style="color: green;"><s:text name="editaccount.persinfo.header"/></h2>
			
			<s:text name="registerpage.fname"/><s:textfield name="editBean.fname"/>
			<s:text name="registerpage.lname"/><s:textfield name="editBean.lname"/>
			<s:text name="registerpage.dob"/><s:textfield name ="editBean.dob" />
			<s:text name="registerpage.gender"/><s:radio name="editBean.gender" list="#{'M':'Male','F':'Female'}" value="'M'" />
	
			<h2 style="color: green;"><s:text name="editaccount.prof.header"/></h2>		
	
			<s:text name="registerpage.moreAbtMe"/><s:textfield name="editBean.moreAbtMe"/>
			<s:text name="registerpage.pic"/><s:file name="editBean.pic"/>
		<s:submit value="Update"/>
		
		<center style="color: red;"><s:actionerror/></center>
	
</s:form>

</body>
</html>