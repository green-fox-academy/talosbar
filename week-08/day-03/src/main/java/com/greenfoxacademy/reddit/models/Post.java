package com.greenfoxacademy.reddit.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String url;
  private int vote;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private User user;

  public Post() {

  }

  public Post(String title, String url) {
    this.title = title;
    this.url = url;
    this.vote = 0;
  }
}
