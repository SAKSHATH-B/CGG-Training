<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Bootstrap demo</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-center mb-3">Welcome to Product App</h1>
          <table class="table">
            <thead class="thead-dark">
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Product Name</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${products}" var="p">
                <tr>
                  <th scope="row">${p.id }</th>
                  <td>${p.name }</td>
                  <td>${p.description }</td>
                  <td class="fw-bold">&#8377;${p.price }</td>
                  <td>
                    <a href="delete/${p.id }"
                      ><i
                        class="fa fa-trash text-danger"
                        style="font-size: 20px"
                      ></i
                    ></a>
                    <a href="update/${p.id }"
                      ><i
                        class="fa fa-pencil text-primary"
                        style="font-size: 20px"
                      ></i
                    ></a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <div class="container text-center">
            <a href="addProduct" class="btn btn-outline-success">Add Product</a>
          </div>
        </div>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
      rel="stylesheet"
    />
  </body>
</html>
