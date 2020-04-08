//It must have ownerName and stores it's health's state isHealthy (true or false) and a healCost.
//It must have a method named heal(), that sets the isHealthy field's status to true
//It must have a method named isAdoptable that returns a boolean value whether it can be adopted or not
// - an animal can be adopted if it is healthy
//It must have a method named toString() that represents the Animal in the following format:

package AnimalProtection;

public abstract class Animal {

  protected String name;
  protected int healCost;
  protected String ownerName;
  protected boolean isHealthy;

  public Animal(String name, boolean isHealthy) {
    this.name = name;
    this.ownerName = null;
    this.isHealthy = isHealthy;
  }

  public void heal() {
    isHealthy = true;
  }

  public boolean isAdoptable() {
    return this.isHealthy;
  }

  public String toString() {
    return name + " is " + isHealthy + healCost + "€ is the heal cost of this animal, and it is " + isAdoptable() + ".";
  }

  public int getHealCost() {
    return healCost;
  }

  public boolean isHealthy() {
    return isHealthy;
  }

  public String getName() {
    return name;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }
}
