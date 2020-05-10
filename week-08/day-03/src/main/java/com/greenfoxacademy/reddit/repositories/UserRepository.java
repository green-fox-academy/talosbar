package com.greenfoxacademy.reddit.repositories;

import com.greenfoxacademy.reddit.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  @Query(value="SELECT * FROM User WHERE name = :name LIMIT 1", nativeQuery = true)
  User getUserByName(String name);

  @Query("SELECT u FROM User u WHERE u.active  = true")
  User getActiveUser();
}
