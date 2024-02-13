package com.stackroute.keepnote.service;

import com.stackroute.keepnote.dao.CategoryDAO;
import com.stackroute.keepnote.exceptions.CategoryNotFoundException;
import com.stackroute.keepnote.model.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service classes are used here to implement additional business logic/validation
 * This class has to be annotated with @Service annotation.
 * @Service - It is a specialization of the component annotation. It doesn�t currently
 * provide any additional behavior over the @Component annotation, but it�s a good idea
 * to use @Service over @Component in service-layer classes because it specifies intent
 * better. Additionally, tool support and additional behavior might rely on it in the
 * future.
 * */

@Service
public class CategoryServiceImpl implements CategoryService {

  /*
   * Autowiring should be implemented for the CategoryDAO. (Use Constructor-based
   * autowiring) Please note that we should not create any object using the new
   * keyword.
   */
  @Autowired
  CategoryDAO categoryDAO;

  /*
   * This method should be used to save a new category.
   */
  public boolean createCategory(Category category) {
    return categoryDAO.createCategory(category);
  }

  /* This method should be used to delete an existing category. */
  public boolean deleteCategory(int categoryId) {
    return categoryDAO.deleteCategory(categoryId);
  }

  /*
   * This method should be used to update a existing category.
   */

  public Category updateCategory(Category category, int categoryId)
    throws CategoryNotFoundException {
    Category categoryById = categoryDAO.getCategoryById(categoryId);
    if (categoryById != null) {
      categoryDAO.updateCategory(categoryById);
    } else {
      throw new CategoryNotFoundException("Category not found...");
    }
    return category;
  }

  /*
   * This method should be used to get a category by categoryId.
   */
  public Category getCategoryById(int categoryId)
    throws CategoryNotFoundException {
    Category categoryById = categoryDAO.getCategoryById(categoryId);
    if (categoryById != null) {
      return categoryById;
    } else {
      throw new CategoryNotFoundException("Category not found...");
    }
  }

  /*
   * This method should be used to get a category by userId.
   */

  public List<Category> getAllCategoryByUserId(int userId) {
    List<Category> allCategoryByUserId = categoryDAO.getAllCategoryByUserId(
      userId
    );
    return allCategoryByUserId;
  }
}