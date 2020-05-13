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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
  public String redirectToSubmit(Model model) {
    model.addAttribute("users", userService.returnAllUser());
    return "submit";
  }

  @PostMapping("/submit")
  public String createNewPost(@ModelAttribute Post post,
                              @RequestParam("userId") Long userId) {
    if (userService.isActiveAnyUser()) {
      postService.addPostWithSettingUser(post, userId);
      return "redirect:/?noActiveUser=false&newPostAdded=true";
    }
    return "redirect:/login?noActiveUser=true";
  }

  @GetMapping(value = "/register")
  public String getRegisterView() {
    return "register";
  }

  @PostMapping(value = "/register")
  public String registerNewUser(@ModelAttribute User user) {
    if (userService.isUserValid(user)) {
      userService.addUser(user);
      return "login";
    }
    if (userService.isUserInvalid(user)) {
      return "redirect:/register?passwordVerificationFailed=true&usernameVerificationFailed=true";
    } else if (!userService.isPasswordValid(user)) {
      return "redirect:/register?passwordVerificationFailed=true";
    } else {
      return "redirect:/register?usernameVerificationFailed=true";
    }
  }

  @GetMapping(value = "/login")
  public String getLoginWithUserView(Model model,
                                     @RequestParam(required = false) Boolean invalidUserdata) {
    model.addAttribute("invalidUserdata", invalidUserdata);
    return "login";
  }

  @PostMapping(value = "/login")
  public String getUserDatasFromLoginView(@ModelAttribute User user,
                                          RedirectAttributes attributes) {
    attributes.addFlashAttribute(user);
    if (!userService.validateUserData(user.getName(), user.getPassword())) {
      return "redirect:/login?invalidUserdata=true";
    } else {
      userService.setUserActive(user.getName());
      return "redirect:/?userGetActive=true";
    }
  }

  @GetMapping(value = "/logout")
  public String getBackToLogin() {
    userService.setActiveUserToInactive();
    return "redirect:/login?userGetInactive=true";
  }
}


