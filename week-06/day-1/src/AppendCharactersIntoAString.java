//Write a Stream Expression to concatenate a Character list to a string!

import java.util.Arrays;
import java.util.List;;

public class AppendCharactersIntoAString {
  public static void main(String[] args) {

    List<Character> characters = Arrays.asList('a', 'b', 'l', 'a', 'k');

    StringBuilder charactersToString = new StringBuilder();
    characters.stream()
        .forEach(charactersToString::append);

    System.out.println(charactersToString);
  }
}