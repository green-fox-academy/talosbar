public class AppendAFunc {
  static String appendAFuc(String typo) {

//      StringBuilder newString = new StringBuilder(typo);
//      newString.append("a");
//
//      return newString.toString();

    return typo + "a";
  }

  public static void main(String[] args) {
    String typo = "Chinchill";
    typo = appendAFuc(typo);

    System.out.println(typo);

  }

}

// - Create a string variable named `typo` and assign the value `Chinchill` to it
// - Write a function called `appendAFunc` that gets a string as an input,
//   appends an 'a' character to its end and returns with a string
//
// - Print the result of `appendAFunc(typo)`

//The append is not done, you just print a string that has an "a" appended. The original value is the same.
// Also, the return type is missing.