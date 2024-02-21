package cgg.blogapp.blogapp.controllers;

import cgg.blogapp.blogapp.entities.Category;
import cgg.blogapp.blogapp.entities.User;
import cgg.blogapp.blogapp.payloads.PostDTO;
import cgg.blogapp.blogapp.services.CategoryService;
import cgg.blogapp.blogapp.services.PostService;
import cgg.blogapp.blogapp.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@SecurityRequirement(name = "scheme1")
@CrossOrigin("*")
public class PostController {

  @Autowired
  private PostService postService;

  @Autowired
  private UserService userService;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private ModelMapper mapper;

  @GetMapping("/test")
  public String test() {
    return "Testing";
  }

  @PostMapping("/user/{userId}/category/{categoryId}/posts")
  public ResponseEntity<PostDTO> create(
    @RequestBody PostDTO postDTO,
    @PathVariable int userId,
    @PathVariable int categoryId
  ) {
    System.out.println(userId + "========" + categoryId);
    System.out.println(postDTO);

    User user = mapper.map(userService.getUserById(userId), User.class);
    System.out.println(user);
    if (user == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    postDTO.setUser(user);

    Category category = mapper.map(
      categoryService.getCategoryById(categoryId),
      Category.class
    );
    System.out.println(category);
    if (category == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    postDTO.setCategory(category);

    // postDTO.setImageName("Hello.jpg");
    PostDTO createdPost = postService.createPost(postDTO);
    System.out.println("--------------------------");
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

  @GetMapping("/user/{userId}/posts")
  public ResponseEntity<List<PostDTO>> loadPostUserWise(
    @PathVariable int userId
  ) {
    List<PostDTO> posts = postService.loadPostUserWise(userId);
    return new ResponseEntity<>(posts, HttpStatus.OK);
  }
}
