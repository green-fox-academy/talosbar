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
  private static int amountOfGold;
  private int healthPoints;

  private boolean isACaptain;
  private static boolean hasAWoodenLeg;

  public Pirate() {
    this.name = name;
    this.amountOfGold = amountOfGold;
    this.healthPoints = 10;
  }

  public void work() {
    if (this.isACaptain) {
      amountOfGold += 10;
      healthPoints -= 5;
    } else {
      amountOfGold++;
      healthPoints--;
    }
  }

  public void party() {
    if (this.isACaptain) {
      healthPoints += 10;
    } else {
      healthPoints++;
    }
  }

  public String toString() {
    if (this.hasAWoodenLeg) {
      return "Hello, I'm Jack. I have a wooden leg and 20 golds.";
    } else {
      return "Hello, I'm Jack. I still have my real legs and 20 golds.";
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAmountOfGold(int amountOfGold) {
    this.amountOfGold = amountOfGold;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public void setACaptain(boolean ACaptain) {
    isACaptain = ACaptain;
  }

  public void setHasAWoodenLeg(boolean hasAWoodenLeg) {
    this.hasAWoodenLeg = hasAWoodenLeg;
  }

  public String getName() {
    return name;
  }

  public static int getAmountOfGold() {
    return amountOfGold;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public boolean isACaptain() {
    return isACaptain;
  }

  public static boolean hasAWoodenLeg() {
    return hasAWoodenLeg;
  }
}
