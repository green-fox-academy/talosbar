package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  List<User> returnAllUser();
  void addUser(User user);
  User findById(long id);
}
