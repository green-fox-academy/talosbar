package Sum;

//Create a sum method in your class which has an ArrayList of Integers as parameter
//    It should return the sum of the elements in the list
//    Follow these steps:
//    Add a new test case
//    Instantiate your class
//create a list of integers
//        use the assertEquals to test the result of the created sum method
//        Run them
//        Create different tests where you test your method with:
//    an empty list
//    a list that has one element in it
//    a list that has multiple elements in it
//    a null
//    Run them
//    Fix your code if needed

import java.util.ArrayList;

public class Sum {
  public int getSum(ArrayList<Integer> numbers) {

    int sum = 0;
    try {
      for (int i = 0; i < numbers.size(); i++) {
        sum += numbers.get(i);
      }
    } catch (NullPointerException e) {
      System.out.println("We haven't numbers");
    }
    return sum;

  }
}
