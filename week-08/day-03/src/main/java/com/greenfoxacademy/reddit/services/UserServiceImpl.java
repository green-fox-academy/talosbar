package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUser() {
    List<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users;
  }

  @Override
  public void addUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User findUserById(long id) {
    User user = new User();
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      user = optionalUser.get();
    }
    return user;
  }

  public boolean validateUserData(String name, String password) {
    Optional<User> foundUser = userRepository.findByName(name);
    if (foundUser.isPresent()) {
      User user = foundUser.get();
      return user.getName().equals(name) && user.getPassword().equals(password);
    }
    return false;
  }

  @Override
  public boolean isUserValid(User user) {
    return isPasswordValid(user) && isNameValid(user);
  }

  @Override
  public boolean isUserInvalid(User user) {
    return !isPasswordValid(user) && !isNameValid(user);
  }

  @Override
  public boolean isPasswordValid(User user) {
    return !userRepository.findByPassword(user.getPassword()).isPresent();
  }

  @Override
  public boolean isNameValid(User user) {
    return !userRepository.findByName(user.getName()).isPresent();
  }

  @Override
  public void setUserActive(String name) {
    Optional<User> optionalUser = userRepository.findByName(name);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      user.setActive(true);
      userRepository.save(user);
    }
  }

  @Override
  public void setActiveUserToInactive() {
    User user = userRepository.getActiveUser();
    user.setActive(false);
    userRepository.save(user);
  }

  @Override
  public boolean isAnyUserActive() {
    return userRepository.getActiveUser() != null;
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.delete(findUserById(id));
  }
}
