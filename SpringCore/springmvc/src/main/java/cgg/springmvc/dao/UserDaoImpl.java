package cgg.springmvc.dao;

import cgg.springmvc.entities.User;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  public UserDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  @Transactional
  public User saveUser(User user) {
    sessionFactory.getCurrentSession().persist(user);
    return user;
  }
}
