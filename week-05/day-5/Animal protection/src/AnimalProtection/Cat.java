//The animal's name is the same as the class name by default, but it can be set trough constructor as well
//The healing cost should be a random number between 0 and 6

package AnimalProtection;

import java.util.Random;

public class Cat extends Animal {

  Random random = new Random();

  public Cat(boolean isHealthy) {
    this("cat", isHealthy);
    this.healCost = random.nextInt(6);
  }

  public Cat(String name, boolean isHealthy) {
    super(name, isHealthy);
    super.healCost = random.nextInt(6);
  }
}
