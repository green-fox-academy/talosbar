public class numbers {
    public static void main(String[] args) {


        String myFirstName = "Atanáz";
        String myLastName = "Tálos";
        System.out.println(myFirstName + " " + myLastName);
        int myAge = 30;
        System.out.println(myAge);
        double myHeight = 1.63;
        System.out.println(myHeight);


        int d = 22;
        int e = 13;
        System.out.println(d + e);
        System.out.println(e - d);
        System.out.println(d * e);
        System.out.println(d / e);
        int quotient = d / e;
        System.out.println("The Quotient is = " + quotient);
        int remainder = d / e;
        System.out.println("The Remainder is = " + remainder);


        int f = 6 * 5 * 17;
        System.out.println("An average Green Fox attendee codes " + f + " in a semester.");

        double g = ((double) 52 / 168) * 100;
        System.out.println("An average Green Fox attendee codes " + g + "% of theirs time.");


        int favoriteNumber = 13;
        System.out.println("My favorite number is: " + favoriteNumber);


        int a = 526;
        int b = 123;
        System.out.println(a);
        System.out.println(b);


        String myName = "Ati";
        System.out.println("My name is: " + myName);
        System.out.println("My age is: " + myAge);
        System.out.println("My height is: + myHeight");
        System.out.println("I am married: " + !true);
        System.out.println("I am divorced: " + !false);


        double massInKg = 81.2;
        double heightInM = 1.78;
        double BMI = massInKg / (heightInM * heightInM);
        System.out.println(BMI);


        int a2 = 3 + 8;
        int b2 = 100 - 94;
        int c2 = 44 * 2;
        int d2 = 125 / 5;
        int e2 = 8 * 8;
        System.out.println(a2);
        System.out.println(b2);
        System.out.println(c2);
        System.out.println(d2);
        System.out.println(e2);

        int f1 = 123;
        int f2 = 345;
        System.out.println(f1 > f2);

        int g1 = 350;
        int g2 = 200;
        System.out.println(g2 * 2 > g1);

        int h = 135798745;
        System.out.println(h %11 == 0);

        int i1 = 10;
        int i2 = 3;
        System.out.println((i1 > i2 * i2) && (i1 < i2 * i2 * i2));

        int j2 = 1521;
        System.out.println((j2 % 5 == 0) || (j2 % 3 == 0));


        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;
        int Second = 1;
        int Minute = 60 * Second;
        int Hour = 60 * 60 * Second;
        int Day = 24 * 60 * 60 * Second;
        int secondsUntilNow = (currentHours * Hour) + (currentMinutes * Minute) + (currentSeconds * Second);
        System.out.println("The remaining seconds from a day are: " + (Day - secondsUntilNow));


        int k = 2;
        int cuboidSide = k;
        int surfaceArea = k * k;
        int Volume = k * k * k;
        System.out.println("The surface area and volume of the cuboid: " + "Surface area: " + surfaceArea + "; Volume: " + Volume);

    }
}