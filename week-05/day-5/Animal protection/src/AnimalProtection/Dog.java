//The animal's name is the same as the class name by default, but it can be set trough constructor as well
//The healing cost should be a random number between 1 and 8

package AnimalProtection;

import java.util.Random;

public class Dog extends Animal {

  Random random = new Random();

  public Dog(boolean isHealthy) {
    this("dog", isHealthy);
    this.healCost = 1 + random.nextInt(8);
  }

  public Dog(String name, boolean isHealthy) {
    super(name, isHealthy);
    super.healCost = 1 + random.nextInt(8);
  }
}
