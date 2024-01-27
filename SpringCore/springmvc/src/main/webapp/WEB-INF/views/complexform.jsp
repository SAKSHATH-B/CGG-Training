<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
  <body style="background: cadetblue">
    <div class="container">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <div class="card">
            <div class="card-body">
              <h3 class="text-center">Complex Form</h3>
              <form action="handleForm" method="post">
                <div class="alert alert-danger" role="alert">
                  <form:errors path="student.*" />
                </div>
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label"
                    >Your Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="name"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                    placeholder="Enter name"
                  />
                </div>
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label"
                    >Your Id</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="id"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                    placeholder="Enter id"
                  />
                </div>
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label"
                    >Your DOB</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="dob"
                    id="exampleInputEmail1"
                    aria-describedby="emailHelp"
                    placeholder="dd/mm/yyyy"
                  />
                </div>
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label"
                    >Select Courses</label
                  >
                  <select
                    class="form-select"
                    aria-label="Default select example"
                    name="courses"
                    multiple
                  >
                    <option value="0">Java</option>
                    <option value="1">Python</option>
                    <option value="2">C++</option>
                    <option value="3">Django</option>
                  </select>
                </div>
                <div class="mb-3">
                  <span class="ms-3">Select Gender : </span>
                  <div class="form-check form-check-inline">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="gender"
                      id="inlineRadio1"
                      value="male"
                    />
                    <label class="form-check-label" for="inlineRadio1"
                      >Male</label
                    >
                  </div>
                  <div class="form-check form-check-inline">
                    <input
                      class="form-check-input"
                      type="radio"
                      name="gender"
                      id="inlineRadio1"
                      value="female"
                    />
                    <label class="form-check-label" for="inlineRadio1"
                      >FeMale</label
                    >
                  </div>
                </div>
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label"
                    >Select Type</label
                  >
                  <select
                    class="form-select"
                    aria-label="Default select example"
                    name="type"
                  >
                    <option value="old student">Old Student</option>
                    <option value="normal student">Normal Student</option>
                  </select>
                </div>
                <div class="card">
                  <div class="card-body">
                    <p>Your Address :</p>
                    <div class="mb-3">
                      <input
                        type="text"
                        class="form-control"
                        name="address.street"
                        id="exampleInputEmail1"
                        aria-describedby="emailHelp"
                        placeholder="Enter Street"
                      />
                    </div>
                    <div class="mb-3">
                      <input
                        type="text"
                        class="form-control"
                        name="address.city"
                        id="exampleInputEmail1"
                        aria-describedby="emailHelp"
                        placeholder="Enter City"
                      />
                    </div>
                  </div>
                </div>
                <div class="container text-center">
                  <button type="submit" class="btn btn-primary mt-2">
                    Submit
                  </button>
                </div>
              </form>
            </div>
          </div>
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
