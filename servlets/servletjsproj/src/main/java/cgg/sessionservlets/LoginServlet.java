package cgg.sessionservlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String userid = req.getParameter("userid");

    HttpSession session = req.getSession();
    if (userid.equalsIgnoreCase("admin")) {
      session.setAttribute("userid", userid);
      //   resp.sendRedirect("profileservlet");

      RequestDispatcher rd = req.getRequestDispatcher("/profileservlet");
      rd.forward(req, resp);
    } else {
      //   resp.sendRedirect("login.html");

      RequestDispatcher rd = req.getRequestDispatcher("login.html");
      rd.include(req, resp);
    }
  }
}
