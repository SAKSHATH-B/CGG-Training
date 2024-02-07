package com.stackroute.keepnote.service;

import com.stackroute.keepnote.dao.UserDao;
import com.stackroute.keepnote.exceptions.UserAlreadyExistException;
import com.stackroute.keepnote.exceptions.UserNotFoundException;
import com.stackroute.keepnote.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public boolean registerUser(User user) throws UserAlreadyExistException {
    User userByName = userDao.getUserByName(user.getUserName());
    if (userByName != null) {
      throw new UserAlreadyExistException("User already exists...");
    }
    userDao.registerUser(user);
    System.out.println("New User Created");
    return true;
  }

  @Override
  public User updateUser(User user, int id) throws UserNotFoundException {
    User userById = userDao.getUserById(id);
    if (userById != null) {
      userDao.updateUser(user);
    } else {
      throw new UserNotFoundException("User not Found");
    }
    return user;
  }

  @Override
  public boolean deleteUser(int UserId) {
    return userDao.deleteUser(UserId);
  }

  @Override
  public boolean validateUser(String userName, String password)
    throws UserNotFoundException {
    return userDao.validateUser(userName, password);
  }

  @Override
  public User getUserById(int userId) throws UserNotFoundException {
    User userById = userDao.getUserById(userId);
    if (userById != null) {
      return userById;
    } else {
      throw new UserNotFoundException("User not Found");
    }
  }

  @Override
  public User getUserByName(String name) throws UserAlreadyExistException {
    return userDao.getUserByName(name);
  }
}
