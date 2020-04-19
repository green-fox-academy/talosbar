//Write a Stream Expression to find the frequency of characters in a given string!

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOfCharacters {
  public static void main(String[] args) {

    String myString = "Ablak Zsiráf könyv";

    Map<String, Long> frequentChars = Arrays.stream(myString.split(""))
        .map(c -> c.replace(" ", ""))
        .filter(c -> c.length() > 0)
        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

    System.out.println(frequentChars);

  }
}
