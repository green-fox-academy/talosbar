public class conditionalVariableMutation {
    public static void main(String[] args) {


        double a = 24;
        int out = 0;
        if (a + out == out++) {
            System.out.println(out);
        }

        int b = 13;
        if (b > 10 && b < 20) {
            System.out.println("Sweet!");
        } else if (b > 10) {
            System.out.println("Less!");
        } else if (b > 20) {
            System.out.println("More");
        }


        int c = 123;
        int credits = 100;
        boolean isBonus = false;
        if (credits >= 50 && isBonus == false) {
            System.out.println(c - 2);
        } else if (credits < 50 && isBonus == false) {
            System.out.println(c--);
        } else if (isBonus == true) {
            System.out.println(c);
        }


        int d = 8;
        int time = 120;
        if (d % 4 == 0 && time <= 200) {
            System.out.println("check");
        } else if (time > 200) {
            System.out.println("Time out");
        } else {
            System.out.println("Run Forest Run!");
        }

    }
}