import java.util.Scanner;

public class animalsAndLegs {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("How many chickens the farmer has?");
        int userInput1 = scanner.nextInt();
        int chickenLegs = userInput1 * 2;
        System.out.println("How many pigs owned by the farmer?");
        int userInput2 = scanner.nextInt();
        int pigsLegs = userInput2 * 4;
        System.out.println((chickenLegs + pigsLegs) + " legs all the animals have.");




    }
}
