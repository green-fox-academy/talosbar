package com.greenfoxacademy.takeout.services;

import com.greenfoxacademy.takeout.models.Order;
import com.greenfoxacademy.takeout.repositories.OrderRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private OrderRepository orderRepository;

  @Autowired
  public OrderServiceImpl(OrderRepository orderRepository) {
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
  public boolean isTypeParamValid(String type) {
    List<String> validTypes = Arrays.asList("all", "vegetarian");
    return validTypes.contains(type);
  }

  @Override
  public boolean isStatusParamValid(String status) {
    List<String> validStatuses = Arrays.asList("ordered", "inprogress", "done");
    return validStatuses.contains(status);
  }

  @Override
  public List<Order> getOrdersByTypeAndStatus(String type, String status) {
    switch (type) {
      case "vegetarian":
        return orderRepository.findVegetarianOrdersByStatus(status);
      case "all":
        return orderRepository.findAllOrderByStatus(status);
      default:
        return null;
    }
  }

  @Override
  public void editOrder(long orderId, String status) {
    Optional<Order> optionalOrder = orderRepository.findById(orderId);
    if (optionalOrder.isPresent()) {
      Order order = optionalOrder.get();
      order.setStatus(status);
      orderRepository.save(order);
    }
  }
}

