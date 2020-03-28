//Create a function named isSymmetric that takes an n×n integer matrix (two dimensional array/list)
//    as a parameter and returns true if the matrix is symmetric or false if it is not.
//    Symmetric means it has identical values along its diagonal
//    axis from top-left to bottom-right, as in the first example.

public class SymmetricMatrix {
  static boolean isSymmetric(int[][] twoDimensionalArray) {
    for (int i = 0; i < twoDimensionalArray.length; i++) {
      //If I write j < twoDimensionalArray.length, that will check same elements in a reversed order, too, it's unnecessary.
      for (int j = 0; j < i; j++) {
        if (twoDimensionalArray[i][j] != twoDimensionalArray[j][i]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] twoDimensionalArray = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    boolean result = isSymmetric(twoDimensionalArray);
    System.out.println(result);
  }
}

