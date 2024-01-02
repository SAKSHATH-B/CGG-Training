package cgg.servletparams;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/displaycontext")
public class DisplayContext extends GenericServlet {

  private int count;
  private String name;
  private ServletContext ctx;

  public void init(ServletConfig cfg) {
    ctx = cfg.getServletContext();
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
    throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter writer = res.getWriter();
    count = Integer.parseInt(ctx.getInitParameter("count"));
    name = ctx.getInitParameter("name");
    writer.println("Count Value : " + count);
    writer.println("Name is : " + name);
  }
}
