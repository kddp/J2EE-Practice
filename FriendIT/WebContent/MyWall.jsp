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
		<h2 align="center"style="color: green;"><s:text name="homepage.mywall"/></h2>
		
		<h2 style="color: blue;"><i><s:text name="loginhomepageview.header"/>
		<s:property value="#session.userDetails.fname"/>&nbsp;<s:property value="#session.userDetails.lname"/><br/></i></h2><div align="right"><b><a href="logout.action"><button style="color: red"><s:text name="logout"/></button></a></b><br/></div>
		<div align="right"> <b ><a href="editAccount.action"><button style="color: red"><s:text name="editAccount"/></button></a></b><br/><br/></div>
		 
		
		<img src='image.jpg'/><br/>
		<b><s:text name="mydetail.email"/>&nbsp;</b><i><s:property value="#session.userDetails.email"/></i><br/>
		<b><s:text name="mydetail.gender"/>&nbsp;</b><i><s:property value="#session.userDetails.gender"/></i><br/>
		<b><s:text name="mydetail.dob"/></b>&nbsp;<i><s:property value="#session.userDetails.dob"/></i><br/>
		<b><s:text name="mydetail.created.date"/>&nbsp;</b><i><s:property value="#session.userDetails.cr_dt"/></i><br/>
	
		
		<a href="myfriends.action" title="My Friends"><img src="Friends.jpg" name="My Friends"></a><a href="myMessage.action" title="My Messages"><img src="Message.jpg" name="My Friends"></a><br/>
	  
		
		
		<center><h2 style="color: blue;"><i><s:text name="mydetail.aboutme"/><br/></i></h2>
			<b><s:property value="#session.userDetails.moreAbtMe"/></b>
		</center>
		
		
		<s:form action="posttomywall.action">
			<center><h2 style="color: blue;"><i><s:text name="mywall.post"/></i></h2><s:textfield style="width:325px;border:4px solid #ccc;" name="myPost.post"/></center>
			<s:submit value="PostIT" align="center"/>
		</s:form>
		
		
		<center><h2 style="color: blue;"><i><s:text name="mywall.mypost.heading"/></i></h2></center>
		
		<center><div style="height:500px;width:400px;border:4px solid #ccc;overflow:auto;">	
			<center>
					<s:iterator value="#session.posts">
						<font size="4" style="font:"><b><s:property value="post"/></b></font><br/><a href='friendwall.action?name=<s:property value="from"/>'><i><s:property value="from"/>&nbsp;at&nbsp;<s:property value="t"/>&nbsp;<s:property value="d"/></i></a><br/><br/>
					</s:iterator>
			</center>
		</div></center>	
		
		
		<center>
			<form action="sendinvite.action">
				<h2 style="color: blue;"><i><s:text name="mywall.invite"/><s:textfield name="listoffrnds"/></i></h2>
				<s:submit value="INVITE" align="center"/>
			</form>
		</center>	
		
</body>
</html>