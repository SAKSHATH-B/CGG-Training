package cgg.tech.blog.dao;

import cgg.tech.blog.entities.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

  private Connection conn;

  public PostDao(Connection conn) {
    this.conn = conn;
  }

  public List<Category> getAllCategories() {
    List<Category> categories = new ArrayList<>();

    try {
      String query = "select * from category";
      Statement statement = conn.createStatement();
      ResultSet rs = statement.executeQuery(query);
      while (rs.next()) {
        Category category = new Category();
        category.setCid(rs.getInt("cid"));
        category.setCname(rs.getString("cname"));
        category.setCdescription(rs.getString("cdescription"));
        categories.add(category);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return categories;
  }
}
