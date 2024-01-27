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
    <div class="container mt-3">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <h1 class="text-center mb-3">Fill the product detail</h1>
          <form action="handleProduct" method="post">
            <div class="form-group">
              <label for="name" class="form-label">Product Name</label>
              <input
                type="text"
                class="form-control"
                id="name"
                name="name"
                placeholder="Enter the product name here"
              />
            </div>
            <div class="form-group">
              <label for="description" class="form-label"
                >Product Description</label
              >
              <textarea
                class="form-control"
                id="description"
                name="description"
                placeholder="Enter the product description"
                rows="5"
              ></textarea>
            </div>
            <div class="form-group">
              <label for="price" class="form-label">Product Price</label>
              <input
                type="text"
                class="form-control"
                id="price"
                name="price"
                placeholder="Enter Product Price"
              />
            </div>
            <div class="container text-center mt-3">
              <a
                href="${pageContext.request.contextPath }"
                class="btn btn-outline-danger"
                >Back</a
              >
              <button type="submit" class="btn btn-primary">Add</button>
            </div>
          </form>
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
