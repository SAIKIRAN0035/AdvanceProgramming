/*
Assignment 4(b)
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621*/

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class WeekdayCalculator {
    public static void main(String[] args) {
         // Create a scanner object for user input
        Scanner keyboard = new Scanner(System.in);

        // Introduction
        System.out.println("Welcome to MCIS5103's fantastic birth-o-meter!");
        System.out.println();
        System.out.println("All you have to do is enter your birth date, and it will");
        System.out.println("tell you the day of the week on which you were born.");
        System.out.println();

        // Testing with sample dates
        System.out.println("Some automatic tests....");
        System.out.println("12 10 2003 => " + weekday(12, 10, 2003));
        System.out.println(" 2 13 1976 => " + weekday(2, 13, 1976));
        System.out.println(" 2 13 1977 => " + weekday(2, 13, 1977));
        System.out.println(" 7  2 1974 => " + weekday(7, 2, 1974));
        System.out.println(" 1 15 2003 => " + weekday(1, 15, 2003));
        System.out.println("10 13 2000 => " + weekday(10, 13, 2000));
        System.out.println();

        // User input
        System.out.println("Now it's your turn!  What's your birthday?");
        System.out.print("Birth date (mm dd yyyy): ");
        int mm = keyboard.nextInt();
        int dd = keyboard.nextInt();
        int yyyy = keyboard.nextInt();

        // Call the weekday() function and print the result
        String Dob = weekday(mm, dd, yyyy);
        System.out.println("You were born on " + Dob + "!");
    }

    // Function to calculate the day of the week
    public static String weekday(int mm, int dd, int yyyy) {
        int yy, total;
        String date = "";

        yy = yyyy - 1900;
        total = yy / 4 + yy;
        total += dd;
        total += monthOffset(mm);

        // Adjust for leap years
        if (isLeap(yyyy) && (mm == 1 || mm == 2)) {
            total -= 1;
        }

        // Calculate the day of the week and format the date
        int dayOfWeekNumber = total % 7;
        String dayOfWeekName = weekdayName(dayOfWeekNumber);

        date = dayOfWeekName + ", " + monthName(mm) + " " + dd + ", " + yyyy;

        return date;
    }

// Gets the name of a month based on its number
    public static String monthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"
        };
        return monthNames[month - 1];
    }

    //Gets the month's offset to determine the day of the week.
    public static int monthOffset(int month) {
        int[] monthOffsets = {0, 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6, -1};
        return monthOffsets[month];
    }

    // Gets the name of the day of the week depending on its number
    public static String weekdayName(int dayOfWeekNumber) {
        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return daysOfWeek[dayOfWeekNumber];
    }

    // Checks whether a year is a leap year.
    public static boolean isLeap(int year) {
        boolean result;

        if (year % 400 == 0)
            result = true;
        else if (year % 100 == 0)
            result = false;
        else if (year % 4 == 0)
            result = true;
        else
            result = false;

        return result;
    }
}
