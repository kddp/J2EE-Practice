<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1 style="color: maroon;;"><marquee><s:text name="success.header"/></marquee></h1>
		
				User Image: <s:property value="userImage"/>
    						<br/>
   			    Content Type: <s:property value="userImageContentType"/>
 							   <br/>
   				 File Name: <s:property value="userImageFileName"/>
 							   <br/>
  				  Uploaded Image:
					    <br/>
					    <img src="<s:property value="userImageFileName"/>"/>
		
</body>
</html>