package cgg.springmvc.services;

import cgg.springmvc.dao.UserDao;
import cgg.springmvc.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  @Transactional
  public User createUser(User user) {
    return userDao.saveUser(user);
  }
}
