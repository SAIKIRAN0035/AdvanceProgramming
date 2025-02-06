/*
Assignment Bonus1
@Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import java.util.Random;
import java.util.Scanner;



// Main class responsible for managing user input and controlling the program flow.

public class Bonus1 {
/*
Assignment Bonus1
@Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

/* * Main method where the program starts its execution.
     * Creates an instance of the Bonus1 class and an instance of the Integer class,
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create an object for the main class Bonus1
        Bonus1 Object = new Bonus1();

        // Instantiate the Bonus1 class to create an instance for generating an array of random integers.
        Integer random = new Integer();

        // Displaying the randomly generated values stored in the array.
        random.displayValues();

       // Prompting the user to enter an integer for searching within the generated array.
Scanner scanner = new Scanner(System.in);
System.out.print("Please enter an integer that you want to search for in the array: ");

// Reading the user input as an integer
int userInput = scanner.nextInt();

// Searching through the array and counting occurrences of the user input

int occurrences = random.countOccurrences(userInput);


        // // Displaying the search result for the user-input integer and its occurrences in the generated array.
        System.out.println("The integer " + userInput + " appears " + occurrences + " time" + (occurrences != 1 ? "s" : "") + " in the array.");
    }
}

/**
 * Class to represent the array of random integers.
 * Generates a random array, displays values, and searches for occurrences.
 *
 * @author Saikiran Reddy yarava
 */
class Integer {
    private int[] array;

    /**
     * Constructor to initialize the array with random values.
     * Fills each slot with a different random value from the range 7-123.
     */
    public Integer() {
        array = new int[10];
        Random r = new Random();

        for (int i = 0; i < array.length; i++) {
            // Fill each slot with a different random value from the range 7-123
            array[i] = r.nextInt(117) + 7;
        }
    }

    /**
     * Displays the values of the generated array.
     */
    public void displayValues() {
        // Print a message indicating the purpose of the display
        System.out.println("Display the values of the generated array:");
         // Iterate through the array and print each value
        for (int value : array) {
            System.out.print(value + " ");
        }
        // Move to the next line after printing all values for better formatting
        System.out.println();
    }

    /**
     * Searches for a user-input integer in the array and counts occurrences.
     *
     * @param searchValue The integer to search for in the array.
     * @return The number of occurrences of the searchValue in the array.
     */
    public int countOccurrences(int searchValue) {
         // Initialize a counter to keep track of occurrences
        int count = 0;
// Iterate through the array to find and count occurrences of the specified searchValue
        for (int value : array) {
            if (value == searchValue) {
                count++;
            }
        }
// Return the total count of occurrences
        return count;
    }
}


