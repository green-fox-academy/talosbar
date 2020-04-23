package OOWithFileIOAndStreams;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Streams {
  public static void main(String[] args) {

    List<SWCharacters> listOfSWCharacters = new ArrayList<>();

    Path path = Paths.get("assets/swcharacters.csv");
    List<String> lines;
    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      throw new RuntimeException("This file doesn't exist");
    }
    lines.remove(0);
    for (String line : lines) {
      SWCharacters swCharacter = new SWCharacters();
      String[] result = line.split(";");
      swCharacter.setName(result[0]);
      swCharacter.setHeight(result[1]);
      swCharacter.setMass(result[2]);
      swCharacter.setHairColor(result[3]);
      swCharacter.setSkinColor(result[4]);
      swCharacter.setEyeColor(result[5]);
      swCharacter.setBirthYear(result[6]);
      swCharacter.setGender(result[7]);
      listOfSWCharacters.add(swCharacter);
    }

//    System.out.println("The Star Wars character are the following");
//    for (SWCharacters swCharacter : listOfSWCharacters) {
//      System.out.println(swCharacter);
//    }

//Print the name of the heaviest character (if the mass is unknown, ignore that character)

    System.out.println(listOfSWCharacters.stream()
        .filter(swCharacter -> swCharacter.getMassAsNumber() != null)
        .max(Comparator.comparing(SWCharacters::getMassAsNumber))
        .orElseThrow(NoSuchElementException::new)
        .getName());

//Print the average height of the male characters

    System.out.println(listOfSWCharacters.stream()
        .filter(swCharacter -> swCharacter.getHeightAsNumber() != null)
        .filter(swCharacter -> swCharacter.getGender().equals("male"))
        .mapToInt(SWCharacters::getHeightAsNumber)
        .average());

//Print the average height of the female characters

    System.out.println(listOfSWCharacters.stream()
        .filter(swCharacter -> swCharacter.getHeightAsNumber() != null)
        .filter(swCharacter -> swCharacter.getGender().equals("female"))
        .mapToInt(SWCharacters::getHeightAsNumber)
        .average());

//Get the age distribution of the characters by gender (where the gender can be "male", "female" and "other")
//The age groups are: "below 21", "between 21 and 40", "above 40" and "unknown"
//The result should be a Map<String, Map<String, Integer>>

    Map<String, Map<String, Long>> mapOfGendersByAge = listOfSWCharacters.stream()
        .collect(groupingBy(Streams::groupingByGender,
            groupingBy(Streams::groupingByAge, counting())));

    mapOfGendersByAge.entrySet()
        .forEach(System.out::println);
  }

  public static String groupingByAge(SWCharacters swCharacter) {
    String birthYear = swCharacter.getBirthYear().replace("BBY", "");
    if (birthYear.equals("unknown")) {
      return birthYear;
    } else {
      double year = Double.parseDouble(birthYear);
      if (year < 21) {
        return "below 21";
      } else if (year > 40) {
        return "above 40";
      } else {
        return "between 21 and 40";
      }
    }
  }

  public static String groupingByGender(SWCharacters swCharacter) {
    if (!swCharacter.getGender().equals("male") && !swCharacter.getGender().equals(("female"))) {
      return "other";
    } else {
      return swCharacter.getGender();
    }
  }
}
