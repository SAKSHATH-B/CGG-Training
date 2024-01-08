<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %> <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <title>All users page</title>
  </head>
  <body>
    <h1>All users are:</h1>
    <sql:setDataSource
      driver="org.postgresql.Driver"
      url="jdbc:postgresql://localhost:5432/techblog"
      user="postgres"
      password="postgres"
      var="ds"
    ></sql:setDataSource>
    <sql:query dataSource="${ds}" var="rs">select * from user1;</sql:query>
    <div class="container">
      <table class="table">
        <tr>
          <td>User Id</td>
          <td>User Name</td>
          <td>User Email</td>
        </tr>
        <c:forEach items="${rs.rows}" var="row">
          <tr>
            <td><c:out value="${row.id}"></c:out></td>
            <td><c:out value="${row.name}"></c:out></td>
            <td><c:out value="${row.email}"></c:out></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
