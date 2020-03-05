import java.util.Scanner;

public class averageOfInput {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Write 5 numbers!");
        int userInput1 = scanner.nextInt();
        int userInput2 = scanner.nextInt();
        int userInput3 = scanner.nextInt();
        int userInput4 = scanner.nextInt();
        int userInput5 = scanner.nextInt();
        int a = userInput1 + userInput2 + userInput3 + userInput4 + userInput5;
        double b = a / 5;
        System.out.println("Sum: " + a );
        System.out.println("Average: " + b);



    }
}
