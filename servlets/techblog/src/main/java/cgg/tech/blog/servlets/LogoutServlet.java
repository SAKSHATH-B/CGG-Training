package cgg.tech.blog.servlets;

import cgg.tech.blog.entities.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logoutservlet")
public class LogoutServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.removeAttribute("user");

    Message message = new Message(
      "LogOut Successful...",
      "success",
      "alert-success"
    );

    session.setAttribute("msg", message);
    resp.sendRedirect("login.jsp");
  }
}
