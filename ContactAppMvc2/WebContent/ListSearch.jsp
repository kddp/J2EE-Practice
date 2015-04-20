<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession s=request.getSession();
if(s!=null)
{
String email1=(String)s.getAttribute("email");
out.println("welcome "+email1);
out.println("</br>");
out.println("</br>");
com.dablu.ranjeet.AddContactBean ab = (com.dablu.ranjeet.AddContactBean) request.getAttribute("addbean");
ArrayList al=new ArrayList();
String name=null;
String email=null;
String phone=null;
String dob=null;
String tag=null;
String sex=null;
al=(ArrayList)request.getAttribute("searchdetains");
String s3="<html><head><style>table,th,td{border:1px solid black;}</style></head><body><table><tr><th>name</th><th>email</th><th>phone</th><th>dob</th><th>tag</th><th>sex</th></tr></table></body></html>";
out.println(s3);
for(Object o:al)
{
	com.dablu.ranjeet.AddContactBean b=(com.dablu.ranjeet.AddContactBean)o;
	name=b.getName();
	email=b.getEmail();
	phone=b.getPhone();
	dob=b.getDob();
	tag=b.getTag();
	sex=b.getSex();
	String s2="<html><head><style>table,th,td{border:1px solid black;}</style></head><body><table><tr><th>"+name+"</th><th>"+email+"</th><th>"+phone+"</th><th>"+dob+"</th><th>"+tag+"</th><th>"+sex+"</th></tr></table></body></html>";
	out.println(s2);
}
out.println("</br>");
out.println("<a href='Menu.jsp'>go to menu</a>");
}
%>
</body>
</html>