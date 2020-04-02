import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVExample {
  public static void main(String[] args) {
    Path path = Paths.get("assets/example.csv");
    List<String> lines;
    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    for (String line : lines) {
      String[] data = line.split(",");
      for (int i = 0; i < data.length; i++) {
        data[i] = data[i].strip();
      }
      System.out.println("ez egy valami: " + data[2]);
    }
  }
}
