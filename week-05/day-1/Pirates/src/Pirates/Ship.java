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

  public void fillShip() {
    captain = new Pirate();
    int numberOfPirates = (int) (Math.random() * 100);

    for (int i = 0; i < numberOfPirates; i++) {
      crew.add(new Pirate());
    }
  }

  public void getPoorPirates() {
    for (int i = 0; i < crew.size(); i++) {
      if (Pirate.hasAWoodenLeg() && Pirate.getAmountOfGold() < 15) {
        System.out.println(crew.get(i));
      }
    }
  }

  public void getGold() {
    int counter = 0;
    for (Pirate pirate : crew) {
      if (Pirate.getAmountOfGold() != 0) {
        counter++;
      }
    }
  }

  public Pirate getCaptain() {
    return captain;
  }

  public ArrayList<Pirate> getCrew() {
    return crew;
  }
}