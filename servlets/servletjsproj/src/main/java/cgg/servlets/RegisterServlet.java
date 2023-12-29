package cgg.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String name = req.getParameter("user_name");
    String password = req.getParameter("user_password");
    String email = req.getParameter("user_email");
    String gender = req.getParameter("user_gender");
    String course = req.getParameter("user_course");
    String condition = req.getParameter("condition");

    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    if (condition != null) {
      if (condition.equalsIgnoreCase("checked")) {
        writer.println("<h2>Name : " + name + "</h2>");
        writer.println("<h2>Passowrd : " + password + "</h2>");
        writer.println("<h2>Email : " + email + "</h2>");
        writer.println("<h2>Gender : " + gender + "</h2>");
        writer.println("<h2>Course : " + course + "</h2>");

        //jdbc
        //save to db
        RequestDispatcher rd = req.getRequestDispatcher("/success");
        rd.forward(req, resp);
      } else {
        writer.println("<h2>Please accept terms and conditions</h2>");
      }
    } else {
      writer.println("<h2>Please accept terms and conditions</h2>");
      RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
      rd.include(req, resp);
    }
  }
}
