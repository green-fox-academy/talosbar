package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.services.PostService;
import com.greenfoxacademy.reddit.services.PostServiceImpl;
import com.greenfoxacademy.reddit.services.UserService;
import com.greenfoxacademy.reddit.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainAPIController {

  private PostService postService;
  private UserService userService;

  @Autowired
  public MainAPIController(PostServiceImpl postService,
                           UserServiceImpl userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @DeleteMapping("/delete/post/{id}")
  public ResponseEntity<?> deletePost(@PathVariable Long id) {
    if (postService.findById(id) != null) {
      postService.deletePost(id);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>("No post at the given index" + id, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/delete/user/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id) {
    if (userService.findUserById(id) != null) {
      userService.deleteUser(id);
      return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }
    return new ResponseEntity<>("No post at the given index" + id, HttpStatus.NOT_FOUND);
  }
}
