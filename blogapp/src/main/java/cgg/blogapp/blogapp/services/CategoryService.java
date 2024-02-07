package cgg.blogapp.blogapp.services;

import cgg.blogapp.blogapp.exceptions.ResourceNotFoundException;
import cgg.blogapp.blogapp.payloads.CategoryDTO;
import java.util.List;

public interface CategoryService {
  public CategoryDTO createCategory(CategoryDTO categoryDTO);

  public CategoryDTO updateCategory(int categoryId, CategoryDTO categoryDTO);

  public void deleteCategory(int categoryId) throws ResourceNotFoundException;

  public CategoryDTO getCategoryById(int categoryId);

  public List<CategoryDTO> getAllCategories();
}
