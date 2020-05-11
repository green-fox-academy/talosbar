package com.greenfoxacademy.reddit;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import com.greenfoxacademy.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication implements CommandLineRunner {
  PostRepository postRepository;
  UserRepository userRepository;

  public RedditApplication(PostRepository postRepository,
                           UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(RedditApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    postRepository
        .save(new Post("Hibernate", "https://en.wikipedia.org/wiki/Hibernate_(framework)"));
    postRepository.save(new Post("JPA", "https://en.wikipedia.org/wiki/Java_Persistence_API"));
    postRepository.save(new Post("Query methods",
        "https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods"));

    userRepository.save(new User("author", "124"));
  }
}
