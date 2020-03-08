import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your number!");

        int yourNumber = scanner.nextInt();


        //i-ből (sor) és j-ből (oszlop) ugyanannyi van, a yourNumber alapján
        for (int i = 0; i < yourNumber; i++) {
            for (int j = 0; j < yourNumber; j++) {
                //első és utolsó sor legyen tele %-kal
                if (i == 0 || i == yourNumber - 1) {
                    System.out.print("%");
                } //első és utolsó oszlop legyen tele %-kal
                else if (j == 0 || j == yourNumber - 1) {
                    System.out.print("%");
                } //átlón kívüli szóközök
                else if (i != j) {
                    System.out.print(" ");
                } // átló
                else {
                    System.out.print("%");
                }
            }
            System.out.println();
        }
    }



}
