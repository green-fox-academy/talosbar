import java.util.Scanner;

public class Sum {
  public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Write your number!");
        int yourNum = scanner.nextInt();*/

    printSum(3);
    printSum(5);
    printSum(13);
  }

  public static void printSum(int yourNum) {
    System.out.println(sum(yourNum));
  }

  public static int sum(int yourNum) {
    int sum = 0;
    for (int i = 0; i < yourNum; i++) {
      sum = sum + i;
    }
    return sum;
  }

}

// Create the usual class wrapper and main method on your own.

// Write a function called `sum` that returns the sum of numbers from zero to the given parameter