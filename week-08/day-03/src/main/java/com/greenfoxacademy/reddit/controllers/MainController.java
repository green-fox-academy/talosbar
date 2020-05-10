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
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping(value = {"/", "/home"})
  public String listFirstTenPosts(Model model) {
    model.addAttribute("posts", postService.getPostsForHomePage());
    model.addAttribute("pageNumbers", postService.getHowManyPageDoWeNeed());
    return "home";
  }

  @GetMapping(value = {"/home/{pageNumber}"})
  public String getHomePage(Model model, @PathVariable(required = false) Integer pageNumber) {
    model.addAttribute("posts", postService.getPostsWithPageNumber(pageNumber));
    model.addAttribute("pageNumbers", postService.getHowManyPageDoWeNeed());
    return "home";
  }

  @GetMapping("/register")
  public String redirectToRegister() {
    return "register";
  }

  @PostMapping("/register")
  public String createNewUser(@ModelAttribute("user") User user) {
    userService.addUser(user);
    return "login";
  }

  @GetMapping("/submit")
  public String redirectToSubmit() {
    return "submit";
  }

  @PostMapping("/submit")
  public String createNewPost(@ModelAttribute("post") Post post) {
    postService.addPost(post);
    return "redirect:/home";
  }

  @GetMapping("/{option}/{id}")
  public String manageVoting(@PathVariable String option, @PathVariable long id) {
    postService.updatePostVoteField(option, id);
    return "redirect:/home";
  }

  @GetMapping(value = "/login")
  public String getLoginWithUserView(Model model,
                                     @RequestParam(required = false) Boolean invalidUserdata) {
    if (invalidUserdata != null) {
      model.addAttribute("invalidUserdata", invalidUserdata);
    }
    return "login";
  }

  @PostMapping(value = "/login")
  public String getUserDatasFromLoginView(String username, String password, Model model) {
    if (userService.validateUserData(username, password)) {
      userService.setUserActive(username);
      return "redirect:/home";
    }
    return "redirect:/login?invalidUserdata=true";
  }

  @GetMapping(value = "/logout")
  public String getBackToLogin() {
    userService.setActiveUserToInactive();
    return "redirect:/home";
  }
}


