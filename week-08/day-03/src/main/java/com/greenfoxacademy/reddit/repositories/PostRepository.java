package com.greenfoxacademy.reddit.repositories;

import com.greenfoxacademy.reddit.models.Post;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

  @Query(value = "SELECT * FROM post ORDER BY vote DESC LIMIT 10", nativeQuery = true)
  List<Post> getFirstTenPostsByDescendingByVotes();
}
