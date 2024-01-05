<%@ page errorPage="error_page.jsp" %> <%@ page
import="cgg.tech.blog.entities.User" %> <% User user =
(User)session.getAttribute("user"); if(user==null){
response.sendRedirect("login.jsp"); } %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <%= user.getName() %>
    <br />
    <%= user.getEmail() %>
    <br />
    <%= user.getAbout() %>
  </body>
</html>
