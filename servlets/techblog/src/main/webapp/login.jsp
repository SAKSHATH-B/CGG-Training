<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link rel="stylesheet" href="css/style.css" />
    <style>
      .banner-background {
        clip-path: polygon(
          43% 17%,
          34% 0,
          93% 14%,
          100% 100%,
          59% 82%,
          72% 100%,
          6% 90%,
          0 0
        );
      }
    </style>
    <title>Login Page</title>
  </head>
  <body>
    <%@ include file="normal_navbar.jsp"%>
    <main
      class="d-flex align-items-center primary-background banner-background"
      style="height: 70vh"
    >
      <div class="container">
        <div class="row">
          <div class="col-md-4 offset-md-4">
            <form action="loginservlet" method="post">
            <div class="card">
              <div class="primary-background text-white text-center">
                <span class="fa fa-user-plus fa-3x"></span>
                <p>Login Here</p>
              </div>
              <div class="card-body">
                  <div class="mb-3">
                    <label for="exampleInputEmail1">Email address</label>
                    <input
                      type="email"
                      class="form-control"
                      name="email"
                      id="exampleInputEmail1"
                      aria-describedby="emailHelp"
                      placeholder="Enter email"
                    />
                    <small id="emailHelp" class="form-text text-muted"
                      >We'll never share your email with anyone else.</small
                    >
                  </div>
                  <div class="mb-3">
                    <label for="exampleInputPassword1">Password</label>
                    <input
                      type="password"
                      class="form-control"
                      name="password"
                      id="exampleInputPassword1"
                      placeholder="Password"
                    />
                  </div>
                  <!-- <div class="mb-3">
                    <input
                      type="checkbox"
                      class="form-check-input"
                      id="exampleCheck1"
                    />
                    <label class="form-check-label" for="exampleCheck1"
                      >Check me out</label
                    >
                  </div> -->
                  <div class="container text-center">
                    <button type="submit" class="btn btn-primary">
                      Submit
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </main>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
