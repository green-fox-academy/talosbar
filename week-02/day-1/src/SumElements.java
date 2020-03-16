import java.util.stream.IntStream;

public class SumElements {
  public static void main(String[] args) {
    int[] newArray = {54, 23, 66, 12};

    int sum = 0;
    for (int i = 1; i < 2; i++) {
      sum = newArray[i] + newArray[i + 1];
      System.out.println("The sum of the second and the third element is: " + sum);
    }


        /*int sum = IntStream.of(newArray).sum();
            System.out.println("The sum of the element is: " + sum);*/
  }

}

