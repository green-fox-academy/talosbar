//Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:

import java.util.Arrays;
import java.util.List;

public class FindStringsWithAGivenLetter {
  public static void main(String[] args) {

    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");

    cities.stream()
        .filter(string -> string.startsWith("Z"))
        .forEach(System.out::println);

  }
}
