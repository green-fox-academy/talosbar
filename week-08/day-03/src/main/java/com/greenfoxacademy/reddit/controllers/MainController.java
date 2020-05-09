package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.services.PostService;
import com.greenfoxacademy.reddit.services.PostServiceImpl;
import com.greenfoxacademy.reddit.services.UserService;
import com.greenfoxacademy.reddit.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  private PostService postService;
  private UserService userService;

  @Autowired
  public MainController(PostServiceImpl postService,
                        UserServiceImpl userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping(value = {"/", "/list"})
  public String listFirstTenPosts(Model model) {
    model.addAttribute("posts", postService.returnFirstTenPostsDescByVotes());
    return "list";
  }

  @GetMapping("/register")
  public String redirectToRegister() {
    return "register";
  }

  @PostMapping("/register")
  public String createNewUser(@ModelAttribute("user") User user) {
    userService.addUser(user);
    return "list";
  }

  @GetMapping("/submit")
  public String redirectToSubmit() {
    return "submit";
  }

  @PostMapping("/submit")
  public String createNewPost(@ModelAttribute("post") Post post) {
    postService.addPost(post);
    return "redirect:/list";
  }

  @GetMapping("/{option}/{id}")
  public String manageVoting(@PathVariable String option, @PathVariable long id) {
    postService.updatePostVoteField(option, id);
    return "redirect:/list";
  }
}


