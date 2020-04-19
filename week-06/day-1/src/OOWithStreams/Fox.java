//Create a Fox class with 3 properties:name, color and age Fill a list with at least 5 foxes and:

package OOWithStreams;

public class Fox {

  private String name;
  private String color;
  private int age;

  public Fox(String name, String color, int age) {
    this.name = name;
    this.color = color;
    this.age = age;
  }

  public String getColor() {
    return color;
  }

  public int getAge() {
    return age;
  }

  public String toString() {
    return "The name of the fox is: " + this.name + ", it's color is: " + this.color + ", it's age is: " + this.age + ".";
  }
}
