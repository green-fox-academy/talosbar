package com.greenfoxacademy.urlaliaser.controllers;

import com.greenfoxacademy.urlaliaser.models.Link;
import com.greenfoxacademy.urlaliaser.services.UrlAliaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UrlAliaserController {

  private UrlAliaserService urlAliaserService;

  @Autowired
  public UrlAliaserController(
      UrlAliaserService urlAliaserService) {
    this.urlAliaserService = urlAliaserService;
  }

  @GetMapping(value = {"/save-link", ""})
  public String main() {
    return "save-link";
  }

  @PostMapping("/save-link")
  public String createNewLink(@ModelAttribute("link") Link link, Model model,
                              @RequestParam(required = false) Boolean aliasExistsAlready) {
    if (!urlAliaserService.isAliasExists(link)) {
      urlAliaserService.addLink(link);
      model.addAttribute("aliasExistsAlready", aliasExistsAlready);
      model.addAttribute("links", urlAliaserService.returnAllLinks());
      return "save-link";
    } else {
      model.addAttribute("aliasExistsAlready", aliasExistsAlready);
      return "save-link";
    }
  }
}

