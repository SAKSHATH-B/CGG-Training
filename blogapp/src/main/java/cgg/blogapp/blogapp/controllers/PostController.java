package cgg.blogapp.blogapp.controllers;

import cgg.blogapp.blogapp.payloads.PostDTO;
import cgg.blogapp.blogapp.services.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

  @Autowired
  private PostService postService;

  @PostMapping("/")
  public ResponseEntity<PostDTO> create(@RequestBody PostDTO postDTO) {
    PostDTO createdPost = postService.createPost(postDTO);
    return new ResponseEntity<PostDTO>(createdPost, HttpStatus.CREATED);
  }

  @PutMapping("/{postId}")
  public ResponseEntity<PostDTO> update(
    @PathVariable("postId") int postId,
    @RequestBody PostDTO postDTO
  ) {
    PostDTO updatedPost = postService.updatePost(postDTO, postId);
    return new ResponseEntity<PostDTO>(updatedPost, HttpStatus.OK);
  }

  @GetMapping("/{postId}")
  public ResponseEntity<PostDTO> getPost(@PathVariable("postId") int postId) {
    return new ResponseEntity<PostDTO>(
      postService.getPostById(postId),
      HttpStatus.OK
    );
  }

  @GetMapping("/")
  public ResponseEntity<List<PostDTO>> getAllPosts() {
    List<PostDTO> allPosts = postService.getAllPosts();
    return new ResponseEntity<List<PostDTO>>(allPosts, HttpStatus.OK);
  }

  @DeleteMapping("/{postId}")
  public ResponseEntity<ProblemDetail> delete(
    @PathVariable("postId") int postId
  ) {
    postService.deletePost(postId);
    return ResponseEntity
      .of(
        ProblemDetail.forStatusAndDetail(
          HttpStatus.OK,
          "Post Deleted Successfully..."
        )
      )
      .build();
  }
}
