//Find a random Wikipedia article and copy the contents to a txt file.
//Create a Stream expression which reads all text from this file,
// and prints the 100 most common words in descending order.
// Keep in mind that the text contains punctuation characters which should be ignored.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostCommonWords {
  public static void main(String[] args) {
    String fileName = "assets/wikiArticle.txt";

    Map<Object, Long> mostCommonWords;
    try {
      mostCommonWords = Files.lines(Paths.get(fileName))
          .flatMap(line -> Stream.of(line.split(" ")))
          .map(string -> string.replaceAll("[\\W]|_", ""))
          .filter(string -> string.length() >= 2)
          .collect(Collectors.groupingBy(string -> string, Collectors.counting()))
          .entrySet().stream()
          .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
          .limit(100)
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
      System.out.println(mostCommonWords);
    } catch (IOException e) {
      System.out.println("The file doesn't exist");
      System.exit(-1);
    }
  }
}
