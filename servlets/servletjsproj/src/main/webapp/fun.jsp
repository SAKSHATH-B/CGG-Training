<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <%@ page
isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>JSTL Function Tags</title>
  </head>
  <body>
    <h1>all about Function Tags</h1>
    <c:set var="name" value="Cgg"></c:set>
    <h3><c:out value="${name}"></c:out></h3>
    <h3>Length of name is <c:out value="${fn:length(name)}"></c:out></h3>
    <h3><c:out value="${fn:toLowerCase(name)}"></c:out></h3>
    <h3><c:out value="${fn:contains(name,'Cgg')}"></c:out></h3>
  </body>
</html>
