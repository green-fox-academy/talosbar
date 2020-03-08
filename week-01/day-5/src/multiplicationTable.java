import java.util.Scanner;

public class multiplicationTable {
    public static void main (String[] args) {

        System.out.println("Write a number!");
        Scanner scanner = new Scanner(System.in);
        int yourNumber = scanner.nextInt();
        int a = 1;
        while (a <= 10) {
            System.out.printf("%d * %d = %d \n", a, yourNumber, a * yourNumber);
            a += 1;
        }

    }
}
