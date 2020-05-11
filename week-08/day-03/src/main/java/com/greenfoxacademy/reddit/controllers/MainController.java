package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.models.Error;
import com.greenfoxacademy.reddit.services.PostService;
import com.greenfoxacademy.reddit.services.PostServiceImpl;
import com.greenfoxacademy.reddit.services.UserService;
import com.greenfoxacademy.reddit.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

  @GetMapping("/{option}/{id}")
  public String manageVoting(@PathVariable String option, @PathVariable long id) {
    postService.updatePostVoteField(option, id);
    return "redirect:/home";
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

  @GetMapping(value = "/register")
  public String getRegisterView(Model model,
                                @RequestParam(required = false) Boolean passwordVerificationFailed,
                                @RequestParam(required = false) Boolean usernameVerificationFailed) {
    model.addAttribute("newUser", new User());
    if (passwordVerificationFailed != null) {
      model.addAttribute("passwordVerificationFailed", passwordVerificationFailed);
    }
    if (usernameVerificationFailed != null) {
      model.addAttribute("usernameVerificationFailed", usernameVerificationFailed);
    }
    return "register";
  }

  @PostMapping(value = "/register")
  public String registerNewUser(@ModelAttribute User user, String passwordVerification) {
    if (userService.isUserValid(user, passwordVerification)) {
      userService.addUser(user);
      return "redirect:/login";
    }
    if (userService.isUserInvalid(user, passwordVerification)) {
      return "redirect:/register?passwordVerificationFailed=true&usernameVerificationFailed=true";
    } else if (!userService.isPasswordValid(user, passwordVerification)) {
      return "redirect:/register?passwordVerificationFailed=true";
    } else {
      return "redirect:/register?usernameVerificationFailed=true";
    }
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
      return "redirect:/list";
    }
    return "redirect:/login?invalidUserdata=true";
  }

  @GetMapping(value = "/logout")
  public String getBackToLogin() {
    userService.setActiveUserToInactive();
    return "redirect:/login";
  }

  @ResponseBody
  @DeleteMapping("/delete/post/{id}")
  public ResponseEntity<?> deletePost(@PathVariable Long id){
    if (postService.findById(id) != null){
      postService.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } return new ResponseEntity<>("No post at the given index" + id, HttpStatus.NOT_FOUND);
  }

  @ResponseBody
  @DeleteMapping("/delete/user/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id){
    if (userService.findById(id) != null){
      userService.delete(id);
      return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    } return new ResponseEntity<>("No user at the given index " + id, HttpStatus.NOT_FOUND);
  }
}


