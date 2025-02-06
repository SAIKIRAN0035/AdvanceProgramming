/*
Assignment 3(a)
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621*/

import java.util.Scanner;
import java.util.*;

public class Assignment3_a {
    public static void main(String[] args) {
        
        Scanner obj = new Scanner(System.in);
        
        // please give the valid decimal number
        System.out.print("Please give a valid decimal number: ");
        
        // read the entered decimal number
        int decimalNum = obj.nextInt();

        // Calling the function decimal to octal
        String octalNum = deciToOct(decimalNum);
        
        // print the octal number
        System.out.println("Octal equivalent: " + octalNum);
    }

    // function to convert the decimal to octal number
    public static String deciToOct(int decimalNum) {
       
        if (decimalNum == 0) {
            return "0";
        }

        // Create a StringBuilder to store the octal digits
        StringBuilder octal = new StringBuilder();
        
        // Convert decimal to octal by repeated division by 8
        while (decimalNum > 0) {
            int octalDigit = decimalNum % 8; // Calculate the octal digit
            octal.insert(0, octalDigit); 
            decimalNum = decimalNum/8; // Divide the decimal number by 8 to continue the process
        }

        // Convert the StringBuilder to a string and return the octal representation
        return octal.toString();
    }
}
