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
	<h1>Welcome</h1>
	
	<s:form action="process" enctype="multipart/form-data">
		Enter name:<s:textfield name="uname"/>
		Select photo:<s:file name="pic"/>
		Maleaa? <s:checkbox name="male"/>
		
		What food do you like?
		<s:select list="food" name="breaky"></s:select>
		
		<s:iterator value="food">
			<s:property/><br/>
		</s:iterator>
		<s:submit/>
	</s:form>
	
	
</body>
</html>







