package cgg.blogapp.blogapp.services.impl;

import cgg.blogapp.blogapp.dao.CommentRepository;
import cgg.blogapp.blogapp.dao.PostRepository;
import cgg.blogapp.blogapp.entities.Comment;
import cgg.blogapp.blogapp.entities.Post;
import cgg.blogapp.blogapp.exceptions.ResourceNotFoundException;
import cgg.blogapp.blogapp.payloads.CommentDTO;
import cgg.blogapp.blogapp.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public CommentDTO createComment(CommentDTO commentDTO, int postId) {
    Post postById = postRepository
      .findById(postId)
      .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
    Comment comment = modelMapper.map(commentDTO, Comment.class);
    comment.setPost(postById);
    Comment savedComment = commentRepository.save(comment);
    return modelMapper.map(savedComment, CommentDTO.class);
  }

  @Override
  public void deleteComment(int commentId) {
    Comment comment = commentRepository
      .findById(commentId)
      .orElseThrow(() ->
        new ResourceNotFoundException("Comment", "id", commentId)
      );
    commentRepository.delete(comment);
  }
}
