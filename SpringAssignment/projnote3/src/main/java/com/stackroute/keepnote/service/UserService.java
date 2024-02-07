package com.stackroute.keepnote.service;

import com.stackroute.keepnote.exceptions.UserAlreadyExistException;
import com.stackroute.keepnote.exceptions.UserNotFoundException;
import com.stackroute.keepnote.model.User;

public interface UserService {
  public boolean registerUser(User user) throws UserAlreadyExistException;

  public User updateUser(User user, int id) throws UserNotFoundException;

  public boolean deleteUser(int UserId);

  public boolean validateUser(String userName, String password)
    throws UserNotFoundException;

  public User getUserById(int userId) throws UserNotFoundException;

  public User getUserByName(String name) throws UserAlreadyExistException;
}
