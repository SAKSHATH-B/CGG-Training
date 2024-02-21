package cgg.blogapp.blogapp.services;

import cgg.blogapp.blogapp.payloads.CommentDTO;

public interface CommentService {
  CommentDTO createComment(CommentDTO commentDTO, int postId);
  void deleteComment(int commentId);
}
