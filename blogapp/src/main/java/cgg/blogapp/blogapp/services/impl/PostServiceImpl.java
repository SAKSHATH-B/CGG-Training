package cgg.blogapp.blogapp.services.impl;

import cgg.blogapp.blogapp.dao.PostRepository;
import cgg.blogapp.blogapp.entities.Post;
import cgg.blogapp.blogapp.exceptions.ResourceNotFoundException;
import cgg.blogapp.blogapp.payloads.PostDTO;
import cgg.blogapp.blogapp.services.PostService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public PostDTO createPost(PostDTO postDTO) {
    Post savedPost = postRepository.save(postDtoToPost(postDTO));
    return postToPostDto(savedPost);
  }

  @Override
  public PostDTO updatePost(PostDTO postDTO, int postId) {
    Post existingPost = postRepository
      .findById(postId)
      .orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
    existingPost.setTitle(postDTO.getTitle());
    existingPost.setContent(postDTO.getContent());
    existingPost.setImageName(postDTO.getImageName());
    existingPost.setAddedDate(postDTO.getAddedDate());
    Post updatedPost = postRepository.save(existingPost);
    return postToPostDto(updatedPost);
  }

  @Override
  public void deletePost(int postId) throws ResourceNotFoundException {
    Post existingPost = postRepository
      .findById(postId)
      .orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
    postRepository.deleteById(existingPost.getPostId());
  }

  @Override
  public PostDTO getPostById(int postId) {
    Post existingPost = postRepository
      .findById(postId)
      .orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
    return postToPostDto(existingPost);
  }

  @Override
  public List<PostDTO> getAllPosts() {
    List<Post> allPosts = postRepository.findAll();
    List<PostDTO> postDTOs = allPosts
      .stream()
      .map(post -> postToPostDto(post))
      .collect(Collectors.toList());
    return postDTOs;
  }

  public Post postDtoToPost(PostDTO postDTO) {
    return modelMapper.map(postDTO, Post.class);
  }

  public PostDTO postToPostDto(Post post) {
    return modelMapper.map(post, PostDTO.class);
  }

  @Override
  public List<PostDTO> loadPostUserWise(int userId) {
    List<Post> posts = postRepository.findByUserUserId(userId);
    System.out.println("------------------" + posts);
    return posts
      .stream()
      .map(p -> modelMapper.map(p, PostDTO.class))
      .collect(Collectors.toList());
  }
}
