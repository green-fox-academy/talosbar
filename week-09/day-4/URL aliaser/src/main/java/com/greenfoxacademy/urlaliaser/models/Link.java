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
  private int hitCount;

  @JsonIgnore
  private String secretCode;

  public Link() {
  }

  public void hit() {
    hitCount++;
  }
}
