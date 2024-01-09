<html>
  <body>
    <% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %>
    parameter name is: <%=request.getParameter("name") %>
  </body>
</html>
