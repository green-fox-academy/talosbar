package Pirates;

//It should have a list of pirates.
//    You must be able to add new pirates to the ship. It must have only one captain!
//    You must create the following methods:
//    getPoorPirates() which returns a list of names containing the pirates that
//    have a wooden leg and have less than 15 golds
//    getGolds() which returns the sum of gold owned by the pirates of that particular ship
//    lastDayOnTheShip() which calls the pirates' party() method.
//    prepareForBattle() which calls
//    the pirates' work() method 5 times
//    then the ship's lastDayOnTheShip() method.

import java.util.ArrayList;

public class Ship {
  private Pirate captain;
  private ArrayList<Pirate> crew;

  public Ship() {
    this.captain = null;
    this.crew = new ArrayList<>();
  }

  public void addPirate(Pirate pirate) {
    if (pirate.isACaptain()) {
      this.captain = pirate;
    } else {
      crew.add(pirate);
    }
  }

  public ArrayList<String> getPoorPirates() {
    ArrayList<String> namesOfPoorPirates = new ArrayList<>();
    if (this.captain.isPoor()) {
      namesOfPoorPirates.add(captain.getName());
    }

    for (int i = 0; i < crew.size(); i++) {
      if (crew.get(i).isPoor()) {
        namesOfPoorPirates.add(crew.get(i).getName());
      }
    }
    return namesOfPoorPirates;
  }

  public int getGold() {
    int counter = captain.getAmountOfGold();
    for (Pirate pirate : crew) {
      counter += pirate.getAmountOfGold();
    }
    return counter;
  }

  public void lastDayOnTheShip() {
    for (Pirate pirate : crew) {
      pirate.party();
    }
    captain.party();
  }

  public void prepareForBattle() {
    for (int j = 0; j < 5; j++) {
      for (Pirate pirate : crew) {
        pirate.work();
      }
      captain.work();
    }
    lastDayOnTheShip();
  }
}