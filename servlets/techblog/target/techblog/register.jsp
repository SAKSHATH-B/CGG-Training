<%@ page errorPage="error_page.jsp" %>
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
          0 16%,
          15% 0,
          15% 0%,
          85% 0%,
          85% 100%,
          100% 0,
          100% 86%,
          100% 86%,
          85% 100%,
          15% 100%,
          15% 0,
          0 100%
        );
      }
    </style>
    <title>Register Page</title>
  </head>
  <body>
    <%@ include file="normal_navbar.jsp" %>
    <main
      class="primary-background banner-background"
      style="padding-bottom: 50px"
    >
      <div class="container">
        <div class="row">
          <div class="col-md-6 offset-md-3">
            <div class="card">
              <div
                class="card-header text-center text-white primary-background"
              >
                <span class="fa fa-user-circle fa-3x"></span>
                <p>Register Here</p>
              </div>
              <div class="card-body">
                <form id="reg-form" action="registerservlet" method="post">
                  <div class="mb-3">
                    <label for="user_name" class="form-label">User Name</label>
                    <input
                      type="text"
                      name="user_name"
                      class="form-control"
                      id="user_name"
                      aria-describedby="emailHelp"
                      placeholder="Enter username"
                    />
                  </div>
                  <div class="mb-3">
                    <label for="exampleInputEmail1">Email address</label>
                    <input
                      type="email"
                      name="user_email"
                      class="form-control"
                      id="exampleInputEmail1"
                      aria-describedby="emailHelp"
                      placeholder="Enter email"
                    />
                  </div>
                  <div class="mb-3">
                    <label for="exampleInputPassword1">Password</label>
                    <input
                      type="password"
                      name="user_password"
                      class="form-control"
                      id="exampleInputPassword1"
                      placeholder="Password"
                    />
                  </div>
                  <div class="mb-3">
                    <label for="gender" class="form-label">Select Gender</label>
                    <br />
                    <input
                      type="radio"
                      id="gender"
                      name="gender"
                      value="male"
                    />Male
                    <input
                      type="radio"
                      id="gender"
                      name="gender"
                      value="female"
                    />Female
                  </div>
                  <div class="mb-3">
                    <textarea
                      name="about"
                      class="form-control"
                      rows="5"
                      placeholder="Enter something about yourself"
                    ></textarea>
                  </div>
                  <div class="mb-3 form-check">
                    <input
                      type="checkbox"
                      name="check"
                      class="form-check-input"
                      id="exampleCheck1"
                    />
                    <label class="form-check-label" for="exampleCheck1"
                      >Agree Terms and Conditions</label
                    >
                  </div>
                  <div
                    id="loader"
                    class="container text-center"
                    style="display: none"
                  >
                    <span class="fa fa-refresh fa-spin fa-4x"></span>
                    <p>Please Wait...</p>
                  </div>
                  <button id="done" type="submit" class="btn btn-primary">
                    Submit
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <script
      src="https://code.jquery.com/jquery-3.7.1.min.js"
      integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
      crossorigin="anonymous"
    ></script>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"
      integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>

    <script>
      $(document).ready(function () {
        console.log("loaded");

        $("#reg-form").on("submit", function (event) {
          event.preventDefault();
          let formData = new FormData(this);
          $("#loader").show();
          $("#done").hide();
          $.ajax({
            url: "registerservlet",
            type: "POST",
            data: formData,
            success: function (data, textStatus, jqXHR) {
              console.log(data);
              $("#loader").hide();
              $("#done").show();
              if (data.trim() === "done") {
                swal(
                  "Registered Successfully...Redirectiong to login page"
                ).then((value) => {
                  window.location = "login.jsp";
                });
              } else {
                swal(data);
              }
            },
            error: function (jqXHR, textxStatus, errorThrown) {
              console.log(jqXHR);
              $("#loader").show();
              $("#done").hide();
              swal("Something went wrong..,Please try again");
            },
            processData: false,
            contentType: false,
          });
        });
      });
    </script>
  </body>
</html>
