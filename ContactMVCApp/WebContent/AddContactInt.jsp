<jsp:useBean id="addcontact" class="com.uttarainfo.abhisheknag.AddContactBean" scope="request">
<jsp:setProperty name="addcontact" property="*"/>

</jsp:useBean>
<jsp:forward page="addContact.do"/>