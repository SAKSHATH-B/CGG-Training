<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <jsp:useBean id="calc" class="cgg.Calculator"></jsp:useBean>
    <% int res = calc.cube(5); %> Cube of 5 is : <%= res %>
  </body>
</html>
