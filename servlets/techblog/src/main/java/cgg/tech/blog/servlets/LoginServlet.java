package cgg.tech.blog.servlets;

import cgg.tech.blog.dao.UserDao;
import cgg.tech.blog.entities.User;
import cgg.tech.blog.helper.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String email = req.getParameter("email");
    String password = req.getParameter("password");

    UserDao userDao = new UserDao(ConnectionProvider.getConnection());

    User user = userDao.getUserByEmailAndPassword(email, password);

    if (user == null) {
      //display error...
      resp.setContentType("text/html");
      PrintWriter writer = resp.getWriter();
      writer.println("Invalid Credentials! Try again...");
    } else {
      HttpSession session = req.getSession();
      session.setAttribute("user", user);
      resp.sendRedirect("profile.jsp");
    }
  }
}
