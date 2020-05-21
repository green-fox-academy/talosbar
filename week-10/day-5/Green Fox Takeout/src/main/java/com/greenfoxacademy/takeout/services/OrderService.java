package com.greenfoxacademy.takeout.services;

import com.greenfoxacademy.takeout.models.Order;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

  void addOrder(Order order);

  Order findOrderById(long orderId);

  boolean isTypeParamValid(String type);

  boolean isStatusParamValid(String status);

  List<Order> getOrdersByTypeAndStatus(String type, String status);

  void editOrder(long orderId, String status);
}
