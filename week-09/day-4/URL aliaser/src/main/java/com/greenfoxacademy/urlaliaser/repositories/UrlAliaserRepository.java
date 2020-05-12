package com.greenfoxacademy.urlaliaser.repositories;

import com.greenfoxacademy.urlaliaser.models.Link;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlAliaserRepository extends CrudRepository<Link, Long> {

  Optional<Link> findByAlias(String alias);
}
