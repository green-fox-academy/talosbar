package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

  List<Post> getAllPosts();

  List<Post> getFirstTenPostsDescByVotes();

  void addPost(Post post);

  void updateUserDataAtPost(User user, Post post);

  void savePostWithUser(Post post, long userId);

  Post findById(long id);

  void incrementVoteField(long id);

  void decreaseVoteField(long id);

  void updatePostVoteField(String option, long id);

  List<Integer> getNumberOfPages();

  List<Post> getFirstTenPosts();

  List<Post> getPostsWithPageNumber(Integer pageNumber);

  void deletePost(Long id);
}
