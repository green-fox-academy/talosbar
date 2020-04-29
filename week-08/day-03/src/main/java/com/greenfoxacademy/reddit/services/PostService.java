package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  List<Post> returnAllPosts();
  void addPost(Post post);
  void addUserToPost(User user, Post post);
  Post findById(long id);
  List<Post> queries();
}
