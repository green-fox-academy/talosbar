import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorstSongs {

//Write a method which can read and parse a file containing information about songs.
//    The method shall receive one string parameter: the name of the file.
//    The method shall handle possible exceptions by printing messages to the standard output.
//    It must return with the year which produced the most songs.

  public static void main(String[] args) {
    System.out.println(getFileContent("assets/100worst.csv"));
  }

  private static String getFileContent(String fileName) {
    //elolvassa a fájlt
    Path filePath = Paths.get(fileName);
    List<String> lines = null;
    HashMap<String, String> songTitleWithReleaseYear = new HashMap<>();
    HashMap<String, Integer> countOccurrence = new HashMap<>();
    Map.Entry<String, Integer> maxEntry = null;
    try {
      lines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("The file doesn't exist");
      System.exit(-1);
    }
    //csinál egy hashmapet csak a dalcímből és a megjelenési évből
    //dalcím nem kell, sok változó
    for (String line : lines) {
      String[] data = line.split(";");
      songTitleWithReleaseYear.put(data[1], data[3]);
    }
    //végig kellene menni a hashmapen, venni a value-kat sorban, és összehasonlítani
    for (String key : songTitleWithReleaseYear.keySet()) {
      String releaseYear = songTitleWithReleaseYear.get(key);
      int counter = 1;
      if (countOccurrence.containsKey(releaseYear)) {
        counter = countOccurrence.get(releaseYear) + 1;
      }
      countOccurrence.put(releaseYear, counter);
    }
    //kiszedni a max counter értéket, és a hozzá tartozó évszámot visszaadni
    for (Map.Entry<String, Integer> entry : countOccurrence.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
        maxEntry = entry;
      }
    }
    return maxEntry.getKey();
  }
}



