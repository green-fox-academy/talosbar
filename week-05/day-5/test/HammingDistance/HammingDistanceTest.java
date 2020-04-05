package HammingDistance;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class HammingDistanceTest {

  ArrayList<String> listToCompare;
  ArrayList<String> expectedWords;

  @Test
  public void compareStringsTest() {
    listToCompare = new ArrayList<>(Arrays.asList("apple", "apply", "tuple", "alter"));
    expectedWords = new ArrayList<>(Arrays.asList("apple", "apply", "tuple"));
    assertEquals(expectedWords, HammingDistance.getWords("apple", listToCompare));
  }

  @Test
  public void compareStringsTestWithOtherWords() {
    listToCompare = new ArrayList<>(Arrays.asList("donkey", "monday", "shaker"));
    expectedWords = new ArrayList<>(Arrays.asList("donkey", "monday"));
    assertEquals(expectedWords, HammingDistance.getWords("monkey", listToCompare));
  }

  @Test
  public void compareStringsTestWithWordsWithDifferentLength() {
    listToCompare = new ArrayList<>(Arrays.asList("donkeys", "mondays", "shakers"));
    expectedWords = new ArrayList<>(Collections.emptyList());
    assertEquals(expectedWords, HammingDistance.getWords("monkey", listToCompare));
  }

  @Test
  public void compareStringsTestWithWordsWhenOnlyOneWordHasDifferentLength() {
    listToCompare = new ArrayList<>(Arrays.asList("donkeys", "monday", "shaker"));
    expectedWords = new ArrayList<>(Arrays.asList("monday"));
    assertEquals(expectedWords, HammingDistance.getWords("monkey", listToCompare));
  }
}