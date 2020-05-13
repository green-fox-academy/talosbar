package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  List<Post> returnAllPosts();

  List<Post> returnFirstTenPostsDescByVotes();

  void addPost(Post post);

  void updateUserDataAtPost(User user, Post post);

  void addPostWithSettingUser(Post post, long userId);

  Post findById(long id);

  void incrementVoteField(long id);

  void decreaseVoteField(long id);

  void updatePostVoteField(String option, long id);

  List<Integer> getHowManyPageDoWeNeed();

  List<Post> getPostsForHomePage();

  List<Post> getPostsWithPageNumber(Integer pageNumber);

  void delete(Long id);
}
