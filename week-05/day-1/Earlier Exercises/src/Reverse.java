// - Create an array variable named `numbers`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Reverse the order of the elements in `numbers`
// - Print the elements of the reversed `numbers`

public class Reverse {
  public static void main(String[] args) {

    int numbers[] = new int[] {3, 4, 5, 6, 7};
    int reversedNumbers[] = new int[numbers.length];
    for (int i = numbers.length - 1; i >= 0; i--) {
      reversedNumbers[i] = numbers[numbers.length - 1 - i];
    }
    for (int j = 0; j < reversedNumbers.length; j++) {
      System.out.println(reversedNumbers[j]);
    }
  }
}
