package com.greenfoxacademy.urlaliaser.controllers;

import com.greenfoxacademy.urlaliaser.exceptions.ResourceNotFoundException;
import com.greenfoxacademy.urlaliaser.models.Link;
import com.greenfoxacademy.urlaliaser.services.UrlAliaserService;
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
public class UrlAliaserController {

  private UrlAliaserService urlAliaserService;

  @Autowired
  public UrlAliaserController(
      UrlAliaserService urlAliaserService) {
    this.urlAliaserService = urlAliaserService;
  }

  @GetMapping(value = {"/save-link", ""})
  public String renderMainPage(Model model,
                               @RequestParam(required = false) boolean hasError,
                               @RequestParam(required = false) boolean success,
                               @ModelAttribute Link link) {
    model.addAttribute("hasError", hasError);
    model.addAttribute("success", success);
    model.addAttribute("successLink", success ? link : new Link());
    model.addAttribute("link", hasError ? link : new Link());
    return "main";
  }

  @PostMapping("/save-link")
  public String createNewLink(@ModelAttribute Link link,
                              RedirectAttributes attributes) {
    attributes.addFlashAttribute(link);
    if (!urlAliaserService.isAliasExists(link.getAlias())) {
      urlAliaserService.addLink(link);
      return "redirect:/?success=true";
    } else {
      return "redirect:/?hasError=true";
    }
  }

  @GetMapping("/a/{alias}")
  public String goToLink(@PathVariable String alias) throws ResourceNotFoundException {
    Link storedLink = urlAliaserService.findByAlias(alias);
    if (urlAliaserService.isAliasExists(alias)) {
      storedLink.hit();
      return "redirect:" + storedLink.getUrl();
    } else {
      throw new ResourceNotFoundException();
    }
  }
}

