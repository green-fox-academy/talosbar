package TDD;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class PrimeFactorsTest {

  @Test
  public void factorsOfOneIsEmpty() {
    PrimeFactors factors = new PrimeFactors();
    assertEquals(new ArrayList<Integer>(), factors.of(1));
  }

  @Test
  public void factorsOfTwoIsTwo() {
    PrimeFactors factors = new PrimeFactors();
    assertEquals(new ArrayList<Integer>(Arrays.asList(2)), factors.of(2));
  }

  @Test
  public void factorsOfThreeIsThree() {
    PrimeFactors factors = new PrimeFactors();
    assertEquals(new ArrayList<Integer>(Arrays.asList(3)), factors.of(3));
  }

  @Test
  public void factorsOfFourIsTwoAndTwo() {
    PrimeFactors factors = new PrimeFactors();
    assertEquals(new ArrayList<Integer>(Arrays.asList(2, 2)), factors.of(4));
  }
}