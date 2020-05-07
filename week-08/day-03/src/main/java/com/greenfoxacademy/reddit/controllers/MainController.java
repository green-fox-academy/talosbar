package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.services.PostService;
import com.greenfoxacademy.reddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  PostService postService;
  UserService userService;

  @Autowired
  public MainController(PostService postService,
                        UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping(value = "")
  public String redirectToLoginPage() {
    return "login";
  }
}
