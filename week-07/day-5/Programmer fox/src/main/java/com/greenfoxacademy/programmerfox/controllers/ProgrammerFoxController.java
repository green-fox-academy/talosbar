package com.greenfoxacademy.programmerfox.controllers;

import com.greenfoxacademy.programmerfox.models.Fox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProgrammerFoxController {

  List<Fox> foxList;

  public ProgrammerFoxController() {
    this.foxList = Arrays.asList(
        new Fox("Mr. Lemonade", "chips", "water", Arrays.asList("jumping", "swimming"), "male"),
        new Fox("Mr. Green", "salad", "water", new ArrayList<>(), "male"),
        new Fox("Ms. Mushroom", "rabbit", "wine", Arrays.asList("dancing", "singing"), "female")
    );
  }

  @GetMapping("")
  public String redirectToHomePage() {
    return "index";
  }

  @GetMapping("/login")
  public String getLogin() {
    return "login";
  }

  @PostMapping("/login")
  public String searchByInput(String loginInput, Model model) {
    Optional<Fox> foxOption = foxList.stream()
        .filter(fox -> fox.getName().toLowerCase().equals(loginInput.toLowerCase()))
        .findFirst();

    if (foxOption.isPresent()) {
      Fox fox = foxOption.get();
      model.addAttribute("name", fox.getName());
      model.addAttribute("food", fox.getFood());
      model.addAttribute("drink", fox.getDrink());
      model.addAttribute("listOfTricks", fox.getListOfTricks());
      model.addAttribute("gender", fox.getGender());
      model.addAttribute("isFox", true);
    } else {
      model.addAttribute("isFox", false);
    }

    return "index";
  }
}
