//Write a Stream Expression to get the average value of the odd numbers from the following list:

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class GetAverageOfOdds {
  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

    OptionalDouble averageOfOdds = numbers.stream()
        .filter(number -> number % 2 == 1)
        .mapToInt(number -> number)
        .average();

    System.out.println(averageOfOdds);

  }
}
