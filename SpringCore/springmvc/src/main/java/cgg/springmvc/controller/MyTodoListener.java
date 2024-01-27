package cgg.springmvc.controller;

import cgg.springmvc.entities.Todo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class MyTodoListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("context created...");
    List<Todo> list = new ArrayList<>();
    ServletContext context = sce.getServletContext();
    context.setAttribute("list", list);
  }
}
