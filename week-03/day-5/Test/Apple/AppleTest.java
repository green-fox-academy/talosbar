package Apple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppleTest {

  Apple myString;

  @Test
  public void getAppleTest() {
    this.myString = new Apple();
    assertEquals("apple", myString.getApple());
  }

//  @Before
//  public void setup() {
//    this.myString = new Apple();
//  }
//
//  @Test
//  public void getCorrectTest() {
//    assertEquals("apple", myString.getApple());
//  }
//
//  @Test
//  public void getWrongNameTest() {
//    assertEquals("orange", myString.getApple());
//  }
}