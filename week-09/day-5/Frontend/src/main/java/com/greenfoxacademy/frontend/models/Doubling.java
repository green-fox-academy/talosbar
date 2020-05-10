package com.greenfoxacademy.frontend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doubling {

  private int received;
  private int result;

  public Doubling(int received) {
    this.received = received;
    this.result = 2 * received;
  }
}
