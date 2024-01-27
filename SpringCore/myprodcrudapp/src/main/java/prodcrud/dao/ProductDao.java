package prodcrud.dao;

import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prodcrud.model.Product;

@Component
public class ProductDao {

  @Autowired
  private SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public void createProduct(Product product) {
    sessionFactory.getCurrentSession().saveOrUpdate(product);
  }

  @Transactional
  public List<Product> getAllProducts() {
    String hql = "From Product";
    List<Product> list = sessionFactory
      .getCurrentSession()
      .createQuery(hql, Product.class)
      .list();
    return list;
  }

  @Transactional
  public void deleteProduct(int pid) {
    Product p = sessionFactory.getCurrentSession().load(Product.class, pid);
    sessionFactory.getCurrentSession().delete(p);
  }

  @Transactional
  public Product getProduct(int pid) {
    return sessionFactory.getCurrentSession().get(Product.class, pid);
  }
}
