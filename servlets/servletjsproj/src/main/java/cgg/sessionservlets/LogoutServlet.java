package cgg.sessionservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logoutservlet")
public class LogoutServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    HttpSession session = req.getSession(false);
    session.invalidate();
    writer.println("<h2>Successfully Logout...</h2>");
    writer.println(
      "<h2>Press <a href='sessiondemo.html'>here</a> to login.</h2>"
    );
  }
}
