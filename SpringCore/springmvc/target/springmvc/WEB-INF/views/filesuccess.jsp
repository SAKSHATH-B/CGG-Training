<%@ page isELIgnored="false" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Upload Image</title>
  </head>
  <body>
    <h1>${msg}</h1>
    <h1>${filename}</h1>
    <img src="<c:url value='/resources/images/${filename}' />" alt="image" />
  </body>
</html>
