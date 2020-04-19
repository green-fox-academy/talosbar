//Write a Stream Expression to get the squared value of the positive numbers from the following list:

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetSquaredPositiveNumbers {
  public static void main(String[] args) {

    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    List<Integer> squaredPositiveNumbers = numbers.stream()
        .filter(number -> number > 0)
        .map(number -> number * number)
        .collect(Collectors.toList());

    System.out.println(squaredPositiveNumbers);

  }
}
