package cgg.blogapp.blogapp.services;

import cgg.blogapp.blogapp.exceptions.ResourceNotFoundException;
import cgg.blogapp.blogapp.payloads.PostDTO;
import java.util.List;

public interface PostService {
  public PostDTO createPost(PostDTO postDTO);

  public PostDTO updatePost(PostDTO postDTO, int postId);

  public void deletePost(int postId) throws ResourceNotFoundException;

  public PostDTO getPostById(int postId);

  public List<PostDTO> getAllPosts();

  public List<PostDTO> loadPostUserWise(int userId);
}
