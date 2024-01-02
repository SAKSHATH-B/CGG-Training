<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>First Jsp Page</title>
  </head>
  <body style="background-color: aqua">
    <h1>First Jsp Page</h1>
    <%! int a = 5; int b = 6; String name = "Cgg,Gachibowli"; public int
    doSum(){ return a+b; } public String rev(){ StringBuffer sb = new
    StringBuffer(name); return sb.reverse().toString(); } %> <% out.println(a);
    out.println("<br />"); out.println(b); out.println("<br />");
    out.println("Sum = "+doSum()); out.println("<br />"); out.println(rev()); %>

    <h1>Sum is : <%= doSum()%></h1>
    <h1>a : <%= a%></h1>
  </body>
</html>
