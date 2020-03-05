import java.util.Scanner;

public class userInputScanner {
    public static void main(String[] args) {

        System.out.println("Write your name!");
        Scanner scanner = new Scanner(System.in);
        String userInput1 = scanner.nextLine();
        System.out.println("Hello, " + userInput1 + "!");

        System.out.println("Write a distance in miles!");
        int userInput2 = scanner.nextInt();
        int distance = userInput2;
        int kilometer = (int) (0.621371192 * distance);
        System.out.println(kilometer + "km is the distance.");



    }
}
