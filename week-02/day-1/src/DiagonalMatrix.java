import java.util.Scanner;

public class DiagonalMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your number!");
        int yourNumber = scanner.nextInt();

        int[][] multiArray = new int[yourNumber][yourNumber];
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                if (i == j) {
                    System.out.print("1");
                    } System.out.print(multiArray[i][j]);
            } System.out.println();
        }

    }
}