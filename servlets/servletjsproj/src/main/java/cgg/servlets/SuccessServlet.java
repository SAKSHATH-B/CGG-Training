package cgg.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SuccessServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    // String name = req.getParameter("user_name");
    // String password = req.getParameter("user_password");
    // String email = req.getParameter("user_email");
    // String gender = req.getParameter("user_gender");
    // String course = req.getParameter("user_course");
    // String condition = req.getParameter("condition");

    resp.setContentType("text/html");

    PrintWriter writer = resp.getWriter();
    System.out.println("This is success servlet");

    // writer.println("<h2>Name : " + name + "</h2>");
    // writer.println("<h2>Passowrd : " + password + "</h2>");
    // writer.println("<h2>Email : " + email + "</h2>");
    // writer.println("<h2>Gender : " + gender + "</h2>");
    // writer.println("<h2>Course : " + course + "</h2>");
    writer.println("<h2>Successfully Registered</h2>");
  }
}
