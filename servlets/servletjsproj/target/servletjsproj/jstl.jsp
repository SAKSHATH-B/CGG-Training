<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
isELIgnored="false" %> <%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>JSP Taglib directive</title>
  </head>
  <body>
    <h1>JSP Taglib directive</h1>
    <hr />
    <a:set var="name" value="${200*2}"></a:set>
    <a:out value="${name}"></a:out>

    <a:if test="${3>2}">
      <h2>This is true block - 3>2</h2>
    </a:if>

    <%! int n1 = 200; int n2 = 10; String content="null"; %> <% int division =
    n1/n2; %> <%= division %><%= content.length() %>

    <h1>
      This is testing page for application scope declared variable in
      jstlex.jsp.<br />
    </h1>
    <h1><a:out value="${count}"></a:out></h1>
  </body>
</html>
