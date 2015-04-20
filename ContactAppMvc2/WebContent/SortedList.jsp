<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% HttpSession s=request.getSession();
if(s!=null)
{
String email1=(String)s.getAttribute("email");
out.println("welcome "+email1);
out.println("</br>");
ArrayList arrayBean=new ArrayList();
com.dablu.ranjeet.AddContactBean ab = (com.dablu.ranjeet.AddContactBean) request.getAttribute("addbean");
arrayBean=(ArrayList)request.getAttribute("beanal");
String s3="<html><head><style>table,th,td{border:1px solid black;}</style></head><body><table><tr><th>name</th><th>email</th><th>phone</th><th>dob</th><th>tag</th><th>sex</th></tr></table></body></html>";
out.println(s3);

for(Object o:arrayBean)
{
	com.dablu.ranjeet.AddContactBean b=(com.dablu.ranjeet.AddContactBean)o;
	String name=b.getName();
	String email=b.getEmail();
	String phone=b.getPhone();
	String dob=b.getDob();
	String tag=b.getTag();
	String sex=b.getSex();
	String s2="<html><head><style>table,th,td{border:1px solid black;}</style></head><body><table><tr><th>"+name+"</th><th>"+email+"</th><th>"+phone+"</th><th>"+dob+"</th><th>"+tag+"</th><th>"+sex+"</th></tr></table></body></html>";
	out.println(s2);
}
out.println("</br>");
out.println("<a href='Menu.jsp'>go to menu</a>");
}
%>


<%
if(request.getAttribute("link")!=null);
{
	out.println((String)request.getAttribute("link"));
}

%>


</body>
</html>