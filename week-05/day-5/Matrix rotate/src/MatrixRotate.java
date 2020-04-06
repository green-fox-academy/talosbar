//Create a function named rotateMatrix that takes an n×n integer
// matrix (array of arrays) as parameter and returns a matrix
// which elements are rotated 90 degrees clockwise.

public class MatrixRotate {
  public static void main(String[] args) {
    int[][] twoDimensionalArray = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[][] result = rotateMatrix(twoDimensionalArray);
    for (int i = 0; i < twoDimensionalArray.length; i++) {
      for (int j = 0; j < twoDimensionalArray[0].length; j++) {
        System.out.print(result[i][j]+" ");
      }
      System.out.println("");
    }
  }

  public static int[][] rotateMatrix(int[][] twoDimensionalArray) {
    int[][] rotatedMatrix = new int[twoDimensionalArray[0].length][twoDimensionalArray.length];
    for (int i = 0; i < twoDimensionalArray.length; i++) {
      for (int j = 0; j < twoDimensionalArray[0].length; j++) {
        rotatedMatrix[i][j] = twoDimensionalArray[twoDimensionalArray[i].length - 1 - j][i];
      }
    }
    return rotatedMatrix;
  }
}
