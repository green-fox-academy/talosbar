import static java.lang.System.*;

public class drawTriangle {
    public static void main (String[] args) {

        //i sorok száma, "println" a végén, mert az a sortöréses variable,
        //j a sorok hossza, sorban nincs sortörés, ezért csak "print",
        //olyan hosszú a sorom, ahányadik sorban vagyok.


        for (int i=1; i<6; i += 1) {
            for (int j = 1; j < i; j += 1) {
                System.out.print("*");
            } System.out.println();
        }
    }


}
