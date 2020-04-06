package Bookshelf;

public class Main {
  public static void main(String[] args) {
    HardcoverBook hb1 = new HardcoverBook("The hobbit", "Tolkien", "1937", 120);
    HardcoverBook hb2 = new HardcoverBook("Notes from Underground ", "Dostojevsky", "1864", 80);
    PaperbackBook pb1 = new PaperbackBook("Shadow over Innsmouth", "Lovecraft", "1920", 60);
    PaperbackBook pb2 = new PaperbackBook("Color out of space", "Lovecraft", "1925", 70);
    Bookshelf bookshelf = new Bookshelf();
    bookshelf.addBook(hb1);
    bookshelf.addBook(hb2);
    bookshelf.addBook(pb1);
    bookshelf.addBook(pb2);

    System.out.println(bookshelf.getBooks("1937"));
    bookshelf.printBooks();
    System.out.println(bookshelf.getLightestAuthor());
    System.out.println(bookshelf.getMaxAuthor());
    System.out.println(bookshelf.getTheLongestBook());
  }
}
