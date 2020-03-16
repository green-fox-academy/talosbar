// Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0

//This method should take a parameter
//Printing and zero handling is not yet done - have you not finished this one?

public class DivideByZero {
  public static void main(String[] args) {
    divideTheNumbers(9);
  }

  public static void divideTheNumbers(int divisor) {
    if (divisor == 0) {
      System.out.println("fail");
    } else {
      System.out.println((double) 10 / divisor);
    }
  }

}



