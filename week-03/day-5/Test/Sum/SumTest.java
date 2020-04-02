package Sum;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class SumTest {

  Sum sum = new Sum();

  @Test
  public void getSumWithEmptyList() {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList());
    assertEquals(0, sum.getSum(numbers));
  }

  @Test
  public void getSumWithOneElement() {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2));
    assertEquals(2, sum.getSum(numbers));
  }

  @Test
  public void getSumWithMultipleElements() {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2, 23, 30));
    assertEquals(55, sum.getSum(numbers));
  }

  @Test
  public void getSumWithNull() {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0));
    assertEquals(0, sum.getSum(numbers));
  }

  @Test
  public void getSumWithPositiveAndNegativeElements() {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2, -2, 4));
    assertEquals(4, sum.getSum(numbers));
  }

  @Test
  public void getSumWithOnlyNegativeElements() {
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-2, -2, -4));
    assertEquals(-8, sum.getSum(numbers));
  }
}