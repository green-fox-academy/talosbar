package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  List<User> returnAllUser();

  void addUser(User user);

  User findById(long id);

  boolean validateUserData(String name, String password);

  boolean isUserValid(User user, String passwordVerification);

  boolean isUserInvalid(User user, String passwordVerification);

  boolean isPasswordValid(User user, String passwordVerification);

  void setUserActive(String name);

  void setActiveUserToInactive();

  boolean isActiveAnyUser();

  void delete(Long id);
}
