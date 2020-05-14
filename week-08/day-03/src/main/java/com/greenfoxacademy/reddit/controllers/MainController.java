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
    model.addAttribute("posts", postService.getFirstTenPosts());
    model.addAttribute("pageNumbers", postService.getNumberOfPages());
    return "home";
  }

  @GetMapping(value = {"/home/{pageNumber}"})
  public String getHomePage(Model model, @PathVariable(required = false) Integer pageNumber) {
    model.addAttribute("posts", postService.getPostsWithPageNumber(pageNumber));
    model.addAttribute("pageNumbers", postService.getNumberOfPages());
    return "home";
  }

  @GetMapping("/{option}/{id}")
  public String updateVoting(@PathVariable String option, @PathVariable long id) {
    postService.updatePostVoteField(option, id);
    return "redirect:/home";
  }

  @GetMapping("/submit")
  public String renderSubmit(Model model) {
    model.addAttribute("post", new Post());
    model.addAttribute("users", userService.getAllUser());
    return "submit";
  }

  @PostMapping("/submit")
  public String createNewPost(@ModelAttribute Post post,
                              @RequestParam("userId") Long userId) {
    if (userService.isAnyUserActive()) {
      postService.savePostWithUser(post, userId);
      return "redirect:/?noActiveUser=false&newPostAdded=true";
    }
    return "redirect:/login?noActiveUser=true";
  }

  @GetMapping(value = "/register")
  public String getRegisterView(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }

  @PostMapping(value = "/register")
  public String registerNewUser(@ModelAttribute User user) {
    if (userService.isUserValid(user)) {
      userService.addUser(user);
      return "redirect:/login";
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
                                     @RequestParam(required = false) Boolean invalidUserdata,
                                     @ModelAttribute User user) {
    model.addAttribute("invalidUserdata", invalidUserdata);
    User userToRender = invalidUserdata == null ? new User() : (invalidUserdata ? user : new User());
    model.addAttribute("user", userToRender);
    return "login";
  }

  @PostMapping(value = "/login")
  public String getUserDatasFromLoginView(@ModelAttribute User user,
                                          RedirectAttributes attributes) {
    attributes.addFlashAttribute(user);
    if (!userService.validateUserData(user.getName(), user.getPassword())) {
      return "redirect:/login?invalidUserdata=true";
    } else if (userService.validateUserData(user.getName(), user.getPassword()) &&
        userService.isAnyUserActive()) {
      return "redirect:/login?otherUserIsActive=true";
    } else {
      userService.setUserActive(user.getName());
      return "redirect:/?userGetActive=true";
    }
  }

  @GetMapping(value = "/logout")
  public String setUserInactive() {
    userService.setActiveUserToInactive();
    return "redirect:/login?userGetInactive=true";
  }
}


