package HammingDistance;

import java.util.ArrayList;

public class HammingDistance {

  public static ArrayList<String> getWords(String stringToCompare, ArrayList<String> listToCompare) {
    ArrayList<String> wordsWithHammingDistance = new ArrayList<>();
    for (String word : listToCompare) {
      if (stringToCompare.length() != word.length()) {
        continue;
      }
      int disCounter = 0;
      for (int i = 0; i < stringToCompare.length(); i++) {
        if (stringToCompare.charAt(i) != word.charAt(i)) {
          disCounter++;
        }
      }
      if (disCounter <= 3) {
        wordsWithHammingDistance.add(word);
      }
    } return wordsWithHammingDistance;
  }
}




