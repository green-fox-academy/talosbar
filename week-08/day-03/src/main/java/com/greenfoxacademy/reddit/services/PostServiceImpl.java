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
  public List<Post> returnFirstTenPostsDescByVotes() {
    return postRepository.getFirstTenPostsByDescendingByVotes();
  }

  @Override
  public void addPost(Post post) {
    postRepository.save(post);
  }

  @Override
  public void addUserToPost(User user, Post post) {
    post.setCreator(user);
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
  public void incrementVoteField(long id) {
    Optional<Post> optionalPost = postRepository.findById(id);
    if (optionalPost.isPresent()) {
      Post post = optionalPost.get();
      post.setVote(post.getVote() + 1);
      postRepository.save(post);
    }
  }

  @Override
  public void decreaseVoteField(long id) {
    Optional<Post> optionalPost = postRepository.findById(id);
    if (optionalPost.isPresent()) {
      Post post = optionalPost.get();
      post.setVote(post.getVote() - 1);
      postRepository.save(post);
    }
  }

  @Override
  public void updatePostVoteField(String option, long id) {
    switch (option) {
      case "+":
        incrementVoteField(id);
        break;
      case "-":
        decreaseVoteField(id);
        break;
    }
  }

  @Override
  public List<Integer> getHowManyPageDoWeNeed() {
    List<Integer> pageNumbers = new ArrayList<>();
    Integer sizeOfPosts = postRepository.getAllPostsWithDescendingOrder().size();
    Integer pageNumber = 1;
    pageNumbers.add(pageNumber);
    for (int i = 1; i <= sizeOfPosts; i++) {
      if (i % 10 == 0) {
        pageNumber++;
        pageNumbers.add(pageNumber);
      }
    }
    return pageNumbers;
  }

  @Override
  public List<Post> getPostsForHomePage() {
    return postRepository.getFirstTenPostsByDescendingByVotes();
  }

  @Override
  public List<Post> getPostsWithPageNumber(Integer pageNumber) {
    if (pageNumber == 1) {
      return postRepository.getFirstTenPostsByDescendingByVotes();
    } else {
      return postRepository.getAllPostsWithDescendingOrderWithLimitTenAndSelectedOffset((pageNumber - 1) * 10);
    }
  }
}
