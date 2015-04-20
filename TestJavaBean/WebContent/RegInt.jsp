<jsp:useBean id="reg" class="com.uttara.test.RegisterBean" scope="request">
<jsp:setProperty name="reg" property="*"/>
</jsp:useBean>
<jsp:forward page="/process"/>