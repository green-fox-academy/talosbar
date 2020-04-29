package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.service.WebShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebShopController {

  private WebShopService webShopService;

  @Autowired
  public WebShopController(WebShopService webShopService) {
    this.webShopService = webShopService;
  }

  @GetMapping("")
  public String redirectToHomePage(Model model) {
    model.addAttribute("items", webShopService.getShopItemsList());
    return "index";
  }

  @GetMapping("/webshop")
  @ResponseBody
  public String greeting() {
    return "Hello World";
  }

  @GetMapping("/only-available")
  public String getOnlyAvailableItems(Model model) {
    model.addAttribute("items", webShopService.getOnlyAvailableItems());
    return "index";
  }

  @GetMapping("/cheapest-first")
  public String getCheapestItemFirst(Model model) {
    model.addAttribute("items", webShopService.getShopItemsListOrderedByPrice());
    return "index";
  }

  @GetMapping("/contains-nike")
  public String getItemsWhichDescriptionContainsNike(Model model) {
    model.addAttribute("items", webShopService.getItemsWhichDescriptionContainsNike());
    return "index";
  }

  @GetMapping("/average-stock")
  public String getAverageStock(Model model) {
    model.addAttribute("averageOfStock", webShopService.getAverageStock());
    return "averageStock";
  }

  @GetMapping("/most-expensive-available")
  public String getMostExpensiveItem(Model model) {
    model.addAttribute("items", webShopService.getMostExpensiveItem());
    return "index";
  }

  @PostMapping("/search")
  public String searchByInput(String searchInput, Model model) {
    model.addAttribute("items", webShopService.getSearchedItems(searchInput));
    return "index";
  }

}
