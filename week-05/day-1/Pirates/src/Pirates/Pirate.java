package Pirates;

//Write a program which can store pirates in a ship.
//    A pirate has a name, an amount of gold and health points, the default value of which is 10.
//    A pirate might be a captain and may have a wooden leg.
//    You must create the following methods:
//    if a pirate is a captain:
//     work() which increases the amount of gold possessed by that pirate by 10 and decrease the HP by 5.
//     party() which increases the HP by 10.
//    if the pirate is not a captain:
//      work() which increases the amount of gold by 1 and decreases the HP by 1.
//      party() which increases the HP by 1.
//    toString() method:
//    if the pirate has a wooden leg, then the string that is returned by the function must look like this:
//    Hello, I'm Jack. I have a wooden leg and 20 golds.
//    If not:
//    Hello, I'm Jack. I still have my real legs and 20 golds.

public class Pirate {

  private String name;
  private int amountOfGold;
  private int healthPoints;
  private boolean isACaptain;
  private boolean hasAWoodenLeg;

  public Pirate(String name, int amountOfGold) {
    this.name = name;
    this.amountOfGold = amountOfGold;
    this.healthPoints = 10;
    this.isACaptain = false;
    this.hasAWoodenLeg = false;
  }

  public Pirate(String name, int amountOfGold, boolean isACaptain, boolean hasAWoodenLeg) {
    this.name = name;
    this.amountOfGold = amountOfGold;
    this.healthPoints = 10;
    this.isACaptain = isACaptain;
    this.hasAWoodenLeg = hasAWoodenLeg;
  }

  public void work() {
    if (isACaptain) {
      amountOfGold += 10;
      healthPoints -= 5;
    } else {
      amountOfGold++;
      healthPoints--;
    }
  }

  public void party() {
    if (isACaptain) {
      healthPoints += 10;
    } else {
      healthPoints++;
    }
  }

  public String toString() {
    if (hasAWoodenLeg) {
      return "Hello, I'm" + this.name + ". I have a wooden leg and" + this.amountOfGold + " golds.";
    } else {
      return "Hello, I'm" + this.name + ". I still have my real legs and" + this.amountOfGold + " golds.";
    }
  }

  public boolean isPoor() {
    return hasAWoodenLeg && amountOfGold < 15;
  }

  public String getName() {
    return name;
  }

  public int getAmountOfGold() {
    return amountOfGold;
  }

  public boolean isACaptain() {
    return this.isACaptain;
  }

  public int getHealthPoints() {
    return healthPoints;
  }
}
