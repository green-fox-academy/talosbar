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
    Optional<User> foundUser = Optional.ofNullable(userRepository.getUserByName(name));
    if (foundUser.isPresent()) {
      User user = foundUser.get();
      if (user.getName().equals(name) && user.getPassword().equals(password)) {
        return false;
      }
    }
    return true;
  }

  public void setUserActive(String name) {
    Optional<User> optionalUser = Optional.ofNullable(userRepository.getUserByName(name));
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
}
