package com.greenfoxacademy.frontend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppendA {

  private String appended;

  public AppendA(String appendable) {
    this.appended = appendable + "a";
  }
}
