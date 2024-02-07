package com.stackroute.keepnote.service;

import com.stackroute.keepnote.exceptions.CategoryNotFoundException;
import com.stackroute.keepnote.model.Category;
import java.util.List;

public interface CategoryService {
  /*
   * Should not modify this interface. You have to implement these methods in
   * corresponding Impl classes
   */
  public boolean createCategory(Category category);

  public boolean deleteCategory(int categoryId);

  public Category updateCategory(Category category, int categoryId)
    throws CategoryNotFoundException;

  public Category getCategoryById(int categoryId)
    throws CategoryNotFoundException;

  public List<Category> getAllCategoryByUserId(int userId);
}
