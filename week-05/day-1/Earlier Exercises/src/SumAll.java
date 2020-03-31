// - Create an array variable named `numbers`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Print the sum of the elements in `numbers

public class SumAll {
  public static void main(String[] args) {
    int numbers[] = new int[] {3, 4, 5, 6, 7};
    int counter = 0;
    for (int i = 0; i < numbers.length; i++) {
      counter += numbers[i];
    }
    System.out.println(counter);
  }
}
