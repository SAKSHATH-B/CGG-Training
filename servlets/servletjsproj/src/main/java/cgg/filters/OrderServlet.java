package cgg.filters;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    System.out.println("Order Servlet");
    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();
    writer.println(
      "<h1>Welcome to OrderServlet Page... " + req.getContextPath() + "</h1>"
    );
    writer.close();
  }
}
