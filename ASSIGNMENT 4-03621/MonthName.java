/*
Assignment 4(a)
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621*/

import java.util.*;
import java.io.*;
public class MonthName
{
   // Method that takes an integer representing a month and returns the name of the month as a string.
    public static String month_name(int month)
    {
        // Create a variable to hold the month's name.
        String monthName;

        // Use a switch statement to determine the month name based on the input integer.
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                // Handle the case where the input is not a valid month number.
                monthName = "error";
                break;
        }

        // Return the determined month name.
        return monthName;
    }

    public static void main(String[] args)
    {
       // Run tests on the month_name method with various inputs and output the results.
        System.out.println("Month 1: " + month_name(1));
        System.out.println("Month 2: " + month_name(2));
        System.out.println("Month 3: " + month_name(3));
        System.out.println("Month 4: " + month_name(4));
        System.out.println("Month 5: " + month_name(5));
        System.out.println("Month 6: " + month_name(6));
        System.out.println("Month 7: " + month_name(7));
        System.out.println("Month 8: " + month_name(8));
        System.out.println("Month 9: " + month_name(9));
        System.out.println("Month 10: " + month_name(10));
        System.out.println("Month 11: " + month_name(11));
        System.out.println("Month 12: " + month_name(12));
        System.out.println("Month 43: " + month_name(43)); // Checking an incorrect input.
    }
}
