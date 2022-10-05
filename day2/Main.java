package day2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int year = args.length > 0 ? Integer.parseInt(args[0]) : 2000;
        int numberOfLeapYears = args.length > 1 ? Integer.parseInt(args[1]) : 2;
        ArrayList<Integer> leapYears = getNLeapYears(year, numberOfLeapYears);
        displayLeapYears(leapYears);
    }

    public static void displayLeapYears(ArrayList<Integer> leapYears) {
        System.out.print("The next " + leapYears.size() + " leap years are: [");
        int numberOfLeapYears = leapYears.size();
        for (int i = 0; i < numberOfLeapYears; i++) {
            System.out.print(leapYears.get(i));
            if (i < leapYears.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static ArrayList<Integer> getNLeapYears(int year, int numberOfLeapYears) {
        ArrayList<Integer> leapYears = new ArrayList<Integer>();

        while (leapYears.size() < numberOfLeapYears) {
            if (isLeapYear(year)) {
                leapYears.add(year);
            }
            year++;
        }

        return leapYears;
    }
}
