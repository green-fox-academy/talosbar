package AnimalProtection;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    Cat cat1 = new Cat("Kitty", false);
    Cat cat2 = new Cat( true);
    Dog dog1 = new Dog("Rex", false);
    Dog dog2 = new Dog( true);
    Parrot par1 = new Parrot( false);
    Parrot par2 = new Parrot("Jane", true);

    AnimalShelter animalShelter = new AnimalShelter();

    animalShelter.rescue(cat1);
    animalShelter.rescue(cat2);
    animalShelter.rescue(par1);
    animalShelter.rescue(par2);
    animalShelter.rescue(dog1);
    animalShelter.rescue(dog2);

    animalShelter.addAdopter("John");
    animalShelter.addAdopter("Sarah");
    animalShelter.addAdopter("Bobby");
    animalShelter.addAdopter("Hannah");

    animalShelter.earnDonation(50);
    animalShelter.heal();
    animalShelter.findNewOwner();

    System.out.println(animalShelter.toString());
  }
}