package com.stackroute.keepnote.dao;

import com.stackroute.keepnote.exceptions.UserAlreadyExistException;
import com.stackroute.keepnote.exceptions.UserNotFoundException;
import com.stackroute.keepnote.model.User;

public interface UserDao {
  public boolean registerUser(User user);

  public boolean updateUser(User user);

  public User getUserById(int UserId);

  public boolean validateUser(String userName, String password)
    throws UserNotFoundException;

  public boolean deleteUser(int UserId);

  public User getUserByName(String name) throws UserAlreadyExistException;
}
