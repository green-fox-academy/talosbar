package AnimalProtection;

import java.util.ArrayList;
import java.util.Random;

public class AnimalShelter {

  //It must have a budget, an animals list, an adopters name list
  //The shelter starts with 50€ without any Animal and adopter

  protected int budget;
  protected ArrayList<Animal> listOfAnimals;
  protected ArrayList<String> listOfPotentialAdopters;

  public AnimalShelter() {
    this.budget = 50;
    this.listOfAnimals = new ArrayList<>();
    this.listOfPotentialAdopters = new ArrayList<>();
  }

  //It must have a method named rescue this method takes an Animal as parameter
  //and add the animal to the shelter's list and return the size of the list

  public int rescue(Animal animal) {
    listOfAnimals.add(animal);
    return listOfAnimals.size();
  }

  //It must have a method named heal this method heals the first not healthy Animal
  //if it is possible by budget, returns the amount of healed animals(0 or 1)

  public int heal() {
    int healedAnimal = 0;
    for (Animal animal : listOfAnimals) {
      if ((!animal.isHealthy()) && (budget > 0)) {
        animal.heal();
        healedAnimal++;
        budget -= animal.getHealCost();
        break;
      }
    }
    return healedAnimal;
  }

//  It must have a method named addAdopter this method takes a name as a parameter
//  and saves it as a potential new owner

  public void addAdopter(String adopter) {
    listOfPotentialAdopters.add(adopter);
  }

  //It must have a method named findNewOwner
  //this method pairs a random name with a random adoptable Animal if it is possible
  //and removes both of them from the lists

  private ArrayList<Animal> getAdoptableAnimals() {
    ArrayList<Animal> listOfAdoptableAnimals = new ArrayList<>();
    for (Animal animal : listOfAnimals) {
      if (animal.isAdoptable()) {
        listOfAdoptableAnimals.add(animal);
      }
    }
    return listOfAdoptableAnimals;
  }

  public void findNewOwner() {
    Random random = new Random();
    ArrayList<Animal> listOfAdoptableAnimals = getAdoptableAnimals();
    if ((listOfAdoptableAnimals.size() > 0) && (listOfPotentialAdopters.size() > 0)) {
      Animal randomAdoptedAnimal = listOfAdoptableAnimals.get(random.nextInt(listOfAnimals.size()));
      String randomNewOwner = listOfPotentialAdopters.get(random.nextInt(listOfPotentialAdopters.size()));
      randomAdoptedAnimal.setOwnerName(randomNewOwner);
      listOfAnimals.remove(randomAdoptedAnimal);
      listOfPotentialAdopters.remove(randomNewOwner);
    }
  }

  //It must have a method named earnDonation this method takes an amount as parameter
  //and increases the shelter's budget by the parameter's value and returns the current budget

  public int earnDonation(int donation) {
    return budget += donation;
  }

//  It must have a method named toString that represents the shelter
//  and print all the informations about the shelter and the animals in the following format:

  public String toString() {
    String stateOfAnimalShelter = "Budget: " + budget + " €, \n There are " + listOfAnimals.size() + " animal(s) and " + listOfPotentialAdopters.size() + " potential adopter(s). \n";
    String healthyAnimals = "";
    String unhealthyAnimals = "";
    for (Animal animal : listOfAnimals) {
      if (! animal.isAdoptable()) {
        healthyAnimals += "The animal called " + animal.getName().toUpperCase() + " is not healthy (healing would cost: " + animal.getHealCost() + " €) and not adoptable. \n";
      } else {
        unhealthyAnimals += "The animal called " + animal.getName().toUpperCase() + " is healthy and adoptable. \n";
      }
    }
    return stateOfAnimalShelter + healthyAnimals + unhealthyAnimals;
  }
}
