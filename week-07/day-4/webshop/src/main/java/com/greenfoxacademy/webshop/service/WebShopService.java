package com.greenfoxacademy.webshop.service;

import com.greenfoxacademy.webshop.models.ShopItem;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class WebShopService {

  List<ShopItem> shopItemsList;

  public WebShopService() {
    shopItemsList = Arrays.asList(
        new ShopItem("Running shoes", "dress", "Nike running shoes for every day sport", 1000, 5),
        new ShopItem("Printer", "device", "Some HP printer that will print pages", 3000, 2),
        new ShopItem("Coca cola", "food", "0.5l standard coke", 25, 0),
        new ShopItem("Wokin", "food", "Chicken with fried rice and WOKIN sauce", 119, 100),
        new ShopItem("T-shirt", "dress", "Blue with a corgi", 300, 1)
    );
  }

  public List<ShopItem> getShopItemsList() {
    return shopItemsList;
  }

  public List<ShopItem> getOnlyAvailableItems() {
    return shopItemsList.stream()
        .filter(item -> item.getQuantityOfStock() > 0)
        .collect(Collectors.toList());
  }

  public List<ShopItem> getShopItemsListOrderedByPrice() {
    return shopItemsList.stream()
        .sorted(Comparator.comparingDouble(ShopItem::getPrice))
        .collect(Collectors.toList());
  }

  public List<ShopItem> getItemsWhichDescriptionContainsNike() {
    return shopItemsList.stream()
        .filter(item -> item.getName().toLowerCase().contains("nike") ||
            item.getDescription().toLowerCase().contains("nike"))
        .collect(Collectors.toList());
  }

  public double getAverageStock() {
    return shopItemsList.stream()
        .mapToDouble(ShopItem::getQuantityOfStock)
        .average()
        .orElse(0);
  }

  public List<ShopItem> getMostExpensiveItem() {
    return shopItemsList.stream()
        .sorted(Comparator.comparingDouble(ShopItem::getPrice).reversed())
        .limit(1)
        .collect(Collectors.toList());
  }

  public List<ShopItem> getSearchedItems(String searchInput) {
    return shopItemsList.stream()
        .filter(item -> item.getName().toLowerCase().contains(searchInput.toLowerCase()) ||
            item.getDescription().toLowerCase().contains(searchInput.toLowerCase()))
        .collect(Collectors.toList());
  }
}
