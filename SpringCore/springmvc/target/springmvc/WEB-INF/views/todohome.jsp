<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title><c:out value="${page}"></c:out></title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <div class="container mt-3">
      <h1 class="text-center">Welcome to TODO Manager</h1>
      <c:if test="${not empty msg}"
        ><div class="alert alert-success">
          <b><c:out value="${msg}"></c:out></b></div
      ></c:if>
      <div class="row mt-5">
        <div class="col-md-2">
          <div class="list-group">
            <button
              type="button"
              class="list-group-item list-group-item-action active"
              aria-current="true"
            >
              The current button
            </button>
            <a
              href="<c:url value='/add' />"
              class="list-group-item list-group-item-action"
              >ADD TODO</a
            >
            <a
              href="<c:url value='/todohome' />"
              class="list-group-item list-group-item-action"
              >View TODO</a
            >
          </div>
        </div>
        <div class="col-md-10">
          <c:if test="${page=='home'}">
            <h1 class="text-center">All Todo's</h1>
            <c:forEach items="${todos}" var="t">
              <div class="card">
                <div class="card-body">
                  <div class="row">
                    <div class="col-md-10">
                      <h3><c:out value="${t.todoTitle}"></c:out></h3>
                      <p><c:out value="${t.todoContent}"></c:out></p>
                    </div>
                    <div class="col-md-2 text-right">
                      <form action="deleteTodo" method="post">
                        <input type="hidden" name="todoId" value="${t.todoId}">
                        <button type="submit" class="btn btn-danger">Delete</button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </c:if>
          <c:if test="${page=='add'}">
            <h1 class="text-center">Add Todo</h1>
            <form:form action="saveTodo" method="post" modelAttribute="todo">
              <div class="form-group">
                <form:input
                  path="todoTitle"
                  cssClass="form-control"
                  placeholder="Enter your Todo"
                />
              </div>
              <div class="form-group">
                <form:textarea
                  path="todoContent"
                  cssClass="form-control mt-2"
                  placeholder="Enter content"
                  cssStyle="height:300px;"
                />
              </div>
              <div class="container text-center">
                <button class="btn btn-outline-success mt-2">Add Todo</button>
              </div>
            </form:form>
          </c:if>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
