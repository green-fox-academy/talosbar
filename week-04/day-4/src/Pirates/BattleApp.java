package Pirates;

//Create a BattleApp class with a main method
//    Create 2 ships, fill them with pirates
//    Have a battle!

public class BattleApp {
  public static void main(String[] args) {

    Ship ship1 = new Ship();
    Ship ship2 = new Ship();

    ship1.fillShip();
    ship2.fillShip();

    ship1.battle(ship2);

    ship1.showState();
    ship2.showState();

    ship1.getCaptain().brawl(ship2.getCaptain());
    ship1.getCaptain().howsItGoingMate();
    System.out.println(ship2.getCaptain().hasAParrot());


  }
}
