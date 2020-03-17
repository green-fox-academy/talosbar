package postIt;

public class PostIt {
  String backgroundColor;
  String text;
  String textColor;


  public PostIt(String backgroundColor, String text, String textColor) {
    this.backgroundColor = backgroundColor;
    this.text = text;
    this.textColor = textColor;
  }

//  public String toString() {
//    return "This post it is " + this.backgroundColor + " and someone wrote '" + this.text + "' on it in " + this.textColor + " ink.";
//  }
//
//  public Boolean isSame(PostIt other) {
//    return this.text.equals(other.text);
//  }
}