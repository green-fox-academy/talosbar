public class fizzBuzz {
    public static void main (String[] args) {

        int a = 0;
        while (a < 100) {
            a += 1;
            if ((a % 3 == 0) && (a % 5 == 0)) {
                System.out.println("FizzBuzz");
            } else if (a % 3 == 0) {
                    System.out.println("Fizz");
                } else if (a % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(a);
            }
            }
        }

    }

