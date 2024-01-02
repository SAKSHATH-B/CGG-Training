package cgg.tech.blog.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

  private static Connection conn;

  public static Connection getConnection() {
    try {
      if (conn == null) {
        Class.forName("org.postgresql.Driver");
        conn =
          DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/techblog",
            "postgres",
            "postgres"
          );
      }
    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return conn;
  }
}
