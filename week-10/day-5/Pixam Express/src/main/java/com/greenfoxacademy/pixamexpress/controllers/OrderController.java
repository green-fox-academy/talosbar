package com.greenfoxacademy.pixamexpress.controllers;

import com.greenfoxacademy.pixamexpress.models.Order;
import com.greenfoxacademy.pixamexpress.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

  private OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping(value = {"/", "/order"})
  public String getMainPage() {
    return "order";
  }

  @PostMapping("/order")
  public String getSummarizedOrder(@ModelAttribute Order order) {
    orderService.addOrder(order);
    return "redirect:/order/" + order.getId();
  }

  @GetMapping("/order/{id}")
  public String getOrderById(Model model, @PathVariable long id) {
    if (orderService.findOrderById(id) != null) {
      model.addAttribute("order", orderService.findOrderById(id));
      return "details";
    }
    return "error";
  }

  @GetMapping("/statistics")
  public String getStatistics(Model model) {
    model.addAttribute("favorites", orderService.getMostCommonTypes());
    return "statistics";
  }
}
