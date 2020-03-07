import java.util.Scanner;

public class countFromTo {
    public static void main (String[] args) {

        System.out.println("Write two numbers!");
        Scanner scanner = new Scanner (System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        if (firstNumber > secondNumber) {
            System.out.println("The second number should be bigger");
        } else {
            while (firstNumber < secondNumber) {
                System.out.println(firstNumber);
                firstNumber += 1;
            }
        }

    }
}
