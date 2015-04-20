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

		<h2 style="color: blue;"><i><s:property value="#session.friendDetails.fname"/>'<s:text name="friendwallview.header"/></i></h2>
	
	
		<img src='image.jpg'/><br/><br/>
		<b><s:text name="myfrnd.name"/></b>&nbsp;<i><s:property value="#session.friendDetails.fname"/>&nbsp;<s:property value="#session.friendDetails.lname"/></i><br/>
		<b><s:text name="myfrnd.gender"/></b>&nbsp;<i><s:property value="#session.friendDetails.gender"/></i><br/>
		<b><s:text name="myfrnd.dob"/></b>&nbsp;<i><s:property value="#session.friendDetails.dob"/></i><br/>
		<b><s:text name="myfrnd.crdt"/></b>&nbsp;<i><s:property value="#session.friendDetails.cr_dt"/></i><br/>
		
			
		
		<center><h2 style="color: blue;"><i><s:text name="myfrnd.aboutme"/>&nbsp;<s:property value="#session.friendDetails.fname"/>!!!</i></h2>
			<b><s:property value="#session.friendDetails.moreAbtMe"/></b>
		</center>
		
		<s:form action="posttofrndwall.action">
			<center><h2 style="color: blue;"><i><s:text name="mywall.post"/><s:textfield style="width:325px;border:4px solid #ccc;" name="post.post"/></i></h2></center>
			<s:submit value="PostIT" align="center"/>	
		</s:form>
		
		<s:form action="mssgttofrndwall.action">
			<center><h2 style="color: blue;"><i><s:text name="mywall.mssg"/><s:textfield style="width:325px;border:4px solid #ccc;" name="mssg.post"/></i></h2></center>
			<s:submit value="MessageIT" align="center"/>	
		</s:form>
		
		
		<center><h2 style="color: blue;"><i><s:property value="#session.friendDetails.fname"/>'<s:text name="friendwallview.post"/></i></h2></center>
		
		<center><div style="height:500px;width:400px;border:4px solid #ccc;overflow:auto;">	
			<center>
					<s:iterator value="#session.frndpost">
						<font size="4" style="font:"><b><s:property value="post"/></b></font><br/><a href='friendwall.action?name=<s:property value="from"/>'><i><s:property value="from"/>&nbsp;at&nbsp;<s:property value="t"/>&nbsp;<s:property value="d"/></i></a><br/><br/>
					</s:iterator>
			</center>
		</div></center>	
		
		<center><a href="gotoWall.action"><button style="color: red">GO BACK TO YOUR WALL</button></a></center>

</body>
</html>