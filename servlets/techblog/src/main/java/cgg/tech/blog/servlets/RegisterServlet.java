package cgg.tech.blog.servlets;

import cgg.tech.blog.dao.UserDao;
import cgg.tech.blog.entities.User;
import cgg.tech.blog.helper.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerservlet")
public class RegisterServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String check = req.getParameter("check");

    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    if (check == null) {
      writer.println("Box not checked");
    } else {
      //accept the data
      String name = req.getParameter("user_name");
      String email = req.getParameter("user_email");
      String password = req.getParameter("user_password");
      String gender = req.getParameter("gender");
      String about = req.getParameter("about");

      User user = new User(name, email, password, about, gender);

      UserDao userDao = new UserDao(ConnectionProvider.getConnection());

      if (userDao.saveUser(user)) {
        writer.println("User Registered Successfully...");
      } else {
        writer.println("Error 404");
      }
    }
  }
}
