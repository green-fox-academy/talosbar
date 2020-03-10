public class CompareLength<j, i> {
    public static void main(String[] args) {

        int[] firstArrayOfNumbers = {1, 2, 3};
        int[] secondArrayOfNumbers = {4, 5};

        int firstArrayLength = firstArrayOfNumbers.length;
        int secondArrayLength = secondArrayOfNumbers.length;

        if (secondArrayLength > firstArrayLength) {
            System.out.println("secondArrayOfNumbers is longer");
        } else {
            System.out.println("firstArrayOfNumbers is longer");
        }


    }
}
