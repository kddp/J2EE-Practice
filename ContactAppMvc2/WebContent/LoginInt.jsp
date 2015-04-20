<jsp:useBean id="reg" class="com.dablu.ranjeet.LoginBean" scope="request">
<jsp:setProperty name="reg" property="*"/>

</jsp:useBean>
<jsp:forward page="Login.do"></jsp:forward>