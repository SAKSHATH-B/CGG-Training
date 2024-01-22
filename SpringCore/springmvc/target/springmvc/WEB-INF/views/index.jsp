<%@ page import="java.util.List" %> <%@ page isELIgnored="false" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>This is a HomePage called by HomeController - url /home</h1>

    <h2>Evad kodithe dimma tirgi mind block aytundo vade ${name}</h2>
    <h2>Phone number : ${id}</h2>
    <hr />
    <c:forEach var="item" items="${friends}">
      <h3>${item}</h3>
      <h3><c:out value="${item}"></c:out></h3>
    </c:forEach>
  </body>
</html>
