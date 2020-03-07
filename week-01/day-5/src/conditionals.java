import java.util.Scanner;

public class conditionals {
    public static void main (String[] args) {


        int a = 2;

        if (a == 2) {
            System.out.println("Odd");
        } else {
            System.out.println ("Even");
        }


        int b = 3;

        if (b <= 0) {
            System.out.println("Not enough");
        } else if (b == 1) {
            System.out.println("One");
        } else if (b == 2) {
            System.out.println("Two");
        } else if (b > 2) {
            System.out.println("A lot");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write two numbers!");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        if (firstNumber > secondNumber) {
            System.out.println("The bigger number is: " + firstNumber);
        } else {
            System.out.println("The bigger number is: " + secondNumber);
        }


        System.out.println("How many girls come to the party?");
        int numberGirls = scanner.nextInt();
        System.out.println("How many boys come to the party?");
        int numberBoys = scanner.nextInt();

        int c1 = numberGirls + numberBoys;
        double c2 = numberGirls / numberBoys;

        if (c1 >= 20 && c2 != 1) {
            System.out.println("Quite cool party!");
        } else if (c1 >= 20) {
            System.out.println("The party is excellent!");
        } else if (c1 < 20) {
            System.out.println("Average party...");
        } else if (numberGirls == 0) {
            System.out.println("Sausage party");
        }






    }
}
