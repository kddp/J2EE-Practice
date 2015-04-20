<jsp:useBean id="reg" class="com.dablu.ranjeet.RegBean" scope="request">
<jsp:setProperty name="reg" property="*"/>

</jsp:useBean>
<jsp:forward page="Register.do"></jsp:forward>