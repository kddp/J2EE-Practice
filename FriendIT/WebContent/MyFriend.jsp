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
		<h1 align="center"style="color: green;"><s:text name="homepage.header"/></h1>
			
		<h2 style="color: blue;"><i><s:text name="loginhomepageview.header"/>
		<s:property value="#session.userDetails.fname"/>&nbsp;<s:property value="#session.userDetails.lname"/><br/></i></h2><div align="right"><b><a href="logout.action"><button style="color: red"><s:text name="logout"/></button></a></b><br/></div>
		<div align="right"> <b ><a href="editAccount.action"><button style="color: red"><s:text name="editAccount"/></button></a></b><br/><br/></div>	
		
		<h2 align="center"style="color: green;"><s:text name="myfriends.header"/></h2>
		<center><div style="height:400px;width:300px;border:4px solid #ccc;overflow:auto;">	
			<center>
					<s:iterator value="#session.listFriends">
						<font size="4" style="font:"><b><a href='friendwall.action?name=<s:property value="fname"/>'><s:property value="fname"/></a></b></font><br/>
					</s:iterator>
			</center>
		</div></center>		
		
		
		
		<center><a href="gotoWall.action"><button style="color: red">GO BACK TO YOUR WALL</button></a></center>

</body>
</html>