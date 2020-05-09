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
}
