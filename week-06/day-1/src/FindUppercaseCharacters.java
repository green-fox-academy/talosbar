//Write a Stream Expression to find the uppercase characters in a string!

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindUppercaseCharacters {
  public static void main(String[] args) {

    String myString = "Ablak Zsiráf";

    List<Character> uppercaseLetters = myString.chars()
        .mapToObj(character -> (char) character)
        .filter(Character::isUpperCase)
        .collect(Collectors.toList());

    System.out.println(uppercaseLetters);
  }
}
