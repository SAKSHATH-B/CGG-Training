package cgg.tech.blog.servlets;

import cgg.tech.blog.dao.LikeDao;
import cgg.tech.blog.helper.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LikeServlet")
public class LikeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String operation = req.getParameter("operation");
    int pid = Integer.parseInt(req.getParameter("pid"));
    int uid = Integer.parseInt(req.getParameter("uid"));

    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();
    if (operation.equals("Like")) {
      LikeDao likeDao = new LikeDao(ConnectionProvider.getConnection());
      Boolean b = likeDao.insertLike(pid, uid);
      writer.println(b);
    }
  }
}
