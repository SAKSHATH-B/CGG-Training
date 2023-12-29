package cgg.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ThirdServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    System.out.println("Servlet Using HttpServlet.....");
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<h1>This is using HttpServlet</h1>");
    out.println("<p>Date and Time : " + new Date() + "</p>");
  }
}
