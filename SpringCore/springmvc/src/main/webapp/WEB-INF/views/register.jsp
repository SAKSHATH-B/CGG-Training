<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />

    <title>SignUp page</title>
  </head>
  <body>
    <div class="container col-md-6 offset-md-3 mt-3">
      <h1 class="text-center">${head}</h1>
      <p class="text-center">${desc}</p>
      <form action="processForm" method="post">
        <h2 class="text-center">Registration Form</h2>
        <div class="mb-3">
          <label for="user_name" class="form-label">UserName</label>
          <input
            type="text"
            name="user_name"
            class="form-control"
            id="user_name"
            aria-describedby="emailHelp"
            placeholder="Enter UserName"
          />
        </div>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label"
            >Email address</label
          >
          <input
            type="email"
            name="user_email"
            class="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            placeholder="Enter Email"
          />
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label">Password</label>
          <input
            type="password"
            name="user_password"
            class="form-control"
            id="exampleInputPassword1"
            placeholder="Enter Here"
          />
        </div>

        <div class="container text-center">
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
      </form>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
  </body>
</html>