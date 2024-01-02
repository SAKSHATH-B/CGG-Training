package cgg.servletparams;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet(
//   urlPatterns = "/displayconfig",
//   initParams = @WebInitParam(name = "count", value = "10")
// )
@WebServlet(
  urlPatterns = "/displayconfig",
  initParams = {
    @WebInitParam(name = "count", value = "10"),
    @WebInitParam(name = "name", value = "Gachibowli"),
  }
)
public class DisplayConfig extends GenericServlet {

  private int count;
  private String name;

  public void init(ServletConfig config) {
    count = Integer.parseInt(config.getInitParameter("count"));
    name = config.getInitParameter("name");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
    throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter writer = res.getWriter();
    writer.println("Count Value: " + count);
    writer.println("<br>");
    writer.println("Name : " + name);
    writer.close();
  }
}
