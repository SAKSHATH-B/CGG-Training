<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %> <%@ page import="java.util.Random" %> <%@ page
session="false" %> <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Jsp Page</title>
  </head>
  <body>
    <h1>
      Random Number : <% Random r = new Random(); int n = r.nextInt(10);
      //out.println(n); %> <%= n%>
    </h1>
  </body>
</html>
