public class TodoPrint {
  public static void main(String... args) {
//        String todoText = " - Buy milk\n";
    StringBuilder todoText = new StringBuilder(" - Buy milk\n");
    todoText.insert(0, "My todo:\n");
    todoText.append(" - Download games\n");
    todoText.append("    - Diablo");
    // Add "My todo:" to the beginning of the todoText
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention

    // Expected output:

    // My todo:
    //  - Buy milk
    //  - Download games
    //      - Diablo

    System.out.println(todoText);
  }
}
