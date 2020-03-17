package postIt;

//Create a postIt.PostIt class that has
//    a backgroundColor
//    a text on it
//    a textColor
//Create a few example post-it objects:
//    an orange with blue text: "Idea 1"
//    a pink with black text: "Awesome"
//    a yellow with green text: "Superb!"



public class Main {
  public static void main(String[] args) {
    PostIt post1 = new PostIt("orange", "Idea 1", "blue");
    PostIt post2 = new PostIt("pink", "Awesome", "black");
    PostIt post3 = new PostIt("yellow", "Superb!", "green");

//    System.out.println(post1.toString());
//    System.out.println(post2);
//    System.out.println(post3.text);
//
//    System.out.println(post1.isSame(post2));
//    System.out.println(post1.isSame(post1));
  }
}
