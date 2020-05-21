package com.greenfoxacademy.takeout.controllers;

import com.greenfoxacademy.takeout.dtos.RequestDTO;
import com.greenfoxacademy.takeout.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAPIController {

  private OrderService orderService;

  @Autowired
  public OrderAPIController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/api/orders")
  public ResponseEntity<?> getOrdersDependGivenParameters(@RequestParam("type") String type,
                                                          @RequestParam("status") String status) {
    if (orderService.isTypeParamValid(type) && orderService.isStatusParamValid(status)) {
      return new ResponseEntity<>(orderService.getOrdersByTypeAndStatus(type, status),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @PatchMapping("/api/orders/{orderId}")
  public ResponseEntity<?> getOrderByGivenId(@PathVariable long orderId,
                                             @RequestBody RequestDTO requestDTO) {
    if (orderService.findOrderById(orderId) != null &&
        orderService.isStatusParamValid(requestDTO.getStatus())) {
      orderService.editOrder(orderId, requestDTO.getStatus());
      return new ResponseEntity<>(orderService.findOrderById(orderId), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}

