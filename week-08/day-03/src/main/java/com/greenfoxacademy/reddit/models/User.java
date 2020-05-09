package com.greenfoxacademy.reddit.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;

  @OneToMany(fetch = FetchType.LAZY,
      mappedBy = "creator", cascade = CascadeType.ALL)
  private List<Post> posts;

  public User() {
    this.posts = new ArrayList<>();
  }

  public User(String name) {
    this.name = name;
    this.posts = new ArrayList<>();
  }
}
