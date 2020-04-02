package Pirates;

//Create a WarApp class with a main method
//    Create 2 armadas, fill them with ships
//    Have a war!

import java.util.ArrayList;

public class WarApp {
  public static void main(String[] args) {

    Armada armada1 = new Armada();
    Armada armada2 = new Armada();

    armada1.fillArmada();
    armada2.fillArmada();

    armada1.war(armada2);

  }
}

