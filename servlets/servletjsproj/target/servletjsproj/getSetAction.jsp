<jsp:useBean id="temp" class="cgg.User" />
<jsp:setProperty name="temp" property="*" />

Welcome, <jsp:getProperty name="temp" property="name" />
