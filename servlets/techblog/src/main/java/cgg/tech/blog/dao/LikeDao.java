package cgg.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao {

  private Connection conn;

  public LikeDao(Connection conn) {
    this.conn = conn;
  }

  public Boolean insertLike(int pid, int uid) {
    boolean f = false;
    try {
      PreparedStatement ps = conn.prepareStatement(
        "insert into likes(pid,uid) values(?,?)"
      );
      ps.setInt(1, pid);
      ps.setInt(2, uid);
      ps.executeUpdate();
      f = true;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return f;
  }

  public int countLikeOnPost(int pid) {
    int count = 0;
    try {
      PreparedStatement ps = conn.prepareStatement(
        "select count(*) from likes where pid=?"
      );
      ps.setInt(1, pid);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        count = rs.getInt(1);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  public Boolean isLikedByUser(int pid, int uid) {
    boolean f = false;
    try {
      PreparedStatement ps = conn.prepareStatement(
        "select * from likes where pid=? and uid=?"
      );
      ps.setInt(1, pid);
      ps.setInt(2, uid);
      ps.executeQuery();

      f = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return f;
  }

  public Boolean deleteLike(int pid, int uid) {
    boolean f = false;

    try {
      PreparedStatement ps = conn.prepareStatement(
        "delete from likes where pid=? and uid=?"
      );
      ps.setInt(1, pid);
      ps.setInt(2, uid);
      ps.executeUpdate();
      f = true;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return f;
  }
}
