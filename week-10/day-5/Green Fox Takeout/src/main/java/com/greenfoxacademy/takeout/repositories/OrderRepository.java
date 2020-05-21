package com.greenfoxacademy.takeout.repositories;

import com.greenfoxacademy.takeout.models.Order;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

  @Query(value = "SELECT * FROM orders WHERE status = :status",
      nativeQuery = true)
  List<Order> findAllOrderByStatus(String status);

  @Query(value = "SELECT * FROM orders WHERE status = :status AND topping = 'smoked tofu'",
      nativeQuery = true)
  List<Order> findVegetarianOrdersByStatus(String status);
}
