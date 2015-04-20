<jsp:useBean id="reg" class="com.uttarainfo.abhisheknag.RegBean" scope="request">
<jsp:setProperty name="reg" property="*"/>
</jsp:useBean>
<jsp:forward page="register.do"/>