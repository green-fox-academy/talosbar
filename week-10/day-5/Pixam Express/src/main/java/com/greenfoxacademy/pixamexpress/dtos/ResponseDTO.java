package com.greenfoxacademy.pixamexpress.dtos;

import com.greenfoxacademy.pixamexpress.models.Order;
import lombok.Getter;

@Getter
public class ResponseDTO {

  private long id;
  private String name;
  private String address;
  private String type;

  public ResponseDTO(Order order) {
    this.id = order.getId();
    this.name = order.getName();
    this.address = order.getAddress();
    this.type = order.getType().toLowerCase();
  }
}
