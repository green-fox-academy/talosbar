// When saving this quote a disk error has occurred. Please fix it.
// Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
// Using pieces of the quote variable (instead of just redefining the string)

public class TakesLonger {
  public static void main(String... args) {
    StringBuilder quote = new StringBuilder("Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.");
    int offset = quote.indexOf ("you");
    quote.insert(offset, "always takes longer than ");

    System.out.println(quote);
  }
}

//Make this task without hardcoded value 20! :-)