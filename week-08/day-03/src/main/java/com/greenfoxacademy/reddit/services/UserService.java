package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  List<User> getAllUser();

  void addUser(User user);

  User findUserById(long id);

  boolean validateUserData(String name, String password);

  boolean isUserValid(User user);

  boolean isUserInvalid(User user);

  boolean isNameValid(User user);

  boolean isPasswordValid(User user);

  void setUserActive(String name);

  void setActiveUserToInactive();

  boolean isAnyUserActive();

  void deleteUser(Long id);
}
