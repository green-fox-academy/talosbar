package animal;

public class Animal {

  private int hunger;
  private int thirst;

  public Animal() {
    hunger = 50;
    thirst = 50;
  }

  public void eat() {
    hunger--;
  }

  public void drink() {
    thirst--;
  }

  public void play() {
    hunger++;
    thirst++;
  }

  public String toString() {
    return "I have " + thirst + "thirst points and " + hunger + " hunger points";
  }
}
