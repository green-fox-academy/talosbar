package com.greenfoxacademy.frontend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WelcomeMessage {

  private String welcomeMessage;
  @JsonIgnore
  private String name;
  @JsonIgnore
  private String title;

  public WelcomeMessage(String name, String title) {
    this.name = name;
    this.title = title;
    this.welcomeMessage = "Oh, hi there " + this.name + ", my dear " + this.title + "!";
  }
}
