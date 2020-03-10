import java.util.Scanner;

public class Sum {
//    public static int sum(int yourNum) {
//            return sum(yourNum);
//        }

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Write your number!");
        int yourNum = scanner.nextInt();*/


        int[] newArray = {2, 4, 5, 7};

        int sum = 0;
        for (int i = 0; i < newArray.length; i++) {
            sum = sum + newArray[i];
        }

        System.out.println(sum);
    }
}

// Create the usual class wrapper and main method on your own.

// Write a function called `sum` that returns the sum of numbers from zero to the given parameter