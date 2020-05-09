package com.greenfoxacademy.urlaliaser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlAliaserController {

  @GetMapping(value = {"/main", ""})
  public String main() {
    return "save-link";
  }

}

