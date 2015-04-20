<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
		Data from session: <s:property value="#session.user"/>
		Name:<s:property value="name"/><br/>
		Age:<s:property value="age"/><br/>
		Date:<s:property value="dt"/><br/>
		Names:
		<s:iterator value="names">
			<s:property/>
		</s:iterator>
		<br/>
		<s:iterator value="contacts">
			<s:property value="name"/> <s:property value="city"/> <br/>
		</s:iterator>
		

		
</body>
</html>

