package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.exceptions.UserAlreadyExistException;
import com.stackroute.keepnote.exceptions.UserNotFoundException;
import com.stackroute.keepnote.model.User;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  private SessionFactory sessionFactory;

  public UserDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  @Transactional
  public boolean registerUser(User user) {
    sessionFactory.getCurrentSession().persist(user);
    System.out.println("User Registered Successfully...");
    return true;
  }

  @Override
  @Transactional
  public boolean updateUser(User user) {
    User merge = sessionFactory.getCurrentSession().merge(user);
    if (merge != null) {
      return true;
    }
    return false;
  }

  @Override
  @Transactional
  public User getUserById(int UserId) {
    return sessionFactory.getCurrentSession().get(User.class, UserId);
  }

  @Override
  @Transactional
  public boolean validateUser(String userName, String password)
    throws UserNotFoundException {
    try {
      sessionFactory
        .getCurrentSession()
        .createQuery(
          "From User where userName=:name and userPassword=:pass",
          User.class
        )
        .setParameter("name", userName)
        .setParameter("pass", password)
        .getSingleResult();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new UserNotFoundException("User not Found");
    }
    return true;
  }

  @Override
  @Transactional
  public boolean deleteUser(int UserId) {
    User user = sessionFactory.getCurrentSession().get(User.class, UserId);
    if (user != null) {
      sessionFactory.getCurrentSession().remove(user);
      return true;
    }
    return false;
  }

  @Override
  @Transactional
  public User getUserByName(String name) throws UserAlreadyExistException {
    List<User> resultList = sessionFactory
      .getCurrentSession()
      .createQuery("from User where userName=:name", User.class)
      .setParameter("name", name)
      .getResultList();
    if (!resultList.isEmpty()) {
      return resultList.get(0);
    }
    return null;
  }
}
