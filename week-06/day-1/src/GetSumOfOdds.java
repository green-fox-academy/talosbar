//Write a Stream Expression to get the sum of the odd numbers in the following list:

import java.util.Arrays;
import java.util.List;

public class GetSumOfOdds {
  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);

    Integer sumOfOdds = numbers.stream()
        .filter(number -> number % 2 == 1)
        .reduce(0, (sum, number) -> sum += number, (sum1, sum2) -> sum1 + sum2);

    System.out.println(sumOfOdds);

  }
}
