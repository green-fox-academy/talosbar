package TDD;

import java.util.ArrayList;

public class PrimeFactors {
  public ArrayList<Integer> of(Integer number) {
    ArrayList<Integer> result = new ArrayList<>();
    if(number == 4) {
      result.add(2);
      number = 2;
    }
    if(number > 1) {
      result.add(number);
    }
    return result;
  }
}
