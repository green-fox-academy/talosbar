//Write a program which can store books in a bookshelf.
//
//    There are two types of books.
//
//    Book
//    Every book has a title, an author, a release year
//
//    Additionally they store the number of pages, and weight.
//
//    It has a getBookInfo() method that returns a string in the following format: author: title (year)
//
//    For example:J. K. Rowling: Harry Potter and the Philosopher's Stone (1997)

package Bookshelf;

public abstract class Book implements Comparable<Book>{

  private String title;
  private String author;
  private String releaseYear;
  private int numberOfPages;
  protected int weight;

  public Book(String title, String author, String releaseYear, int numberOfPages) {
    this.title = title;
    this.author = author;
    this.releaseYear = releaseYear;
    this.numberOfPages = numberOfPages;
  }

  public String getBookInfo() {
    return this.author + ": " + this.title + " (" + this.releaseYear + ")";
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getReleaseYear() {
    return releaseYear;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  @Override
  public int compareTo(Book otherBook) {
    return Integer.compare(this.weight, otherBook.weight);
  }
}