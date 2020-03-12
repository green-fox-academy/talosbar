public class DivideByZero {
    public static void main(String[] args) {
        if (divideTheNumbers() == 0) {
            System.out.println("fail");
        } else {
            System.out.println(divideTheNumbers());
        }
    }

    public static double divideTheNumbers() {
        int takedNumber = 9;
        int dividor = 10;
        return (double)takedNumber / dividor;
    }


}

    // Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0

