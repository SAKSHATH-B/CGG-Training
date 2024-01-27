package cgg.springmvc.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

  @Override
  public void afterCompletion(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    Exception ex
  ) throws Exception {
    System.out.println("After Completion");
  }

  @Override
  public void postHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    ModelAndView modelAndView
  ) throws Exception {
    System.out.println("This is PostHandler");
  }

  @Override
  public boolean preHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler
  ) throws Exception {
    System.out.println("This is PreHandler");
    if (request.getParameter("user").startsWith("d")) {
      response.setContentType("text/html");
      PrintWriter writer = response.getWriter();
      writer.println("<h1>Invalid name..Name should not start with d.</h1>");
      return false;
    }
    return true;
  }
}
