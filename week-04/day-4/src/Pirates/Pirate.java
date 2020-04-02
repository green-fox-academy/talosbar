package Pirates;

//Create a Pirate class. While you can add other fields and methods, you must have these methods:-
//
//    drinkSomeRum() - intoxicates the Pirate some
//    howsItGoingMate() - when called, the Pirate replies, if drinkSomeRun was called:-
//    0 to 4 times, "Pour me anudder!"
//    else, "Arghh, I'ma Pirate. How d'ya d'ink its goin?", the pirate passes out and sleeps it off.
//    If you manage to get this far, then you can try to do the following.
//
//    die() - this kills off the pirate, in which case, drinkSomeRum, etc. just result in he's dead.
//    brawl(x) - where pirate fights another pirate (if that other pirate is alive) and
//    there's a 1/3 chance, 1 dies, the other dies or they both pass out.
//    And... if you get that far...
//
//    Add a parrot.

import java.util.Random;

public class Pirate {

  enum State {
    AWAKE,
    ASLEEP,
    DEAD
  }

  private int consumedRum;
  private State state;
  private boolean isACaptain;
  private boolean hasAParrot;

  public Pirate(int consumedRum, State state) {
    this.consumedRum = consumedRum;
    this.state = state;
    this.isACaptain = false;
    this.hasAParrot = true;
  }

  public Pirate(int consumedRum, State state, boolean isACaptain) {
    this.consumedRum = consumedRum;
    this.state = state;
    this.isACaptain = isACaptain;
    this.hasAParrot = true;
  }

  public Pirate() {
    this(0, State.AWAKE);
  }

  public void drinkSomeRum() {
    consumedRum++;
  }

  public void howsItGoingMate() {
    if (consumedRum <= 4) {
      System.out.println("Pour me anudder!");
    } else {
      System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
      fallAsleep();
    }
  }

  public void fallAsleep() {
    state = State.ASLEEP;
  }

  public void die() {
    state = State.DEAD;
  }

  public boolean isAlive() {
    return state != State.DEAD;
  }

  public void brawl(Pirate otherPirate) {
    Random random = new Random();
    int chance1 = random.nextInt(3);
    int chance2 = random.nextInt(3);
    if (chance1 < chance2) {
      this.die();
    } else if (chance2 < chance1) {
      otherPirate.die();
    } else {
      this.fallAsleep();
      otherPirate.fallAsleep();
    }
  }

  public int getConsumedRum() {
    return consumedRum;
  }

  public State getState() {
    return state;
  }

  public boolean isACaptain() {
    return this.isACaptain;
  }

  public boolean hasAParrot() {
    return this.hasAParrot;
  }
}
