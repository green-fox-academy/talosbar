package Pirates;

//The place for the Pirates
//
//    Create a Ship class.
//    The Ship stores Pirate-s instances in a list as the crew and has one captain who is also a Pirate.
//    When a ship is created it doesn't have a crew or a captain.
//    The ship can be filled with pirates and a captain via fillShip() method.
//    Filling the ship with a captain and random number of pirates.

import java.util.ArrayList;
import java.util.Random;


public class Ship {

  private ArrayList<Pirate> crew;

  public Ship() {
    this.crew = new ArrayList<>();
  }

  public void fillShip() {
    crew.add(new Pirate(30, Pirate.State.AWAKE, true));
    int numberOfPirates = (int) (Math.random() * 100);
    for (int i = 0; i < numberOfPirates; i++) {
      crew.add(new Pirate());
    }
  }

  public Pirate getCaptain() {
    for (Pirate pirate : crew) {
      if (pirate.isACaptain()) {
        return pirate;
      }
    }
    return null;
  }

//    Ships should be represented in a nice way on command line including information about
//    captains consumed rum, state (passed out / died)
//    number of alive pirates in the crew
//    Ships should have a method to battle other ships: ship.battle(otherShip)
//    should return true if the actual ship (this) wins
//    the ship should win if its calculated score is higher
//    calculate score: Number of Alive pirates in the crew - Number of consumed rum by the captain

  private int getCounter() {
    int counter = 0;
    for (Pirate pirate : crew) {
      if (pirate.getState() != Pirate.State.DEAD) {
        counter++;
      }
    }
    return counter;
  }

  public void showState() {
    int counter = getCounter();
    System.out.println("The captain is consumed rum: " + getCaptain().getConsumedRum() + " and his state is: " + getCaptain().getState().toString().toLowerCase() + " the number of alive pirates in the crew is: " + counter);
  }

  private int calculatedScore() {
    int calculatedScore = getCounter() - getCaptain().getConsumedRum();
    return calculatedScore;
  }

//    The loser crew has a random number of losses (deaths).
//    The winner captain and crew has a party, including a random number of rum :)

  public boolean battle(Ship otherShip) {
    boolean thisWins = this.calculatedScore() > otherShip.calculatedScore();
    Ship winner = thisWins ? this : otherShip;
    winner.win();
    Ship looser = thisWins ? otherShip : this;
    looser.lose();
    return thisWins;
  }

  private void win() {
    Random random = new Random();
    int limit = random.nextInt(5);
    for (int partyTime = 0; partyTime < limit; partyTime++) {
      for (Pirate pirate : crew) {
        pirate.drinkSomeRum();
      }
    }
  }

  private void lose() {
    Random random = new Random();
    int limit = random.nextInt(20);
    ArrayList<Pirate> livingCrew = getLivingCrew();
    for (int i = 0; i < limit; i++) {
        livingCrew.get(i).die();
    }
  }

  private ArrayList<Pirate> getLivingCrew() {
    ArrayList<Pirate> livingCrew = new ArrayList<>();
    for (Pirate pirate : crew) {
      if (pirate.isAlive()) {
        livingCrew.add(pirate);
      }
    }
    return livingCrew;
  }
}


