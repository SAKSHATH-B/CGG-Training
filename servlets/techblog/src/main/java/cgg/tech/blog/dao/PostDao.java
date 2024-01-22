package cgg.tech.blog.dao;

import cgg.tech.blog.entities.Category;
import cgg.tech.blog.entities.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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

  public boolean savePost(Post p) {
    boolean f = false;

    try {
      String query =
        "insert into post(ptitle,pcontent,pcode,ppic,catid,userId) values(?,?,?,?,?,?)";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, p.getpTitle());
      ps.setString(2, p.getpContent());
      ps.setString(3, p.getpCode());
      ps.setString(4, p.getpPic());
      ps.setInt(5, p.getCatId());
      ps.setInt(6, p.getUserId());

      ps.executeUpdate();
      f = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return f;
  }

  public List<Post> getAllPosts() {
    List<Post> posts = new ArrayList<>();
    String query = "select * from post order by pid desc";
    try {
      PreparedStatement ps = conn.prepareStatement(query);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int pId = rs.getInt(1);
        String pTitle = rs.getString(2);
        String pContent = rs.getString(3);
        String pCode = rs.getString(4);
        String pPic = rs.getString(5);
        int cId = rs.getInt(6);
        Timestamp pDate = rs.getTimestamp(7);
        int userId = rs.getInt(8);

        Post post = new Post(
          pId,
          pTitle,
          pContent,
          pCode,
          pPic,
          cId,
          userId,
          pDate
        );
        posts.add(post);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return posts;
  }

  public List<Post> getPostbyCategory(int cid) {
    List<Post> posts = new ArrayList<>();
    String query = "select * from post where catid=?";
    try {
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setInt(1, cid);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int pId = rs.getInt(1);
        String pTitle = rs.getString(2);
        String pContent = rs.getString(3);
        String pCode = rs.getString(4);
        String pPic = rs.getString(5);
        int cId = rs.getInt(6);
        Timestamp pDate = rs.getTimestamp(7);
        int userId = rs.getInt(8);

        Post post = new Post(
          pId,
          pTitle,
          pContent,
          pCode,
          pPic,
          cId,
          userId,
          pDate
        );
        posts.add(post);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return posts;
  }

  public Post getPostById(int postId) {
    Post post = null;
    try {
      PreparedStatement ps = conn.prepareStatement(
        "select * from post where pid=?"
      );
      ps.setInt(1, postId);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        int pId = rs.getInt(1);
        String pTitle = rs.getString(2);
        String pContent = rs.getString(3);
        String pCode = rs.getString(4);
        String pPic = rs.getString(5);
        int cId = rs.getInt(6);
        Timestamp pDate = rs.getTimestamp(7);
        int userId = rs.getInt(8);

        post = new Post(pId, pTitle, pContent, pCode, pPic, cId, userId, pDate);
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    return post;
  }
}
