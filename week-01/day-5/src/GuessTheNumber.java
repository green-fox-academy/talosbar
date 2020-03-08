import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main (String[] args) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);

        System.out.println("Write a number!");
        Scanner scanner = new Scanner (System.in);
        int yourNumber = scanner.nextInt();

        if (randomNumber > yourNumber) {
            System.out.println("The stored number is higher. The stored number is: " + randomNumber);
        } else if (randomNumber < yourNumber) {
                System.out.println("The stored number is lower. The stored number is: " + randomNumber);
        } else {
            System.out.println("You found the number: " + randomNumber);
        }
    }

}
