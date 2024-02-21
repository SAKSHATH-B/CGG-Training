package cgg.blogapp.blogapp.dao;

import cgg.blogapp.blogapp.entities.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
  List<Post> findByUserUserId(int userId);
}
