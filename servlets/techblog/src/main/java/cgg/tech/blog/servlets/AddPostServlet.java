package cgg.tech.blog.servlets;

import cgg.tech.blog.dao.PostDao;
import cgg.tech.blog.entities.Post;
import cgg.tech.blog.entities.User;
import cgg.tech.blog.helper.ConnectionProvider;
import cgg.tech.blog.helper.Helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addpostservlet")
@MultipartConfig
public class AddPostServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    //fetch all data from doPost
    Integer cid = Integer.parseInt(req.getParameter("cid"));
    String ptitle = req.getParameter("ptitle");
    String pcontent = req.getParameter("pcontent");
    String pcode = req.getParameter("pcode");
    Part part = req.getPart("ppic");
    part.getSubmittedFileName();

    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");
    Post p = new Post(
      ptitle,
      pcontent,
      pcode,
      part.getSubmittedFileName(),
      cid,
      user.getId()
    );

    PostDao postDao = new PostDao(ConnectionProvider.getConnection());
    if (postDao.savePost(p)) {
      String path =
        req.getServletContext().getRealPath("/") +
        "blogpics/" +
        File.separator +
        part.getSubmittedFileName();

      Helper.saveFile(part.getInputStream(), path);
      writer.println("done");
    } else {
      writer.println("error");
    }
  }
}
