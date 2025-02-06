// WeightedSumOfDigits.java
// Author: SAIKITAN REDDY YARAVA
/*
Assignment 4(a)
Author: Saikiran Reddy Yarava
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number: 999903621
*/

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class WSD {

    public static void main(String[] args) {
        // To read user input, create a Scanner object.
        Scanner scanner = new Scanner(System.in);

    // Gather user input for a number.
        System.out.print("Enter a number between 20 and 10,000,000: ");

     // Verify that the input is a genuine number.
        while (!scanner.hasNextLong()) {
            System.out.println("Please enter a valid number.");
            System.out.print("Enter a number: ");
            scanner.next(); // consume the invalid input
        }
// Check the user-provided valid number.
        long number = scanner.nextLong();

     // Determine whether the number is within the given range.
        if (isValidRange(number)) {
         // Determine the weighted sum of digits.
            long weightedSum = calculateWeightedSum(number);
            System.out.println("Weighted Sum of Digits: " + weightedSum);
        } else {
            System.out.println("Number out of range. Exiting...");
        }
        scanner.close();
    }

    //Calculate the weighted sum of digits using this practical method: 
    private static long calculateWeightedSum(long number) {

        String numberString = String.valueOf(number);
        long weightedSum = 0;
// Calculate the weighted total after iterating over each digit.
        for (int i = 0; i < numberString.length(); i++) {
            int digit = Character.getNumericValue(numberString.charAt(i));
            weightedSum += digit * (i + 1);
        }

        return weightedSum;
    }

// Useful way to determine whether a given value is within an acceptable range.
    private static boolean isValidRange(long number) {
        return number >= 20 && number <= 10000000;
    }
}
