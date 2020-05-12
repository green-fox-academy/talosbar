package com.greenfoxacademy.urlaliaser.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Link {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String url;
  private String alias;

  @JsonIgnore
  private Integer secretCode;

  private int hitCount;

  public Link() {
  }

  public Link(long id, String url, String alias) {
    this.id = id;
    this.url = url;
    this.alias = alias;
    this.secretCode = (int) (Math.random() * 9000) + 1000;
    this.hitCount = 0;
  }

  public void hit() {
    hitCount++;
  }
}
