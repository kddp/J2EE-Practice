<jsp:useBean id="upd" class="com.uttarainfo.mvc.UpdateBean" scope="request">
<jsp:setProperty name="upd" property="*"/>
</jsp:useBean>
<jsp:forward page="update.do"/>