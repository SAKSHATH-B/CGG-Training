package com.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Register")
@MultipartConfig
public class Register extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();

    String name = req.getParameter("user_name");
    String password = req.getParameter("user_password");
    String email = req.getParameter("user_email");
    Part part = req.getPart("image");
    String filename = part.getSubmittedFileName();

    // writer.println(name);
    // writer.println(password);
    // writer.println(email);
    // writer.println(filename);

    //connection
    try {
      Thread.sleep(3000);
      Class.forName("org.postgresql.Driver");
      Connection connection = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/test",
        "postgres",
        "postgres"
      );

      //query
      String query =
        "insert into register (name,password,email,imageName) values(?,?,?,?)";
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setString(1, name);
      ps.setString(2, password);
      ps.setString(3, email);
      ps.setString(4, filename);

      ps.executeUpdate();

      //upload
      InputStream is = part.getInputStream();
      byte[] data = new byte[is.available()];
      is.read(data);
      String path =
        req.getServletContext().getRealPath("/") +
        "images" +
        File.separator +
        filename;
      FileOutputStream fos = new FileOutputStream(path);
      fos.write(data);
      fos.close();

      writer.println("done");
    } catch (Exception e) {
      e.printStackTrace();
      writer.println("error");
    }
  }
}
