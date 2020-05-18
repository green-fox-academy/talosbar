package com.greenfoxacademy.testexample.models;

public class Translated {
  private String received;
  private String translated;

  public Translated(String received) {
    this.received = received;
    this.translated = "I am Groot";
  }

  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }
}