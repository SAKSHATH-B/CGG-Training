<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Success Page</title>
  </head>
  <body>
    <h1 class="text-center">${head}</h1>
    <p class="text-center">${desc}</p>
    <h1 style="color: green">${msg}</h1>
    <hr />
    <h1>Welcome, ${user.user_name}</h1>
    <h1>Email : ${user.user_email}</h1>
    <h1>Password : ${user.user_password}</h1>
  </body>
</html>
