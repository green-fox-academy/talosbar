//The weight should be calculated from the number of pages (every page weighs 10 grams) plus the weight of the cover which is 20 grams.

package Bookshelf;

public class PaperbackBook extends Book {

  public PaperbackBook(String title, String author, String releaseYear, int numberOfPages) {
    super(title, author, releaseYear, numberOfPages);
    this.weight = numberOfPages * 10 + 20;
  }
}
