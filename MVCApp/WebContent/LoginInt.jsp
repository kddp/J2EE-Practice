<jsp:useBean id="user" class="com.uttarainfo.mvc.LoginBean" scope="request">
<jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<jsp:forward page="authenticate.do"/>