public class ChangeElement {
    public static void main (String[] args) {

        int[] newArray = {1, 2, 3, 8, 5, 6};
        System.out.print("The new list is: ");
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == 8) {
                newArray[i] = 4;
            }
            System.out.print(newArray[i] + " ");
        }
    }
}
