<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ page import="com.uttarainfo.abhisheknag.*" %>
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
				LoginBean lb = (LoginBean)session.getAttribute("user");
				String email1= lb.getEmail();
				out.println("<h2>Welcome "+email1+"</h2>");
				out.println("</br>");
				ArrayList arrayBean=new ArrayList();
				AddContactBean ab = (AddContactBean) request.getAttribute("addbean");
				arrayBean=(ArrayList)request.getAttribute("BeanAl");
				//String header="<html><head><style>table,th,td{border:1px solid black;}</style></head><body><table><tr><th>name</th><th>email</th><th>phone</th><th>dob</th><th>tag</th><th>sex</th></tr></table></body></html>";
				String header = "<html><head></head><body><table><tr><th>---NAME---</th><th>---EMAIL---</th><th>---PHONE NUMBER---</th><th>---DOB---</th><th>---TAG---</th><th>---SEX---</th></tr></table></body></html>";
				out.println(header);
			
				for(Object o:arrayBean)
				{
					AddContactBean b=(AddContactBean)o;
					String name=b.getName();
					String email=b.getEmail();
					String phone=b.getPhone();
					String dob=b.getDob();
					String tag=b.getTag();
					String sex=b.getSex();
					String s2="<html><head></head><body><table><tr><th>["+name+"]</th><th>"+email+"</th><th>"+phone+"</th><th>["+dob+"]</th><th>"+tag+"</th><th>["+sex+"]</th></tr></table></body></html>";
					out.println(s2);
				}
				out.println("</br>");
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