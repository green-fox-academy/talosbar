package Pirates;

//The place for the Pirates
//
//    Create a Ship class.
//    The Ship stores Pirate-s instances in a list as the crew and has one captain who is also a Pirate.
//    When a ship is created it doesn't have a crew or a captain.
//    The ship can be filled with pirates and a captain via fillShip() method.
//    Filling the ship with a captain and random number of pirates.
//    Ships should be represented in a nice way on command line including information about
//    captains consumed rum, state (passed out / died)
//    number of alive pirates in the crew
//    Ships should have a method to battle other ships: ship.battle(otherShip)
//    should return true if the actual ship (this) wins
//    the ship should win if its calculated score is higher
//    calculate score: Number of Alive pirates in the crew - Number of consumed rum by the captain
//    The loser crew has a random number of losses (deaths).
//    The winner captain and crew has a party, including a random number of rum :)

import java.util.ArrayList;


public class Ship {
  private Pirate captain;
  private ArrayList<Pirate> crew;

  public Ship() {
    this.captain = null;
    this.crew = new ArrayList<>();
  }

  public void fillShip() {
    captain = new Pirate();
    int numberOfPirates = (int) (Math.random() * 100);

    for (int i = 0; i < numberOfPirates; i++) {
      crew.add(new Pirate());
    }
  }

  private void showState() {
    int counter = 0;
    for (Pirate pirate : crew) {
      if (pirate.getState() != Pirate.State.DEAD) {
        counter++;
      }
    }
    System.out.println("The captain is consumed rum: " + captain.getConsumedRum() + " and his state is: " + captain.getState() + " the number of alive pirates is: " + counter);
  }

  public Pirate getCaptain() {
    return captain;
  }

  public ArrayList<Pirate> getCrew() {
    return crew;
  }
}


