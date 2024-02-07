package cgg.blogapp.blogapp.services.impl;

import cgg.blogapp.blogapp.dao.UserRepository;
import cgg.blogapp.blogapp.entities.User;
import cgg.blogapp.blogapp.exceptions.ResourceNotFoundException;
import cgg.blogapp.blogapp.payloads.UserDTO;
import cgg.blogapp.blogapp.services.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public UserDTO createUser(UserDTO userDTO) {
    User user = userDtoToUser(userDTO);
    User savedUser = userRepository.save(user);
    return userToUserDto(savedUser);
  }

  @Override
  public UserDTO updateUser(int id, UserDTO userDTO) {
    User existingUser = userRepository
      .findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
    existingUser.setName(userDTO.getName());
    existingUser.setEmail(userDTO.getEmail());
    existingUser.setPassword(userDTO.getPassword());
    existingUser.setAbout(userDTO.getAbout());
    User updatedUser = userRepository.save(existingUser);
    return userToUserDto(updatedUser);
  }

  @Override
  public UserDTO getUserById(int id) {
    User existingUser = userRepository
      .findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
    return userToUserDto(existingUser);
  }

  @Override
  public List<UserDTO> getAllUsers() {
    List<User> allUsers = userRepository.findAll();
    List<UserDTO> userDTOs = allUsers
      .stream()
      .map(user -> userToUserDto(user))
      .collect(Collectors.toList());
    return userDTOs;
  }

  @Override
  public void deleteUserById(int id) {
    userRepository.deleteById(id);
  }

  public User userDtoToUser(UserDTO userDTO) {
    // User user = new User();
    // user.setUserId(userDTO.getUserId());
    // user.setName(userDTO.getName());
    // user.setEmail(userDTO.getEmail());
    // user.setPassword(userDTO.getPassword());
    // user.setAbout(userDTO.getAbout());
    // return user;
    return modelMapper.map(userDTO, User.class);
  }

  public UserDTO userToUserDto(User user) {
    // UserDTO userDTO = new UserDTO();
    // userDTO.setUserId(user.getUserId());
    // userDTO.setName(user.getName());
    // userDTO.setEmail(user.getEmail());
    // userDTO.setPassword(user.getPassword());
    // userDTO.setAbout(user.getAbout());
    // return userDTO;
    return modelMapper.map(user, UserDTO.class);
  }
}
