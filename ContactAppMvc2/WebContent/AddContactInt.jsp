<jsp:useBean id="addcontact" class="com.dablu.ranjeet.AddContactBean" scope="request">
<jsp:setProperty name="addcontact" property="*"/>

</jsp:useBean>
<jsp:forward page="addContact.do"></jsp:forward>