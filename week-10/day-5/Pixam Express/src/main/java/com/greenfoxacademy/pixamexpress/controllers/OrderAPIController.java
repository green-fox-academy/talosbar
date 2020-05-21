package com.greenfoxacademy.pixamexpress.controllers;

import com.greenfoxacademy.pixamexpress.dtos.ResponseDTO;
import com.greenfoxacademy.pixamexpress.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAPIController {

  private OrderService orderService;

  @Autowired
  public OrderAPIController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/api/orders/{id}")
  public ResponseEntity<?> getOrderInJSONById(@PathVariable long id) {
    if (orderService.findOrderById(id) != null) {
      return new ResponseEntity<>(new ResponseDTO(orderService.findOrderById(id)), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
