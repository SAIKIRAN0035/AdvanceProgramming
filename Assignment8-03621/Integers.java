/*
Assignment 8(A)
* Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The sum of three integers is determined by this class by reading them from a file.
 */
 class Sum {
//@author Saikiran Reddy Yarava
    private String numeric;

    /**
     *Constructor of the class Sum.
     *
     * @param numeric The file path has three digits in it.
     */
    public Sum(String numeric) {
        this.numeric = numeric;
    }

    /**
     * retrieves three integers from the file, adds them up, and then outputs the result.
     *
     * @return adding three numbers from the file.
     * @throws IOException If there is an error read the  file.
     */
    public int calSum() throws IOException {
        int Add = 0;

        
        try (BufferedReader r = new BufferedReader(new FileReader(numeric))) {
            // Read the line containing three integers
            String line = r.readLine();

            // Split the line into individual numbers
            String[] count = line.split(" ");

            for (String numStr : count) {
                int num = Integer.parseInt(numStr);
                Add += num;
            }
        }

        return Add;
    }
}
//@author Saikiran Reddy Yarava
public class Integers {
    public static void main(String[] args) {
        // Create an instance of the Sum class and specifying  path
        Sum counts = new Sum("3nums.txt");

        try {
            int sum = counts.calSum();

            //  numbers from the file
            String count = getNumbersString("3nums.txt");

            // Displaying the result 
            System.out.println("Reading numbers from a given file..: " + count + " = " + sum);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
             // Handle an IllegalArgumentException if the file doesn't contain the expected format
            System.out.println(e.getMessage());
        }
    }
    /**
 * This method reads the content of a file and formats the numbers as a string.
 *
 * @param Path The path to the file containing numbers.
 * @return A formatted string containing the numbers separated by "+"
 * @throws IOException If there is an error reading the file.
 */

    public static String getNumbersString(String Path) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(Path))) {
            // Read the first line of the file, which contains numbers separated by spaces
            String line = r.readLine();
            String[] numbers = line.split(" ");
            StringBuilder count = new StringBuilder();

            for (int k = 0; k < numbers.length; k++) {
                if (k > 0) {
                     // Add " + " between numbers, but not before the first number
                    count.append(" + ");
                }
                count.append(numbers[k]);
            }

            return count.toString();
        }
    }
}
