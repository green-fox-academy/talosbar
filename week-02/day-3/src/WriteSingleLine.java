import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteSingleLine {
  public static void main(String[] args) {
    List<String> content = new ArrayList<String>();
    manipulateFile(content);
    try { // Required by Files.write(filePath, content)
      // Creates a new file if not exists and overwrites it's content
      // The elements of the content lists will become the lines of the file
      Path filePath = Paths.get("my-file.txt");
      Files.write(filePath, content);
    } catch (IOException e) {
      System.out.println("Unable to write file: my-file.txt");
    }
  }

  public static boolean manipulateFile(List<String> content) {
    return content.add("My bluest cat.");
  }
}


// Write a function that is able to manipulate a file
// By writing your name into it as a single line
// The file should be named "my-file.txt"
// In case the program is unable to write the file,
// It should print the following error message: "Unable to write file: my-file.txt"
