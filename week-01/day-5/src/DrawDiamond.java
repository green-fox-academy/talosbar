import java.util.Scanner;

public class DrawDiamond {
    public static void main (String[] args) {

        System.out.println("Write a number!");

        Scanner scanner = new Scanner(System.in);
        int yourNumber = scanner.nextInt();

        for (int i = 0; i < yourNumber; i++) {
            for (int j = 0; j < yourNumber; j++ ) {
                if (i == yourNumber / 2 || j == yourNumber / 2 ) {
                    System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } System.out.println();

            }
        }


    }

