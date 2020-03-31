// - Create an array variable named `orders`
//   with the following content: `["first", "second", "third"]`
// - Swap the first and the third element of `orders`

public class SwapElements {
  public static void main(String[] args) {

    String orders[] = new String[] {"first", "second", "third"};
    String temp = orders[0];
    orders[0] = orders[2];
    orders[2] = temp;
    for (int i = 0; i < orders.length; i++) {
      System.out.println(orders[i]);
    }
//    String orders2[] = new String[] {orders[2], orders[1], orders[0]};
//    for (int i = 0; i < orders2.length; i++) {
//      System.out.println(orders2[i]);
//    }
  }
}
