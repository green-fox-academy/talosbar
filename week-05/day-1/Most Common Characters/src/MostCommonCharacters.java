//Write a function that takes a filename as a parameter.
//    Return the 2 most common characters and their occurrences in the file's content.
//    If the file does not exist throw an exception with the following message: "File does not exist

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class MostCommonCharacters {
  static void returnMostCommonCharacters() {
    try {
      Path filePath = Paths.get("/home/atanaz/Desktop/exam-trial-basics/countchar.txt");
      List<String> characters = Files.readAllLines(filePath);
      HashMap<Character, Integer> charCountMap = new HashMap<>();
      for (String character : characters) {
        if(charCountMap.containsKey(character)) {
          charCountMap.put(character, charCountMap(character)+1);
        }
        else {
          charCountMap.put(character,1);
        }
      }
    } catch (IOException e) {
      System.out.println("File does not exist");
    }
  }

  public static void main(String[] args) {
    returnMostCommonCharacters();
  }
}
