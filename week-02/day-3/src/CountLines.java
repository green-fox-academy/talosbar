import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// Write a function that takes a filename as string,
// then returns the number of lines the file contains.
// It should return zero if it can't open the file, and
// should not raise any error.

//Mind the indentation, use Code/Reformat code option regularly
//Function names shall describe what they do, so, in this case it could be: calculateNumberOfLines()
//Put only the risky lines into the try {} block

public class CountLines {
  public static void main(String[] args) {

    System.out.println(calculateNumberOfLines("my-file.txt"));
    System.out.println(calculateNumberOfLines("another-file-that-does-not-exist.txt"));

  }

  private static int calculateNumberOfLines(String filename) {
    Path path = Paths.get(filename);
    List<String> lines;

    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      return 0;
    }
    return lines.size();
  }

}
