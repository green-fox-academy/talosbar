import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ListIntroduction1 {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
//        int size = names.size();
//        System.out.println(size);

    names.add("William");

//        System.out.println("Is the list empty? " + names.isEmpty());
//        }

    names.add("John");
    names.add("Amanda");
//        System.out.println(names.size());
//        System.out.println(names.get(2));

//        Iterator indivItems = names.iterator();
//        while (indivItems.hasNext())
//        {
//            System.out.println(indivItems.next());

//        }
    for (int i = 0; i < names.size(); i++) {
      System.out.printf("%d. %s\n", i + 1, names.get(i));


    }
  }
}

