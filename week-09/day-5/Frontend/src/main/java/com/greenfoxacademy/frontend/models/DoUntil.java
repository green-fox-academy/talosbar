package com.greenfoxacademy.frontend.models;

import java.util.stream.IntStream;

public class DoUntil {
  private int until;
  private int result;

  public int getUntil() {
    return until;
  }

  public void setUntil(int until) {
    this.until = until;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  public void setResultByAction(String action) {
    if (until > 0) {
      if (action.equals("sum")) {
        result = IntStream.rangeClosed(1, until).sum();
      }
      if (action.equals("factor")) {
        result = IntStream.rangeClosed(1, until).reduce(1, (x, y) -> x * y);
      }
    }
  }
}