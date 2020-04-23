package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.ShopItem;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebShopController {

  List<ShopItem> shopItemsList;

  public WebShopController() {
    this.shopItemsList = Arrays.asList(
        new ShopItem("Running shoes", "dress", "Nike running shoes for every day sport", 1000, 5),
        new ShopItem("Printer", "device", "Some HP printer that will print pages", 3000, 2),
        new ShopItem("Coca cola", "food", "0.5l standard coke", 25, 0),
        new ShopItem("Wokin", "food", "Chicken with fried rice and WOKIN sauce", 119, 100),
        new ShopItem("T-shirt", "dress", "Blue with a corgi", 300, 1)
    );
  }

  @GetMapping("main")
  public String getIndex() {
    return "index";
  }

  @GetMapping("")
  public String redirectToHomePage(Model model) {
    model.addAttribute("items", shopItemsList);
    return "index";
  }
}
