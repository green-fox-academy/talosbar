package com.greenfoxacademy.petshelter.dtos;

import lombok.Getter;

@Getter
public class HumanDTO {

  private long humanId;
  private String humanName;

  public HumanDTO(long humanId, String humanName) {
    this.humanId = humanId;
    this.humanName = humanName;
  }
}
