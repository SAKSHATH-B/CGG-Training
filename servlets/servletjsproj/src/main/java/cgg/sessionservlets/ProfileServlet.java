package cgg.sessionservlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profileservlet")
public class ProfileServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();
    HttpSession session = req.getSession(false);

    if (session != null) {
      String userId = (String) session.getAttribute("userid");
      writer.println("<h2>Welcome to Profile Servlet" + userId + " </h2>");
    } else {
      //   resp.sendRedirect("login.html");

      RequestDispatcher rd = req.getRequestDispatcher("login.html");
      rd.include(req, resp);
    }
    writer.println("<h2><a href='sessiondemo.html'>Back Home</a></h2>");
  }
}
