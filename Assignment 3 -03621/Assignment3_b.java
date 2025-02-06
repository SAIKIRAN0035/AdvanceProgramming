/* 
Assignment 3(b)
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import java.util.Scanner;
import java.util.*;

public class Assignment3_b {
    public static void main(String[] args) {
        
        Scanner ob = new Scanner(System.in);

        // Prompt user for an input number
        System.out.print("Enter a number to display in reversed order: ");
        int num = ob.nextInt();

        // Close the scanner
        ob.close();

        // Create an instance of the NumberReverser class and use it to reverse the number
        NumberReverser reverser = new NumberReverser();
        int reversedNumber = reverser.reverseNumber(num);

        // Print the reversed number
        System.out.println("Displaying the reversed number: " + reversedNumber);
    }
}

class NumberReverser {
    // Method to reverse a number
    public int reverseNumber(int num) {
        int reversedNumber = 0;
        while (num != 0) {
            int digit = num % 10;
            reversedNumber = reversedNumber * 10 + digit;
            num /= 10;
        }
        return reversedNumber;
    }
}