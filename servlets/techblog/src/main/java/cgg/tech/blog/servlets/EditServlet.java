package cgg.tech.blog.servlets;

import cgg.tech.blog.dao.UserDao;
import cgg.tech.blog.entities.Message;
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

@WebServlet("/editservlet")
@MultipartConfig
public class EditServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    //FETCH ALL DATA
    String userName = req.getParameter("user_name");
    String userEmail = req.getParameter("user_email");
    String userPassword = req.getParameter("user_password");
    String userGender = req.getParameter("user_gender");
    String userAbout = req.getParameter("user_about").trim();
    Part part = req.getPart("image");
    String imageName = part.getSubmittedFileName();

    //get the user from the session...
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");
    user.setEmail(userEmail);
    user.setName(userName);
    user.setPassword(userPassword);
    user.setGender(userGender);
    user.setAbout(userAbout);
    String oldFile = user.getProfile();
    user.setProfile(imageName);

    UserDao userDao = new UserDao(ConnectionProvider.getConnection());

    boolean ans = userDao.updateUser(user);
    if (ans) {
      String path =
        req.getServletContext().getRealPath("/") +
        "pics/" +
        File.separator +
        user.getProfile();

      //delete code for removing old profile pic from localStorage
      String pathOldFile =
        req.getServletContext().getRealPath("/") +
        "pics" +
        File.separator +
        oldFile;
      if (!oldFile.equals("default.png")) {
        Helper.deleteFile(pathOldFile);
      }

      if (Helper.saveFile(part.getInputStream(), path)) {
        writer.println("Updated to db");
        Message msg = new Message(
          "Profile Updated...",
          "success",
          "alert-success"
        );
        session.setAttribute("msg", msg);
      }
    } else {
      Message msg = new Message(
        "Something went wrong...",
        "error",
        "alert-danger"
      );
      session.setAttribute("msg", msg);
    }
    resp.sendRedirect("profile.jsp");
  }
}
