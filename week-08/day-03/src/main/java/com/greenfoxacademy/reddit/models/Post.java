package com.greenfoxacademy.reddit.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

  @Temporal(TemporalType.DATE)
  private Date createdAt;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private User creator;

  public Post() {

  }

  public Post(String title, String url) {
    this.title = title;
    this.url = url;
    this.vote = 0;
    this.createdAt = new Date();
  }
}
