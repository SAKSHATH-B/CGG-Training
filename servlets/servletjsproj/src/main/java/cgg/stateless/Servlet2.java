package cgg.stateless;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    //without Cookies
    // String name = req.getParameter("user_name");

    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    //with Cookies
    // Cookie[] cookies = req.getCookies();
    // boolean flag = false;
    // String name = "";
    // if (cookies == null) {
    //   writer.println(
    //     "<h1>You are a new User please go to homepage(index.html) and enter your name.</h1>"
    //   );
    //   return;
    // } else {
    //   for (Cookie c : cookies) {
    //     String tname = c.getName();
    //     if (tname.equals("user_name")) {
    //       flag = true;
    //       name = c.getValue();
    //     }
    //   }
    // }
    // if (flag) {
    //   writer.println(
    //     "<h1>Hello " + name + "! Welcome back to my website in servlet2</h1>"
    //   );
    //   writer.println("<h1>ThankYou</h1>");
    // } else {
    //   writer.println(
    //     "<h1>You are a new User please go to homepage(index.html) and enter your name.</h1>"
    //   );
    // }

    //with urlReWriting
    writer.println("<h1 style='color:red'>Welcome to servlet 2..!</h1>");
    //fetch:url
    String name = req.getParameter("name");
    writer.println(
      "<h1 style='color:blue'>Welcome back " + name + "! to servlet 2..!</h1>"
    );

    writer.close();
  }
}
