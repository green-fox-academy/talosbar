import java.util.Scanner;

public class demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your number!");
        int yourNumber = scanner.nextInt();

        for (int i = 0; i < yourNumber; i++) {
            for (int j = 1; j < 2 * yourNumber; j++) {
                if (j >= yourNumber - i && j <= yourNumber + i ) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}