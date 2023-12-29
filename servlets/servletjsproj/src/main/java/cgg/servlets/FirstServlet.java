package cgg.servlets;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FirstServlet implements Servlet {

  private ServletConfig config;

  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;
    System.out.println("Creating Object.............");
  }

  @Override
  public ServletConfig getServletConfig() {
    return config;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
    throws ServletException, IOException {
    System.out.println("Servicing.............");
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    out.println("<h1>This is new course on Servlets and Jsp</h1>");
    out.println("<h1>Todays date and time is " + new Date() + "</h1>");
  }

  @Override
  public String getServletInfo() {
    return "This servlet is created on 28th Dec 2023";
  }

  @Override
  public void destroy() {
    System.out.println("Object is going to be destroyed.....");
  }
}
