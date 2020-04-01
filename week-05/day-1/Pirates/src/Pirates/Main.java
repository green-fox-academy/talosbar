package Pirates;

public class Main {
  public static void main(String[] args) {

    Ship ship = new Ship();

    Pirate pirate1 = new Pirate("Joe", 14, true, false);
    Pirate pirate2 = new Pirate("Bob", 20, false, true);

    ship.addPirate(pirate1);
    ship.addPirate(pirate2);
    ship.addPirate(new Pirate("Sam", 30));

    System.out.println("Before the battle the health points of the first pirate is: " + pirate1.getHealthPoints());
    System.out.println("The names of the poor pirates are: " + ship.getPoorPirates());
    System.out.println("Before the battle the pirates have: " + ship.getGold() + " golds.");

    ship.prepareForBattle();
  }
}
