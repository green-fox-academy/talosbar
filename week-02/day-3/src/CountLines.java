import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    public static void main(String[] args) {
       /* if (lines.size() == 0) {
            System.out.println("This file doesn't exist");
        }*/

        System.out.println(numberOfLines("myFile.txt"));

    }

    private static int numberOfLines(String myfile) {
        int numberOfLines = 1;
        try {
            Path path = Paths.get("myFile2.txt");
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(lines.size());
            }
        } catch (IOException e) {
        numberOfLines = 0;
        } return numberOfLines;
    }
}




// Write a function that takes a filename as string,
// then returns the number of lines the file contains.
// It should return zero if it can't open the file, and
// should not raise any error.