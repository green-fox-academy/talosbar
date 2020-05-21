package com.greenfoxacademy.takeout.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long orderId;

  @JsonIgnore
  private String address;

  @JsonIgnore
  private String type;

  private String name;
  private String base;
  private String topping;
  private String status;

  public Order() {
    this.status = "ordered";
  }
}
