package com.greenfoxacademy.pixamexpress.repositories;

import com.greenfoxacademy.pixamexpress.models.Order;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

  @Query(value = "SELECT type FROM orders GROUP BY type ORDER BY count(*) DESC LIMIT 3", nativeQuery = true)
  List<String> findThreeMostCommonPizzaTypes();
}

