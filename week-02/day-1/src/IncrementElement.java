public class IncrementElement {
    public static void main (String[] args) {

        int[] newArray = {1, 2, 3, 4, 5};
        for (int i = 2; i < 3; i++) {
            newArray[i] += 1;
            System.out.println(newArray[i]);
        }

    }
}
