package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.repositories.PostRepository;
import com.greenfoxacademy.reddit.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
  PostRepository postRepository;
  UserRepository userRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository,
                         UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<Post> returnAllPosts() {
    List<Post> posts = new ArrayList<>();
    postRepository.findAll().forEach(posts::add);
    return posts;
  }

  @Override
  public void addPost(Post post) {
    postRepository.save(post);
  }

  @Override
  public void addUserToPost(User user, Post post) {
    post.setUser(user);
    List<Post> userPosts = user.getPosts();
    userPosts.add(post);
    user.setPosts(userPosts);
    userRepository.save(user);
    postRepository.save(post);
  }

  @Override
  public Post findById(long id) {
    Post post = new Post();
    Optional<Post> postOptional = postRepository.findById(id);
    if (postOptional.isPresent()) {
      post = postOptional.get();
    }
    return post;
  }

  @Override
  public List<Post> queries() {
    List<Post> posts = new ArrayList<>();
    posts.addAll(postRepository.findAllById());
    return posts;
  }
}
