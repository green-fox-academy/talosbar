//Find a random Wikipedia article and copy the contents to a txt file.
//Create a Stream expression which reads all text from this file,
// and prints the 100 most common words in descending order.
// Keep in mind that the text contains punctuation characters which should be ignored.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exercise11 {
  public static void main(String[] args) {
    String fileName = "assets/wikiArticle.txt";

    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

      stream.forEach(System.out::println);

    } catch (IOException e) {
      System.out.println("The file doesn't exist");
      System.exit(-1);
    }
  }
}
