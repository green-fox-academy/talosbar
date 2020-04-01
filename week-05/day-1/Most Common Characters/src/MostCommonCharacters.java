//Write a function that takes a filename as a parameter.
//    Return the 2 most common characters and their occurrences in the file's content.
//    If the file does not exist throw an exception with the following message: "File does not exist

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonCharacters {
  static HashMap<Character, Integer> returnMostCommonCharacters(String fileName) {
    List<String> lines = getFileContent(fileName);

    HashMap<Character, Integer> countCharacters = countCharacters(lines);

    return getTopTwoPair(countCharacters);
  }

  private static List<String> getFileContent(String fileName) {
    Path filePath = Paths.get("assets/" + fileName);
    List<String> lines;
    try {
      lines = Files.readAllLines(filePath);
    } catch (IOException e) {
      throw new RuntimeException("File does not exist");
    }
    return lines;
  }

  private static HashMap<Character, Integer> getTopTwoPair(HashMap<Character, Integer> countCharacters) {
    HashMap<Character, Integer> mostCommonCharacters = new HashMap<>();

    for (int i = 0; i < 2; i++) {
      Map.Entry<Character, Integer> maxEntry = findMaxEntry(countCharacters);
      mostCommonCharacters.put(maxEntry.getKey(), maxEntry.getValue());
      countCharacters.remove(maxEntry.getKey());
    }
    return mostCommonCharacters;
  }

  private static HashMap<Character, Integer> countCharacters(List<String> lines) {
    HashMap<Character, Integer> countCharacters = new HashMap<>();
    for (String line : lines) {
      for (int i = 0; i < line.length(); i++) {
        char character = line.charAt(i);
        int counter = 1;
        if (countCharacters.containsKey(character)) {
          counter = countCharacters.get(character) + 1;
        }
        countCharacters.put(character, counter);
      }
    }
    return countCharacters;
  }

  private static Map.Entry<Character, Integer> findMaxEntry(HashMap<Character, Integer> countCharacters) {
    Map.Entry<Character, Integer> maxEntry = null;
    for (Map.Entry<Character, Integer> entry : countCharacters.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
        maxEntry = entry;
      }
    }
    return maxEntry;
  }

  public static void main(String[] args) {
    HashMap<Character, Integer> mostCommonCharacters = returnMostCommonCharacters("countchar.txt");
    for (Character key : mostCommonCharacters.keySet()) {
      System.out.println("\"" + key + "\": " + mostCommonCharacters.get(key));
    }
  }
}
