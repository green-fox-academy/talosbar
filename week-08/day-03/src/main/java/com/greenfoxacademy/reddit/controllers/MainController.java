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
    return "home";
  }

  @GetMapping("/submit")
  public String redirectToSubmit() {
    return "submit";
  }

  @PostMapping("/submit")
  public String createNewPost(User user, @ModelAttribute
      Post post) {  //hogyan irathatnam ki vele az eppen aktiv usert, es adhatnam hozza egyuttal a posthoz?
    if (userService.isActiveAnyUser()) {
      postService.addPost(post);
      postService.addUserToPost(user, post);
      return "redirect:/?noActiveUser=false&newPostAdded=true";
    }
    return "redirect:/?noActiveUser=true";
  }

  @GetMapping(value = "/register")
  public String getRegisterView(Model model,
                                @RequestParam(required = false) Boolean passwordVerificationFailed,
                                @RequestParam(required = false)
                                    Boolean usernameVerificationFailed) {
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
  public String registerNewUser(@ModelAttribute User user) {
    if (userService.isUserValid(user)) {
      userService.addUser(user);
      return "login";
    }
    if (userService.isUserInvalid(user)) {
      return "redirect:/?passwordVerificationFailed=true&usernameVerificationFailed=true";
    } else if (!userService.isPasswordValid(user)) {
      return "redirect:/?passwordVerificationFailed=true";
    } else {
      return "redirect:/?usernameVerificationFailed=true";
    }
  }

  @GetMapping(value = "/login")
  public String getLoginWithUserView(Model model,
                                     @RequestParam(required = false) Boolean invalidUserdata,
                                     @ModelAttribute User user) {
    if (invalidUserdata != null) {
      model.addAttribute("invalidUserdata", invalidUserdata);
      model.addAttribute("user", invalidUserdata ? user : new User());
    }
    return "login";
  }

  @PostMapping(value = "/login")
  public String getUserDatasFromLoginView(@ModelAttribute User user,
                                          RedirectAttributes attributes) {
    attributes.addFlashAttribute(user);
    if (!userService.validateUserData(user.getName(), user.getPassword())) {
      return "redirect:/?invalidUserdata=true";   //vmiert a nem invalid adatokra is azt reagalja, hogy invalid, es nem irja ki nekem a template-ben az uzenetet!
    } else {
      userService.setUserActive(user.getName());
      return "redirect:/?userGetActive=true";
    }
  }

  @GetMapping(value = "/logout")
  public String getBackToLogin() {
    userService.setActiveUserToInactive();
    return "redirect:/?userGetInactive=true";
  }
}


