package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.exceptions.CategoryNotFoundException;
import com.stackroute.keepnote.model.Category;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/*
 * This class is implementing the UserDAO interface. This class has to be annotated with
 * @Repository annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object,
 * thus clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database
 * 					transaction. The database transaction happens inside the scope of a persistence
 * 					context.
 * */
@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

  /*
   * Autowiring should be implemented for the SessionFactory.(Use
   * constructor-based autowiring.
   */
  SessionFactory sessionFactory;

  public CategoryDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /*
   * Create a new category
   */
  public boolean createCategory(Category category) {
    sessionFactory.getCurrentSession().persist(category);
    return true;
  }

  /*
   * Remove an existing category
   */
  public boolean deleteCategory(int categoryId) {
    Category category = sessionFactory
      .getCurrentSession()
      .get(Category.class, categoryId);
    if (category != null) {
      sessionFactory.getCurrentSession().remove(category);
      return true;
    }
    return false;
  }

  /*
   * Update an existing category
   */

  public boolean updateCategory(Category category) {
    Category merge = sessionFactory.getCurrentSession().merge(category);
    if (merge != null) {
      return true;
    }
    return false;
  }

  /*
   * Retrieve details of a specific category
   */

  public Category getCategoryById(int categoryId)
    throws CategoryNotFoundException {
    Category categoryById = sessionFactory
      .getCurrentSession()
      .get(Category.class, categoryId);
    return categoryById;
  }

  /*
   * Retrieve details of all categories by userId
   */
  public List<Category> getAllCategoryByUserId(int userId) {
    List<Category> allCategoryByUserId = sessionFactory
      .getCurrentSession()
      .createQuery("form Category", Category.class)
      .getResultList();
    return allCategoryByUserId;
  }
}
