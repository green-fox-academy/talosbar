import java.io.PrintStream;
import java.util.Scanner;

public class drawPyramid {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your number!");

        int yourNumber = scanner.nextInt();

        for (int i = 0; i < yourNumber; i++) {
            for (int j = 0; j < yourNumber - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
