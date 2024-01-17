<%@ page errorPage="error_page.jsp" %> <%@ page
import="cgg.tech.blog.entities.*,cgg.tech.blog.dao.PostDao,cgg.tech.blog.helper.ConnectionProvider,java.util.List" %> <% User user =
(User)session.getAttribute("user"); %> <% Message msg =
(Message)session.getAttribute("msg");%>
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
    <title>Document</title>
  </head>
  <body>
    <!-- navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark primary-background">
      <a class="navbar-brand" href="index.jsp"
        ><span class="fa fa-asterisk"></span>TechBlog</a
      >
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#"
              ><span class="fa fa-bell"></span>Home</a
            >
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              <span class="fa fa-check-square-o"></span>Categories
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Programming Languages</a>
              <a class="dropdown-item" href="#">Project Implementation</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Tutorials</a>
            </div>
          </li>
          <li class="nav-item">
            <a
              class="nav-link"
              href="#"
              data-toggle="modal"
              data-target="#add-post-modal"
              ><span class="fa fa-asterisk"></span>DoPost</a
            >
          </li>

          <li class="nav-item">
            <a class="nav-link" href="#"
              ><span class="fa fa-address-card"></span>Contact</a
            >
          </li>
        </ul>

        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a
              id="profile"
              class="nav-link"
              href="#"
              data-toggle="modal"
              data-target="#profileModal"
              ><span class="fa fa-user-circle fa-spin"></span><%= user.getName()
              %></a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="logoutservlet"
              ><span class="fa fa-user-plus"></span>Logout</a
            >
          </li>
        </ul>
      </div>
    </nav>
    <!-- end-navbar -->

    <% if(msg!=null){ %>
    <div class="alert <%= msg.getCssClass()%>" role="alert">
      <%= msg.getContent() %>
    </div>
    <% } %>

    <main>
      <div class="container">
        <div class="row mt-4 d-flex">
          <!-- categories -->
          <div class="list-group">
            <a href="#!" onclick="getPost(0,this)" class="c-link list-group-item list-group-item-action active">
              All Posts
            </a>
            <%
              PostDao pd = new PostDao(ConnectionProvider.getConnection());
              List<Category> list = pd.getAllCategories();
                for(Category cc:list){
                  %>
                  <a href="#!" onclick="getPost('<%= cc.getCid() %>',this)" class="c-link list-group-item list-group-item-action"><%= cc.getCname() %></a>
                <%}%>
                
            
          </div>
          <!-- posts -->
          <div class="col-md-8">
            <div class="container text-center" id="loader">
              <i class="fa fa-refresh fa-4x fa-spin"></i>
              <h3 class="mt-2">Loading...</h3>
            </div>
            <div class="container-fluid" id="post-container">

            </div>
          </div>
        </div>
      </div>
    </main>

    <!-- Modal -->
    <!-- profile-modal -->
    <div
      class="modal fade"
      id="profileModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
      id="modall"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header primary-background text-white">
            <h5 class="modal-title" id="exampleModalLabel">Profile</h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <div class="container text-center">
              <img
                src="<%=request.getContextPath()%>/pics/<%= user.getProfile()%>"
                alt="Default.png"
                class="mb-3"
                style="border-radius: 50%; max-width: 150px"
              /><br />
              <h5 class="modal_title mt-3" id="exampleModalLabel">
                <%= user.getName() %>
              </h5>
              <div id="profile-details">
                <table class="table">
                  <tbody>
                    <tr>
                      <th scope="row">ID:</th>
                      <td><%= user.getId() %></td>
                    </tr>
                    <tr>
                      <th scope="row">Email:</th>
                      <td><%= user.getEmail() %></td>
                    </tr>
                    <tr>
                      <th scope="row">Gender:</th>
                      <td><%= user.getGender() %></td>
                    </tr>
                    <tr>
                      <th scope="row">Status:</th>
                      <td><%= user.getAbout() %></td>
                    </tr>
                    <tr>
                      <th scope="row">Registered On:</th>
                      <td><%= user.getRdate().toString() %></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div id="profile-edit" style="display: none">
                <h3 class="mt-2">Please edit carefully...</h3>
                <form
                  action="editservlet"
                  method="post"
                  enctype="multipart/form-data"
                >
                  <table class="table">
                    <tr>
                      <td>ID:</td>
                      <td><%= user.getId() %></td>
                    </tr>
                    <tr>
                      <td>Email:</td>
                      <td>
                        <input
                          type="email"
                          class="form-control"
                          name="user_email"
                          value="<%=user.getEmail()%>"
                        />
                      </td>
                    </tr>
                    <tr>
                      <td>Name:</td>
                      <td>
                        <input
                          type="text"
                          class="form-control"
                          name="user_name"
                          value="<%=user.getName()%>"
                        />
                      </td>
                    </tr>
                    <tr>
                      <td>Password:</td>
                      <td>
                        <input
                          type="password"
                          class="form-control"
                          name="user_password"
                          value="<%=user.getPassword()%>"
                        />
                      </td>
                    </tr>
                    <tr>
                      <td>Gender:</td>
                      <td>
                        <input
                          type="radio"
                          name="user_gender"
                          id="male"
                          value="male"
                        />Male
                        <input
                          type="radio"
                          name="user_gender"
                          id="female"
                          value="female"
                        />Female
                      </td>
                    </tr>
                    <tr>
                      <td>About:</td>
                      <td>
                        <textarea
                          rows="3"
                          class="form-control"
                          name="user_about"
                        >
<%=user.getAbout()%></textarea
                        >
                      </td>
                    </tr>
                    <tr>
                      <td>Update Profile pic:</td>
                      <td>
                        <input type="file" name="image" class="form-control" />
                      </td>
                    </tr>
                  </table>
                  <div class="container">
                    <button type="submit" class="btn btn-outline-primary">
                      Save
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button
              id="edit-profile-button"
              type="button"
              class="btn btn-primary"
            >
              EDIT
            </button>
            <button
              type="button"
              class="btn btn-secondary"
              data-dismiss="modal"
              id="close"
            >
              Close
            </button>
          </div>
        </div>
      </div>
    </div>
    <!-- end-profile-modal -->

    <!-- Add Post modal -->
    <!-- Modal -->
    <div
      class="modal fade"
      id="add-post-modal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">
              Provide the post detail
            </h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form action="addpostservlet" method="post" id="myform" enctype="multipart/form-data">
              <div class="form-group">
                <select name="cid" id="" class="form-control">
                  <option selected disabled>---select category---</option>
                  <% PostDao postDao = new PostDao(ConnectionProvider.getConnection());
                    List<Category> categories = postDao.getAllCategories();
                      for(Category cat:categories){
                  %>
                      <option value="<%= cat.getCid()%>"><%= cat.getCname() %></option>
                  <%}%>
                </select>
              </div>
              <div class="form-group">
                <input
                  type="text"
                  name="ptitle"
                  class="form-control"
                  placeholder="Enter Title"
                />
              </div>
              <div class="form-group">
                <textarea
                  name="pcontent"
                  class="form-control"
                  placeholder="Enter post content here (if any)"
                  style="height: 200px"
                ></textarea>
              </div>
              <div class="form-group">
                <textarea
                  name="pcode"
                  class="form-control"
                  placeholder="Enter your program Here (if any)"
                  style="height: 200px"
                ></textarea>
              </div>
              <div class="form-group">
                <label for="">Select your pic</label>
                <input type="file" name="ppic" class="form-control" />
              </div>
              <div class="container text-center">
                <button type="submit" class="btn btn-outline-primary">Save</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- end add post modal -->
  </body>

  <script
    src="https://code.jquery.com/jquery-3.7.1.min.js"
    integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
    crossorigin="anonymous"
  ></script>
  <!-- Javascript -->
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
    crossorigin="anonymous"
  ></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

  <!-- editbutton -->
  <script>
    $(document).ready(function () {
      let gender = "<%=user.getGender().trim()%>";
      console.log(gender);
      if (gender == "male") {
        $("#male").prop("checked", true);
      } else {
        $("#female").prop("checked", true);
      }

      let editStatus = false;
      $("#edit-profile-button").click(function () {
        if (editStatus == false) {
          $("#profile-details").hide();
          $("#profile-edit").show();
          editStatus = true;
          $(this).text("BACK");
        } else {
          $("#profile-details").show();
          $("#profile-edit").hide();
          editStatus = false;
          $(this).text("EDIT");
        }
      });

      $("#close").click(function () {
        $("#profile-details").show();
        $("#profile-edit").hide();
        editStatus = false;
      });
    });
  </script>
  <script>
    $(document).ready(function(){
      $("#myform").on('submit',function(event){
        event.preventDefault();
        let f = new FormData(this)
        $.ajax({
          url:"addpostservlet",
          type:'post',
          data:f,
          success:function(data,textStatus,jqXHR){
            //success
            console.log(data)
            if(data.trim()=="done"){
              swal("Good job!", "Post saved successfully...", "success");
            }else{
              swal("Error", "Something went wrong..Try again!", "error");
            }
          },
          error:function(jqXHR,textStatus,errorThrown){
            //error
            swal("Error", "Something went wrong..Try again!", "error");
          },
          processData:false,
          contentType:false
        })
      })
    })
  </script>

  <!-- loadpost -->
  <script>
    function getPost(cid,temp){
      $("#loader").show();
      $("#post-container").hide();
      $('.c-link').removeClass('active')
      $.ajax({
        url:"loadpost.jsp",
        data:{catId:cid},
        success:function(data,textStatus,jqXHR){
          console.log(data)
          $("#loader").hide()
          $("#post-container").show()
          $("#post-container").html(data)
          $(temp).addClass('active')
          
        },

        contentType:false
      })
    }
    $(document).ready(function(){
      
      getPost(0);
      
    })
  </script>
</html>
