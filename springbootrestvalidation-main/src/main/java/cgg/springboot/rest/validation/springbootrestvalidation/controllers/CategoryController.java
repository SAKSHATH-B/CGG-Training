package cgg.springboot.rest.validation.springbootrestvalidation.controllers;

import cgg.springboot.rest.validation.springbootrestvalidation.dto.CategoryDto;
import cgg.springboot.rest.validation.springbootrestvalidation.payload.ApiResponse;
import cgg.springboot.rest.validation.springbootrestvalidation.services.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/v1/categories")
@CrossOrigin("*")
@SecurityRequirement(name = "scheme1")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  //create
  @PostMapping("/")
  public ResponseEntity<CategoryDto> createCategory(
    @Valid @RequestBody CategoryDto categoryDto
  ) {
    CategoryDto createdCategory =
      this.categoryService.createCategory(categoryDto);

    return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
  }

  //update

  @PutMapping("/{catId}")
  public ResponseEntity<CategoryDto> updateCategory(
    @Valid @RequestBody CategoryDto categoryDto,
    @PathVariable int catId
  ) {
    CategoryDto updatedCategory =
      this.categoryService.updateCategory(categoryDto, catId);

    return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
  }

  //delete
  @DeleteMapping("/{catId}")
  public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int catId) {
    this.categoryService.deleteCategory(catId);

    return new ResponseEntity<ApiResponse>(
      new ApiResponse("Category deleted successfully", true),
      HttpStatus.OK
    );
  }

  //get

  @GetMapping("/{catId}")
  public ResponseEntity<CategoryDto> getCategory(@PathVariable int catId) {
    CategoryDto categoryDto = this.categoryService.getCategory(catId);

    return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
  }

  //get all
  @GetMapping("/")
  public ResponseEntity<List<CategoryDto>> getCategories() {
    List<CategoryDto> categories = this.categoryService.getCategories();

    return ResponseEntity.ok(categories);
  }
}
