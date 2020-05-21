package com.greenfoxacademy.pixamexpress.services;

import com.greenfoxacademy.pixamexpress.models.Order;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

  void addOrder(Order order);

  Order findOrderById(long orderId);

  List<String> getMostCommonTypes();
}
