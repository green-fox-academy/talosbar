package Pirates;

//Create an Armada class
//Contains Ship-s as a list
//    Have a armada.war(otherArmada) method where two armada can engage in war
//    it should work like merge sort
//    first ship from the first armada battles the first of the other
//    the loser gets skipped so the next ship comes in play from that armada
//    whichever armada gets to the end of its ships loses the war
//    return true if this is the winner

import java.util.ArrayList;

public class Armada {
  private ArrayList<Ship> armada;

  public Armada() {
    this.armada = new ArrayList<>();
  }

  public void fillArmada() {
    int numberOfShips = (int) (Math.random() * 100);
    for (int i = 0; i < numberOfShips; i++) {
      Ship ship = new Ship();
      ship.fillShip();
      armada.add(ship);
    }
  }

  public boolean war(Armada otherArmada) {
    int i = 0;
    int j = 0;
    while (i < armada.size() && j < otherArmada.armada.size()) {
      if (armada.get(i).battle(otherArmada.armada.get(j))) {
        j++;
      } else {
        i++;
      }
    }
    return i != armada.size();
  }
}
