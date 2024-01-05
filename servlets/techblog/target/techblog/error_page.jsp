<%@ page isErrorPage="true" %>
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
    <title>Sorry! Something went wrong</title>
  </head>
  <body>
    <div class="container p-3 text-center">
      <img class="img-fluid" src="images/browser.png" />
      <h1 class="display-3">Sorry! Something Went Wrong...</h1>
      <p><%= exception %></p>
      <a href="index.jsp" class="btn btn-lg primary-background text-white mt-3"
        >Return Back to HomePage</a
      >
    </div>
  </body>
</html>
