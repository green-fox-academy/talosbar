import java.util.Scanner;

public class DrawChessTable {
    public static void main(String[] args) {

        System.out.println("Write your number!");

        Scanner scanner = new Scanner(System.in);
        int yourNumber = scanner.nextInt();

        for (int i = 0; i < yourNumber; i++) {
            for (int j = 0; j < yourNumber / 2; j++) {
                if (i % 2 != 0 ) {
                    System.out.print("% ");
                } else {
                    System.out.print(" %");
                }
            }
            System.out.println();
        }
    }
}