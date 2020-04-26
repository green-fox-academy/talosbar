package com.greenfoxacademy.programmerfox.models;

import java.util.List;

public class Fox {

  private String name;
  private String food;
  private String drink;
  private List<String> listOfTricks;
  private String gender;

  public Fox(String name, String food, String drink, List<String> listOfTricks,
             String gender) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.listOfTricks = listOfTricks;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFood() {
    return food;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public String getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }

  public List<String> getListOfTricks() {
    return listOfTricks;
  }

  public void setListOfTricks(List<String> listOfTricks) {
    this.listOfTricks = listOfTricks;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
