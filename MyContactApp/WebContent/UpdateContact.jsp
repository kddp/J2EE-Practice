<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% HttpSession s=request.getSession();
String email=(String)s.getAttribute("email");
out.println("Welcome "+email);
com.uttara.test.AddContactBean ab = (com.uttara.test.AddContactBean) request.getAttribute("addbean");
ab=(com.uttara.test.AddContactBean)s.getAttribute("bean");
String name = (String)ab.getName();
String email2 = (String)ab.getEmail();
String phone=(String)ab.getPhone();
String dob=(String)s.getAttribute("dob");
String tag =(String) ab.getTag();
String sex=(String)ab.getSex();
out.println("</br>");
%>
<form action="updateTable.do" method="post">
Enter the name:<input type="text" name="name" value="<%=name %>"/><br>
Enter the email:<input type="text" name="email" value="<%=email2 %>"/><br>
Enter the phone:<input type="text" name="phone" value="<%=phone %>"/><br>
Enter the tag:<input type="text" name="tag" value="<%=tag %>"/><br>
Enter the dob:<input type="text" name="dob" value="<%=dob %>"/><br>
Enter the sex:<input type="text" name="sex" value="<%=sex %>"/><br>
<input type="submit"/>
</form>
<%
String msg=(String)request.getAttribute("error msg");
if(msg!=null)
{
	out.println(msg);
}
%>

</body>
</html>