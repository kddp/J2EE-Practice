<jsp:useBean id="addcontact" class="com.uttara.test.AddContactBean" scope="request">
<jsp:setProperty name="addcontact" property="*"/>

</jsp:useBean>
<jsp:forward page="AddContact.do"></jsp:forward>