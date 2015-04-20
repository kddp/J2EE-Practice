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
		<h1 style="color: navy;"><marquee><s:text name="welcome.header"/></marquee></h1>
		
		<h1 style="color: navy;"><s:text name="welcome.subheader"/></h1>
		
		<s:form action="openSuccessView.action"  enctype="multipart/form-data">
						Select Picture<s:file name="userImage" />
    					<s:submit value="Upload" align="center" />
	
		</s:form>
	
</body>
</html>