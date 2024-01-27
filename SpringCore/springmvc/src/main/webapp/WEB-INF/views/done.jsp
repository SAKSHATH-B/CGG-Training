<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Success Page</title>
  </head>
  <body>
    <h1>Name : ${student.name}</h1>
    <h1>Id : ${student.id}</h1>
    <h1>DOB : ${student.dob}</h1>
    <h1>Courses : ${student.courses}</h1>
    <h1>Gender : ${student.gender}</h1>
    <h1>Type : ${student.type}</h1>
    <hr />
    <h1>Street : ${student.address.street}</h1>
    <h1>city : ${student.address.city}</h1>
  </body>
</html>
