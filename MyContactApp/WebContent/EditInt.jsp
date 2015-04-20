<jsp:useBean id="reg" class="com.uttara.test.EditBean" scope="request">
<jsp:setProperty name="reg" property="*"/>

</jsp:useBean>
<jsp:forward page="Edit.do"></jsp:forward>