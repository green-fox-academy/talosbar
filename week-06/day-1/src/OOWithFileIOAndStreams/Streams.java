//Create Stream expressions to perform the following exercises:
//Print the average height of the male characters
//Print the average height of the female characters
//muscle Get the age distribution of the characters by gender (where the gender can be "male", "female" and "other")
//The age groups are: "below 21", "between 21 and 40", "above 40" and "unknown"
//The result should be a Map<String, Map<String, Integer>>

package OOWithFileIOAndStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    for (String line : lines) {
      SWCharacters swCharacter = new SWCharacters();
      String[] data = line.split(";");
      swCharacter.setName(data[0]);
      swCharacter.setHeight(data[1]);
      swCharacter.setMass(data[2]);
      swCharacter.setHairColor(data[3]);
      swCharacter.setSkinColor(data[4]);
      swCharacter.setEyeColor(data[5]);
      swCharacter.setBirthYear(data[6]);
      swCharacter.setGender(data[7]);
      listOfSWCharacters.add(swCharacter);
    }
//    System.out.println("The Star Wars character are the following");
//    for (SWCharacters swCharacter : listOfSWCharacters) {
//      System.out.println(swCharacter);
//    }

//Print the name of the heaviest character (if the mass is unknown, ignore that character)

    listOfSWCharacters.stream()
        .mapToInt(SWCharacters::getMassAsNumber)
        .max()
        .ifPresent(System.out::println);
  }
}
