package com.greenfoxacademy.takeout.controllers;

import com.greenfoxacademy.takeout.models.Order;
import com.greenfoxacademy.takeout.services.OrderService;
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
    return "redirect:/order/" + order.getOrderId();
  }

  @GetMapping("/order/{orderId}")
  public String getOrderById(Model model, @PathVariable long orderId) {
    if (orderService.findOrderById(orderId) != null) {
      model.addAttribute("order", orderService.findOrderById(orderId));
      return "details";
    }
    return "error";
  }
}
