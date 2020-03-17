package animal;

public class Animal {
  int hunger;
  int thirst;


  public Animal(int hunger, int thirst) {
    this.hunger = hunger;
    this.thirst = thirst;
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

}
