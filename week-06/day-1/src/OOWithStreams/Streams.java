package OOWithStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
  public static void main(String[] args) {

    List<Fox> foxes = new ArrayList<>();
    foxes.add(new Fox("Foxy", "green", 3));
    foxes.add(new Fox("Vuk", "red", 1));
    foxes.add(new Fox("Karak", "grey", 8));

//Write a Stream Expression to find the foxes with green color!

    List<Fox> greenFoxes = foxes.stream()
        .filter(fox -> fox.getColor().equals("green"))
        .collect(Collectors.toList());

    for (Fox greenFox : greenFoxes) {
      System.out.println("The green foxes are the following: \n" + greenFox);
    }

//Write a Stream Expression to find the foxes with green color, and age less then 5 years!

    List<Fox> greenFoxesWithAgeLessThenFive = foxes.stream()
        .filter(fox -> fox.getColor().equals("green") && fox.getAge() < 5)
        .collect(Collectors.toList());

    for (Fox littleGreenFox : greenFoxes) {
      System.out.println("The little green foxes are the following: \n" + littleGreenFox);
    }

//Write a Stream Expression to find the frequency of foxes by color!

    Map<String, Long> foxColorFrequencies = foxes.stream()
        .collect(Collectors.groupingBy(Fox::getColor, Collectors.counting()));

    System.out.println("Here are all of the colors of the foxes grouped by frequency: \n" + foxColorFrequencies);
  }
}
