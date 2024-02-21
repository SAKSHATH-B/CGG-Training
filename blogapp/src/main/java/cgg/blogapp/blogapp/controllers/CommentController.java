package cgg.blogapp.blogapp.controllers;

import cgg.blogapp.blogapp.entities.Comment;
import cgg.blogapp.blogapp.payloads.APIResponse;
import cgg.blogapp.blogapp.payloads.CommentDTO;
import cgg.blogapp.blogapp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @PostMapping("/post/{postId}/comments")
  public ResponseEntity<CommentDTO> createComment(
    @RequestBody CommentDTO commentDto,
    @PathVariable int postId
  ) {
    System.out.println(commentDto.toString());
    CommentDTO createdComment = commentService.createComment(
      commentDto,
      postId
    );
    return new ResponseEntity<CommentDTO>(createdComment, HttpStatus.CREATED);
  }

  @DeleteMapping("/comments/{commentId}")
  public ResponseEntity<APIResponse> deleteComment(
    @PathVariable int commentId
  ) {
    commentService.deleteComment(commentId);
    return new ResponseEntity<APIResponse>(
      new APIResponse("Comment deleted successfully..!", true),
      HttpStatus.OK
    );
  }
}
