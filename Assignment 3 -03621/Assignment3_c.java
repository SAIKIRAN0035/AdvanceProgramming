/* 
Assignment 3(c)
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import java.util.Scanner;
import java.util.*;

public class Assignment3_c {
    public static void main(String[] args) {
        // Creating  a Scanner object to read input from the user 
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an input number
        System.out.print("Give a number to display the sum of digits as a single digit: ");
        int result = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Create an instance of the DigitSumCalculator class and use it to calculate the sum
        DigitSumCalculator calculator = new DigitSumCalculator();
        int sum = calculator.calculateSumOfDigits(result);

        // Print the sum as a single digit
        System.out.println("Display sum of Single digit: " + sum);
    }
}

class DigitSumCalculator {
    // Method to calculate the sum of digits until it becomes a single digit
    public int calculateSumOfDigits(int n) {
        int total = 0;
        
        // Adding until the total is a single digit.
        while (n > 0 || total >= 10) {
            if (n == 0) {
                n = total;
                total = 0;
            }
            // Increase the sum by the input number's last digit.
            total += n % 10;
            // Strip the input number's last digit.
            n /= 10;
        }

        return total;
    }
}
