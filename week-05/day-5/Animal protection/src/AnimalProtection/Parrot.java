//The animal's name is the same as the class name by default, but it can be set trough constructor as well
//The healing cost should be a random number between 4 and 10

package AnimalProtection;

import java.util.Random;

public class Parrot extends Animal {

  Random random = new Random();

  public Parrot(boolean isHealthy) {
    this("parrot", isHealthy);
    this.healCost = 4 + random.nextInt(7);
  }

  public Parrot(String name, boolean isHealthy) {
    super(name, isHealthy);
    super.healCost = 4 + random.nextInt(7);
  }
}
