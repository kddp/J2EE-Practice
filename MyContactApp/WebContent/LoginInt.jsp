<jsp:useBean id="reg" class="com.uttara.test.LoginBean" scope="request">
<jsp:setProperty name="reg" property="*"/>

</jsp:useBean>
<jsp:forward page="Login.do"></jsp:forward>