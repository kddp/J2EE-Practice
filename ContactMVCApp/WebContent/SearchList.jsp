<%@page import="com.uttarainfo.abhisheknag.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ page import="com.uttarainfo.abhisheknag.AddContactBean" %>
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
			LoginBean lb =(LoginBean) s.getAttribute("user");
			String email1=lb.getEmail();
			out.println("<h2>Welcome "+email1+"</h2>");
			out.println("</br>");
			out.println("</br>");
			AddContactBean ab = (AddContactBean) request.getAttribute("addBean");
			ArrayList al=new ArrayList();
			String name=null;
			String email=null;
			String phone=null;
			String dob=null;
			String tag=null;
			String sex=null;
			al = (ArrayList)request.getAttribute("searchDetails");
			String s3="<html><head></head><body><table><tr><th>---NAME---</th><th>---EMAIL---</th><th>---PHONE NUMBER---</th><th>---DOB---</th><th>---TAG---</th><th>---SEX---</th></tr></table></body></html>";
			out.println(s3);
			for(Object o:al)
			{
				AddContactBean b=(AddContactBean)o;
				name=b.getName();
				email=b.getEmail();
				phone=b.getPhone();
				dob=b.getDob();
				tag=b.getTag();
				sex=b.getSex();
				String s2="<html><head></head><body><table><tr><th>"+name+"</th><th>"+email+"</th><th>"+phone+"</th><th>"+dob+"</th><th>"+tag+"</th><th>"+sex+"</th></tr></table></body></html>";
				out.println(s2);
			}
			out.println("</br>");
			out.println("<a href='Menu.jsp'>Click to goto Menu</a>");
		}
	%>
	</body>
</html>