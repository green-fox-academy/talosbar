package com.greenfoxacademy.pixamexpress.services;

import com.greenfoxacademy.pixamexpress.models.Order;
import com.greenfoxacademy.pixamexpress.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private OrderRepository orderRepository;

  @Autowired
  public OrderServiceImpl(
      OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public void addOrder(Order order) {
    orderRepository.save(order);
  }

  @Override
  public Order findOrderById(long orderId) {
    Optional<Order> optionalOrder = orderRepository.findById(orderId);
    if (optionalOrder.isPresent()) {
      return optionalOrder.get();
    }
    return null;
  }

  @Override
  public List<String> getMostCommonTypes() {
    return orderRepository.findThreeMostCommonPizzaTypes();
  }
}
