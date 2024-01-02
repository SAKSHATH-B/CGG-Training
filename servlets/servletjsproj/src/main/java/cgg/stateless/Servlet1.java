package cgg.stateless;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String name = req.getParameter("user_name");

    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    //cookie to save user info and travel through response
    //creating a cookie
    // Cookie cookie = new Cookie("user_name", name);
    // resp.addCookie(cookie);

    writer.println(
      "<h1>Hello " + name + "! Welcome to my Website in servlet1</h1>"
    );
    // writer.println("<h1><a href='servlet2'>Go To Servlet2</a></h1>");

    //urlRewriting
    // writer.println(
    //   "<h1><a href='servlet2?name=" + name + "'>Go To Servlet2</a></h1>"
    // );

    //Hidden Form field
    writer.println(
      "<Form action='servlet2'>" +
      "<input type='hidden' name='name' value='" +
      name +
      "' />" +
      "<button type='submit' >Go to second servlet</button>" +
      "</Form>"
    );
  }
}
