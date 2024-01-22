<%@ page import="java.time.LocalDateTime" %> <%@ page isELIgnored="false" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <h1>This is help page</h1>
    <% String name = (String)request.getAttribute("name"); Integer num =
    (Integer)request.getAttribute("num"); LocalDateTime dateTime =
    (LocalDateTime)request.getAttribute("dateTime"); %>
    <h3>Vadi Peru : <%= name %></h3>
    <h3>Batch Id : <%= num %></h3>
    <h3>Todays date : <%= dateTime %></h3>
    <c:forEach var="item" items="${steps}">
      <h3>${item}</h3>
    </c:forEach>
  </body>
</html>
