//It has an addBook() method where you can add books to the bookshelf.
//It has a getBooks() method which takes a year as a parameter, and returns books that were released in that year in the following format:
//{
//  <book title>: <author>,
//  <book title>: <author>,
//  <book title>: <author>,
//  <book title>: <author>
//}
//It has a getLightestAuthor() method that returns the author of the lightest book.
//It has a getMaxAuthor() method that returns the author who wrote the most pages.
//It has a printBooks() method that prints all the information about the books.

package Bookshelf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bookshelf {

  protected Map.Entry<String, Integer> maxEntry = null;
  protected ArrayList<Book> books;

  public Bookshelf() {
    this.books = new ArrayList<>();
  }

  public void addBook(Book newBook) {
    this.books.add(newBook);
  }

  public HashMap<String, String> getBooks(String givenReleaseYear) {
    HashMap<String, String> booksInTheYear = new HashMap<>();
    for (int i = 0; i < books.size(); i++) {
      if (givenReleaseYear.equals(books.get(i).getReleaseYear())) {
        booksInTheYear.put(books.get(i).getAuthor(), books.get(i).getTitle());
      }
    }
    return booksInTheYear;
  }

  public String getLightestAuthor() {
    Collections.sort(books);
    return books.get(0).getAuthor();
  }

  public String getMaxAuthor() {
    //végigmegyek a booksokon, és hashmapet csinálok a szerző nevekből és a hozzájuk tartozó oldalszámból
    HashMap<String, Integer> authorWithWrittenPages = new HashMap<>();
    for (Book book : books) {
      int holder = authorWithWrittenPages.getOrDefault(book.getAuthor(), 0);
      authorWithWrittenPages.put(book.getAuthor(), holder + book.getNumberOfPages());
    }
    for (Map.Entry<String, Integer> entry : authorWithWrittenPages.entrySet()) {
      if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
        maxEntry = entry;
      }
    }
    return maxEntry.getKey();
  }

  public String getTheLongestBook() {
    Book longestBook = books.get(0);
    for (Book book : books) {
      if (book.getNumberOfPages() > longestBook.getNumberOfPages()) {
        longestBook = book;
      }
    }
    return longestBook.getTitle();
  }

  public void printBooks() {
    for (Book book : books) {
      System.out.println(book.getBookInfo() + ", the number of pages of this book is: " + book.getNumberOfPages() + ", its weight is: " + book.weight + ".");
    }
  }
}