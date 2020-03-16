import java.io.PrintStream;
import java.util.Scanner;

public class drawPyramid {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Write your number!");

    int yourNumber = scanner.nextInt();

    for (int i = 0; i < yourNumber; i++) {
      for (int j = 1; j < 2 * yourNumber; j++) {
        if (j >= yourNumber - i && j <= yourNumber + i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();


//        for (int i = 0; i < yourNumber; i++) {
//            for (int j = 0; j < yourNumber - i; j++) {
//                System.out.print(" ");
//            }
//            for (int k = 0; k <= i; k++) {
//                System.out.print("* ");
//            }
//            System.out.println();
    }

  }

}


//i=0 ...*... j elemek száma a sorban, 2 * yourNumber - 1
//i=1 ..***..
//i=2 .*****.
//i=3 *******