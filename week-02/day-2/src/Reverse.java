// Create a method that can reverse a String, which is passed as the parameter
// Use it on this reversed string to check it!
// Try to solve this using charAt() first, and optionally anything else after.

//        You are close! The string itself needs to be reversed, so, instead of printing the characters
//        they need to be put into a String.

public class Reverse {
  public static String reverseString(String toBeReversed) {
    StringBuilder builder = new StringBuilder();
    for (int i = toBeReversed.length() - 1; i >= 0; i--) {
      builder.append(toBeReversed.charAt(i));
    }
    return builder.toString();
  }

  public static void main(String... args) {
    String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
    System.out.println(reverseString(toBeReversed));
  }
}
