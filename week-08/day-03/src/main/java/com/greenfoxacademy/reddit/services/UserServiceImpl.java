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
  public List<User> returnAllUser() {
    List<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users;
  }

  @Override
  public void addUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User findById(long id) {
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
      if (user.getName().equals(name) && user.getPassword().equals(password)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isUserValid(User user, String passwordVerification) {
    if (isPasswordValid(user, passwordVerification) && isNameValid(user)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isUserInvalid(User user, String passwordVerification) {
    if (!isPasswordValid(user, passwordVerification) && !isNameValid(user)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isPasswordValid(User user, String passwordVerification) {
    if (user.getPassword().equals(passwordVerification)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isNameValid(User user) {
    if (!userRepository.findByName(user.getName()).isPresent()) {
      return true;
    } else {
      return false;
    }
  }

  public void setUserActive(String name) {
    Optional<User> optionalUser = userRepository.findByName(name);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      user.setActive(true);
      userRepository.save(user);
    }
  }

  public void setActiveUserToInactive() {
    User user = userRepository.getActiveUser();
    user.setActive(false);
    userRepository.save(user);
  }

  @Override
  public boolean isActiveAnyUser() {
    if (userRepository.getActiveUser() == null) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public void delete(Long id) {
    userRepository.delete(findById(id));
  }
}
