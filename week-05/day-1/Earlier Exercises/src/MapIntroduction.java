import java.util.HashMap;

public class MapIntroduction {
  public static void main(String[] args) {
    HashMap<String, String> booksWithISBN = new HashMap<>();
    booksWithISBN.put("978-1-60309-452-8", "A Letter to Jo");
    booksWithISBN.put("978-1-60309-459-7", "Lupus");
    booksWithISBN.put("978-1-60309-444-3", "Red Panda and Moon Bear");
    booksWithISBN.put("978-1-60309-461-0", "The Lab");

    for (String key : booksWithISBN.keySet()) {
      System.out.println(booksWithISBN.get(key) + " (ISBN: " + key + ")");
    }

    booksWithISBN.remove("978-1-60309-444-3");
    booksWithISBN.values().remove("The Lab");

    booksWithISBN.put("978-1-60309-450-4", "They Called Us Enemy");
    booksWithISBN.put("978-1-60309-453-5", "Why Did We Trust Him?");


    if (booksWithISBN.containsKey("478-0-61159-424-8")) {
      System.out.println("The associated book with ISBN 478-0-61159-424-8: " + booksWithISBN.get("478-0-61159-424-8"));
    } else {
      System.out.println("There isn't associated book with ISBN 478-0-61159-424-8");
    }

    System.out.println("The associated book with ISBN 978-1-60309-453-5: " + booksWithISBN.get("978-1-60309-453-5"));
  }
}
