package cgg.spring.ormvc.dao;

import cgg.spring.ormvc.entities.User;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  @Transactional
  public User createUser(User u) {
    sessionFactory.getCurrentSession().persist(u);
    return u;
  }
}
