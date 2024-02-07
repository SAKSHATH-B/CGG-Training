package cgg.blogapp.blogapp.services;

import cgg.blogapp.blogapp.payloads.UserDTO;
import java.util.List;

public interface UserService {
  public UserDTO createUser(UserDTO userDTO);

  public UserDTO updateUser(int id, UserDTO userDTO);

  public UserDTO getUserById(int id);

  public List<UserDTO> getAllUsers();

  public void deleteUserById(int id);
}
